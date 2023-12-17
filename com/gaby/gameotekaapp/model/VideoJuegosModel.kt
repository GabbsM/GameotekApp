package com.gaby.gameotekaapp.model

import com.google.gson.annotations.SerializedName

data class VideoJuegoModel(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<ListaVideojuegos>
)

data class ListaVideojuegos(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String,
    @SerializedName("released") val fecha: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("metacritic") val metacritic: Int,
    @SerializedName("platforms") val plataformas: List<Plataformas>,

)

data class Plataformas (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String

)


