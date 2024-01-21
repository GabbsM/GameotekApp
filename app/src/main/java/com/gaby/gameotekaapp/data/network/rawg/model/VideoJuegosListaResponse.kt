package com.gaby.gameotekaapp.data.network.rawg.model

import com.google.gson.annotations.SerializedName

data class VideoJuegosListaResponse(

    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<VideoJuegoListaItem>
)

data class VideoJuegoListaItem(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val nombre: String,
    @SerializedName("background_image") val imagen: String
)
