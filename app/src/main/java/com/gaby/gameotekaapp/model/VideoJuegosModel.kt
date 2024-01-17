package com.gaby.gameotekaapp.model

import com.google.gson.annotations.SerializedName

data class VideoJuegosModel(

    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<VideoJuegoDetalles>
)

data class VideoJuegoDetalles(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
    @SerializedName("released") val fecha: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("website") val website: String,
    @SerializedName("metacritic") val metacritic: Int,
    @SerializedName("developers") val developers: List<ListaDevelopers>,
    @SerializedName("publishers") val publishers: List<ListaPublishers>,
    @SerializedName("platforms") val platforms: List<PlatformWrapper>,
    @SerializedName("genres") val genres: List<ListaGeneros>,
    @SerializedName("screenshots") val screenshots: List<Screenshot>,
    @SerializedName("stores") val stores: List<Store>,
    @SerializedName("description") val description: String,


)


//DEVELOPERS
data class  Developers(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<ListaDevelopers>

)
data class ListaDevelopers (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
)

//PUBLISHERS
data  class Publishers(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<ListaPublishers>
)

data class ListaPublishers (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
)


//GENEROS

data class  Generos(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<ListaGeneros>
)

data class ListaGeneros (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
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
//PLATAFORMAS


data class PlatformWrapper (
    @SerializedName("platform") val platform: Platform,
    @SerializedName("released_at") val releasedAt: String
)

data class Platform (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String
)



//STORES

data class Stores(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<ListaStores>
)

data class ListaStores (
    @SerializedName("id") val id: Int,
    @SerializedName("domain") val domain: String,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
)

//TAGS

data class  Tags(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<ListaTags>
)

data class ListaTags (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
    @SerializedName("language") val lenguaje: String
)



