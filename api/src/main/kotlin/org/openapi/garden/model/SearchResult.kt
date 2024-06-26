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

import org.openapi.garden.model.SearchResultSource

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param id 
 * @param score 
 * @param source 
 */


data class SearchResult (

    @Json(name = "_id")
    val id: kotlin.String? = null,

    @Json(name = "_score")
    val score: kotlin.Float? = null,

    @Json(name = "_source")
    val source: SearchResultSource? = null

)

