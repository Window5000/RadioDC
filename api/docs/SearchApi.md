# SearchApi

All URIs are relative to *http://radio.garden/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchGet**](SearchApi.md#searchGet) | **GET** /search | Search for countries, places, and radio stations


<a id="searchGet"></a>
# **searchGet**
> SearchGet200Response searchGet(q)

Search for countries, places, and radio stations

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapi.garden.model.*

val apiInstance = SearchApi()
val q : kotlin.String = q_example // kotlin.String | Search query
try {
    val result : SearchGet200Response = apiInstance.searchGet(q)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SearchApi#searchGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SearchApi#searchGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **kotlin.String**| Search query |

### Return type

[**SearchGet200Response**](SearchGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

