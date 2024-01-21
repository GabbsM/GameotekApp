package com.gaby.gameotekaapp.model

import com.google.gson.annotations.SerializedName


data class VideoJuegoDetalles(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
    @SerializedName("released") val fecha: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("website") val website: String,
    @SerializedName("metacritic") val metacritic: Int,
    @SerializedName("developers") val developers: List<Developer>,
    @SerializedName("publishers") val publishers: List<Publisher>,
    @SerializedName("platforms") val platforms: List<PlatformWrapper>,
    @SerializedName("genres") val genres: List<Genero>,
    @SerializedName("screenshots") val screenshots: List<Screenshot>,
    @SerializedName("stores") val stores: List<Store>,
    @SerializedName("description") val description: String
)

data class Developer (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("image_background") val imagen: String,
)

data class Publisher (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
)

data class Genero (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
)

data class PlatformWrapper (
    @SerializedName("platform") val platform: Platform,
    @SerializedName("released_at") val releasedAt: String
)

data class Platform (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String
)

//STORES

data class StoresResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Store>
)

data class Store (
    @SerializedName("id") val id: Int,
    @SerializedName("store_id") val store_id: Int,
    @SerializedName("url") val url: String,
)

//SCREENSHOTS
data class ScreenshotResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Screenshot>
)
data class Screenshot(
    val image: String,
    val hidden: Boolean
)

