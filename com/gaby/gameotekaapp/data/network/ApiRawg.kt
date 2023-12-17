package com.gaby.gameotekaapp.data.network

import com.gaby.gameotekaapp.model.VideoJuegoModel
import com.gaby.gameotekaapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiRawg {

   @GET("games${Constants.API_KEY}&dates=2023-01-01,2023-12-31&ordering=-added")
   suspend fun obtenerJuegos(): Response<VideoJuegoModel>

    @GET("games${Constants.API_KEY}&dates=2023-11-01,2023-12-30&platforms=18,1,7")
    suspend fun novedades(): Response<VideoJuegoModel>

    @GET("games${Constants.API_KEY}&dates=2023-01-01,2023-12-31&ordering=-rating")
    suspend fun masValorados(): Response<VideoJuegoModel>

    @GET("games${Constants.API_KEY}&dates=2024-01-01,2024-01-31&platforms=18,1,7")
    suspend fun proximosLanzamientos(): Response<VideoJuegoModel>









}