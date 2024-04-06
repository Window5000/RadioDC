# ChannelsApi

All URIs are relative to *http://radio.garden/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**araContentChannelChannelIdGet**](ChannelsApi.md#araContentChannelChannelIdGet) | **GET** /ara/content/channel/{channelId} | Get a radio station&#39;s details
[**araContentListenChannelIdChannelMp3Get**](ChannelsApi.md#araContentListenChannelIdChannelMp3Get) | **GET** /ara/content/listen/{channelId}/channel.mp3 | Get a radio station&#39;s live broadcast stream
[**araContentListenChannelIdChannelMp3Head**](ChannelsApi.md#araContentListenChannelIdChannelMp3Head) | **HEAD** /ara/content/listen/{channelId}/channel.mp3 | Get a radio station&#39;s live broadcast stream


<a id="araContentChannelChannelIdGet"></a>
# **araContentChannelChannelIdGet**
> AraContentChannelChannelIdGet200Response araContentChannelChannelIdGet(channelId)

Get a radio station&#39;s details

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapi.garden.model.*

val apiInstance = ChannelsApi()
val channelId : kotlin.String = channelId_example // kotlin.String | ID of radio station to use
try {
    val result : AraContentChannelChannelIdGet200Response = apiInstance.araContentChannelChannelIdGet(channelId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ChannelsApi#araContentChannelChannelIdGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ChannelsApi#araContentChannelChannelIdGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **channelId** | **kotlin.String**| ID of radio station to use |

### Return type

[**AraContentChannelChannelIdGet200Response**](AraContentChannelChannelIdGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="araContentListenChannelIdChannelMp3Get"></a>
# **araContentListenChannelIdChannelMp3Get**
> araContentListenChannelIdChannelMp3Get(channelId)

Get a radio station&#39;s live broadcast stream

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapi.garden.model.*

val apiInstance = ChannelsApi()
val channelId : kotlin.String = channelId_example // kotlin.String | ID of radio station to use
try {
    apiInstance.araContentListenChannelIdChannelMp3Get(channelId)
} catch (e: ClientException) {
    println("4xx response calling ChannelsApi#araContentListenChannelIdChannelMp3Get")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ChannelsApi#araContentListenChannelIdChannelMp3Get")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **channelId** | **kotlin.String**| ID of radio station to use |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a id="araContentListenChannelIdChannelMp3Head"></a>
# **araContentListenChannelIdChannelMp3Head**
> araContentListenChannelIdChannelMp3Head(channelId)

Get a radio station&#39;s live broadcast stream

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapi.garden.model.*

val apiInstance = ChannelsApi()
val channelId : kotlin.String = channelId_example // kotlin.String | ID of radio station to use
try {
    apiInstance.araContentListenChannelIdChannelMp3Head(channelId)
} catch (e: ClientException) {
    println("4xx response calling ChannelsApi#araContentListenChannelIdChannelMp3Head")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ChannelsApi#araContentListenChannelIdChannelMp3Head")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **channelId** | **kotlin.String**| ID of radio station to use |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

