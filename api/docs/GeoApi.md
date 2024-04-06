# GeoApi

All URIs are relative to *http://radio.garden/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**geoGet**](GeoApi.md#geoGet) | **GET** /geo | Get the client&#39;s geolocation


<a id="geoGet"></a>
# **geoGet**
> Geolocation geoGet()

Get the client&#39;s geolocation

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapi.garden.model.*

val apiInstance = GeoApi()
try {
    val result : Geolocation = apiInstance.geoGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GeoApi#geoGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GeoApi#geoGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Geolocation**](Geolocation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

