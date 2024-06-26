/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapi.garden.model

import org.openapi.garden.model.SearchResultsHits

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param query 
 * @param took 
 * @param hits 
 */


data class SearchResults (

    @Json(name = "query")
    val query: kotlin.String? = null,

    @Json(name = "took")
    val took: kotlin.Int? = null,

    @Json(name = "hits")
    val hits: SearchResultsHits? = null

)

