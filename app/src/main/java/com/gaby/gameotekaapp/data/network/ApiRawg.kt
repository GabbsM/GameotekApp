package com.gaby.gameotekaapp.data.network

import com.gaby.gameotekaapp.model.VideoJuegoDetalles

import com.gaby.gameotekaapp.model.ScreenshotResponse
import com.gaby.gameotekaapp.model.StoresResponse
import com.gaby.gameotekaapp.model.VideoJuegosListaResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRawg {

    //NOVEDADES POR FECHAS
    @GET("games?dates=2023-11-01,2023-12-30&platforms=18,1,7")
    suspend fun novedades(@Query("key") key: String): Response<VideoJuegosListaResponse>

    //JUEGO POR ID
    @GET("games/{gameId}")
    suspend fun obtenerDetallesJuego(@Path("gameId") gameId: Int, @Query("key") key: String): Response<VideoJuegoDetalles>

    //TODOS LOS JUEGOS
    @GET("games")
    suspend fun obtenerJuegos(@Query("key") key: String): Response<VideoJuegosListaResponse>

    @GET("games")
    suspend fun obtenerJuegosPorDeveloper(@Query("key") key: String, @Query("developers") id: Int): Response<VideoJuegosListaResponse>

    @GET("games")
    suspend fun obtenerJuegosPorPublisher(@Query("key") key: String, @Query("publishers") id: Int): Response<VideoJuegosListaResponse>

    //MAS POPULARES
    @GET("games?dates=2023-01-01,2023-12-31&ordering=-added")
    suspend fun masPopulares(@Query("key") key: String): Response<VideoJuegosListaResponse>


    //SCREENSHOTS
    @GET("games/{game_pk}/screenshots")
    fun getGameScreenshots(@Path("game_pk") gamePk: String, @Query("key") key: String): Call<ScreenshotResponse>

    //STORES
    @GET("games/{game_pk}/stores")
    fun getGameStores(@Path("game_pk") gamePk: String, @Query("key") key: String): Call<StoresResponse>


    //MAS VALORADOS
    @GET("games?dates=2023-01-01,2023-12-31&ordering=-rating")
    suspend fun masValorados(@Query("key") key: String): Response<VideoJuegosListaResponse>

    //PROXIMOS LANZAMIENTOS
    @GET("games?dates=2024-01-01,2024-01-31&platforms=18,1,7")
    suspend fun proximosLanzamientos(@Query("key") key: String): Response<VideoJuegosListaResponse>

}