# PlacesApi

All URIs are relative to *http://radio.garden/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**araContentPagePlaceIdChannelsGet**](PlacesApi.md#araContentPagePlaceIdChannelsGet) | **GET** /ara/content/page/{placeId}/channels | Get a place&#39;s registered radio stations
[**araContentPagePlaceIdGet**](PlacesApi.md#araContentPagePlaceIdGet) | **GET** /ara/content/page/{placeId} | Get a place&#39;s details
[**araContentPlacesGet**](PlacesApi.md#araContentPlacesGet) | **GET** /ara/content/places | Get places with registered radio stations


<a id="araContentPagePlaceIdChannelsGet"></a>
# **araContentPagePlaceIdChannelsGet**
> AraContentPagePlaceIdChannelsGet200Response araContentPagePlaceIdChannelsGet(placeId)

Get a place&#39;s registered radio stations

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapi.garden.model.*

val apiInstance = PlacesApi()
val placeId : kotlin.String = placeId_example // kotlin.String | ID of place to use
try {
    val result : AraContentPagePlaceIdChannelsGet200Response = apiInstance.araContentPagePlaceIdChannelsGet(placeId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PlacesApi#araContentPagePlaceIdChannelsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PlacesApi#araContentPagePlaceIdChannelsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **placeId** | **kotlin.String**| ID of place to use |

### Return type

[**AraContentPagePlaceIdChannelsGet200Response**](AraContentPagePlaceIdChannelsGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="araContentPagePlaceIdGet"></a>
# **araContentPagePlaceIdGet**
> AraContentPagePlaceIdGet200Response araContentPagePlaceIdGet(placeId)

Get a place&#39;s details

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapi.garden.model.*

val apiInstance = PlacesApi()
val placeId : kotlin.String = placeId_example // kotlin.String | ID of place to use
try {
    val result : AraContentPagePlaceIdGet200Response = apiInstance.araContentPagePlaceIdGet(placeId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PlacesApi#araContentPagePlaceIdGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PlacesApi#araContentPagePlaceIdGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **placeId** | **kotlin.String**| ID of place to use |

### Return type

[**AraContentPagePlaceIdGet200Response**](AraContentPagePlaceIdGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="araContentPlacesGet"></a>
# **araContentPlacesGet**
> AraContentPlacesGet200Response araContentPlacesGet()

Get places with registered radio stations

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapi.garden.model.*

val apiInstance = PlacesApi()
try {
    val result : AraContentPlacesGet200Response = apiInstance.araContentPlacesGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PlacesApi#araContentPlacesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PlacesApi#araContentPlacesGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AraContentPlacesGet200Response**](AraContentPlacesGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

