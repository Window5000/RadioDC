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

import org.openapi.garden.model.Cities
import org.openapi.garden.model.CountryPopularStations
import org.openapi.garden.model.LeftPageRef
import org.openapi.garden.model.LocalPickStations
import org.openapi.garden.model.LocalPopularStations
import org.openapi.garden.model.NearbyPlaces
import org.openapi.garden.model.PlaceRef
import org.openapi.garden.model.SelectedStations

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param title 
 * @param type 
 * @param itemsType 
 * @param items 
 * @param actionPage 
 * @param actionText 
 * @param rightAccessory 
 */


data class PlaceContentContentInner (

    @Json(name = "title")
    val title: kotlin.String? = null,

    @Json(name = "type")
    val type: kotlin.String? = null,

    @Json(name = "itemsType")
    val itemsType: kotlin.String? = null,

    @Json(name = "items")
    val items: kotlin.collections.List<LeftPageRef>? = null,

    @Json(name = "actionPage")
    val actionPage: PlaceRef? = null,

    @Json(name = "actionText")
    val actionText: kotlin.String? = null,

    @Json(name = "rightAccessory")
    val rightAccessory: kotlin.String? = null

)

