package me.window

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager
import com.sedmelluq.discord.lavaplayer.player.FunctionalResultHandler
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers
import com.sedmelluq.discord.lavaplayer.source.http.HttpAudioSourceManager
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException
import com.sedmelluq.discord.lavaplayer.track.AudioTrack
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.audio.AudioSendHandler
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.utils.cache.CacheFlag
import org.json.JSONObject
import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

class Main(private val playerManager: AudioPlayerManager, private val player: AudioPlayer) : ListenerAdapter() {
    private var currentSong = ""

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        when (event.name) {
            "play" -> {
                if (event.member?.voiceState?.inAudioChannel() == true) {
                    var name = event.getOption("radio")!!.asString
                    if (event.getOption("id")?.asBoolean != true) {
                        val client: HttpClient = HttpClient.newHttpClient()
                        val request: HttpRequest = HttpRequest.newBuilder()
                            .uri(
                                URI.create(
                                    "http://radio.garden/api/search?q=${
                                        URLEncoder.encode(
                                            name,
                                            StandardCharsets.UTF_8
                                        )
                                    }"
                                )
                            )
                            .build()

                        try {
                            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                                .thenApply {
                                    name = JSONObject(it.body()).getJSONObject("hits").getJSONArray("hits")
                                        .getJSONObject(0)
                                        .getJSONObject("_source").getString("url").split("/").last()
                                }
                                .join()
                        } catch (e: Exception) {
                            println("ERROR!")
                            println(e)
                        }
                    }

                    if(currentSong != name) playerManager.loadItem("http://radio.garden/api/ara/content/listen/$name/channel.mp3",
                        FunctionalResultHandler(
                            { track: AudioTrack ->
                                currentSong = name
                                event.guild!!.audioManager.openAudioConnection(event.member!!.voiceState!!.channel)
                                player.playTrack(track)
                                val client: HttpClient = HttpClient.newHttpClient()
                                val request: HttpRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("http://radio.garden/api/ara/content/channel/$name"))
                                    .build()

                                try {
                                    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                                        .thenApply {
                                            val json = JSONObject(it.body()).getJSONObject("data")
                                            event.reply(
                                                "Listening to radio [${json.getString("title")}](${
                                                    json.getString(
                                                        "website"
                                                    )
                                                }) (${json.getString("id")})"
                                            ).queue()
                                        }
                                        .join()
                                } catch (e: Exception) {
                                    println("ERROR!")
                                    println(e)
                                }
                            }, null,
                            {
                                event.interaction.reply("Error!")
                            },
                            { e: FriendlyException ->
                                e.printStackTrace()
                            }
                        ))
                    else event.reply("Already listening to this radio").queue()
                    event.guild!!.audioManager.sendingHandler = AudioPlayerSendHandler(player)
                } else {
                    event.reply("You must be in a call to play a radio!").queue()
                }
            }

            "leave" -> {
                if (event.guild!!.audioManager.isConnected &&
                    event.member?.voiceState?.inAudioChannel() == true &&
                    event.member?.voiceState?.channel == event.guild!!.audioManager.connectedChannel
                ) {
                    event.guild?.audioManager?.closeAudioConnection()
                    player.stopTrack()
                    event.reply("Left the call!").queue()
                } else {
                    event.reply("You must be in the same call as the bot!").queue()
                }
            }
        }
    }
}

class AudioPlayerSendHandler(private val audioPlayer: AudioPlayer) : AudioSendHandler {
    private var lastFrame: AudioFrame? = null

    override fun canProvide(): Boolean {
        lastFrame = audioPlayer.provide()
        return lastFrame != null
    }

    override fun provide20MsAudio(): ByteBuffer? {
        return ByteBuffer.wrap(lastFrame!!.data)
    }

    override fun isOpus(): Boolean {
        return true
    }
}

fun main(args: Array<String>) {
    val playerManager: AudioPlayerManager = DefaultAudioPlayerManager()
    playerManager.registerSourceManager(HttpAudioSourceManager())
    AudioSourceManagers.registerRemoteSources(playerManager)

    val jda = JDABuilder.createDefault(args[0])
        .enableCache(CacheFlag.VOICE_STATE)
        .setBulkDeleteSplittingEnabled(false)
        .addEventListeners(Main(playerManager, playerManager.createPlayer()))
        .setActivity(Activity.listening("the radio"))
        .build()

    jda.updateCommands().addCommands(
        Commands.slash("play", "Select the radio to play")
            .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.VOICE_START_ACTIVITIES))
            .setGuildOnly(true) // Ban command only works inside a guild
            .addOption(OptionType.STRING, "radio", "The name/id of the radio station", true)
            .addOption(OptionType.BOOLEAN, "id", "Is the name specified an id? (go to radio.garden to find the id at the end of the url)"),
        Commands.slash("leave", "Leave the call")
            .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.VOICE_START_ACTIVITIES))
            .setGuildOnly(true) // Ban command only works inside a guild
    ).queue()
}
