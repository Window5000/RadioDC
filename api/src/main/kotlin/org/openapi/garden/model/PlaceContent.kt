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

import org.openapi.garden.model.PlaceContentContentInner

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param content 
 */


data class PlaceContent (

    @Json(name = "content")
    val content: kotlin.collections.List<PlaceContentContentInner>? = null

)

