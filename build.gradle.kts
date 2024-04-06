plugins {
    kotlin("jvm") version "1.9.23"
    id ("org.openapi.generator") version "7.2.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.window"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://m2.dv8tion.net/releases")
    }
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.21")
    implementation(project(":api"))
    implementation("com.sedmelluq:lavaplayer:1.3.77")
    implementation("org.json:json:20240303")
}

tasks.build {
    dependsOn(tasks.openApiGenerate)
}

openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set("$rootDir/spec.json")
    outputDir.set("$rootDir/api")
    apiPackage.set("org.openapi.garden.api")
    invokerPackage.set("org.openapi.garden.invoker")
    modelPackage.set("org.openapi.garden.model")
    configOptions.set(mapOf(Pair("dateLibrary", "java8")))
}