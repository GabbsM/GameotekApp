package com.gaby.gameotekaapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaby.gameotekaapp.data.network.RetrofitClient
import com.gaby.gameotekaapp.model.VideoJuegoDetalles
import com.gaby.gameotekaapp.model.ScreenshotResponse
import com.gaby.gameotekaapp.model.StoresResponse
import com.gaby.gameotekaapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RawGViewModelDetail(gameId: Int?)  : ViewModel() {

    private val _juegoSeleccionado = MutableStateFlow<VideoJuegoDetalles?>(null)
    val juegoSeleccionado = _juegoSeleccionado.asStateFlow()

    private val _screenshots = MutableStateFlow<List<String>?>(null)
    val screenshots = _screenshots.asStateFlow()

    private val _stores = MutableStateFlow<List<String>?>(null)
    val stores = _stores.asStateFlow()


    init {
        obtenerDetallesJuego(gameId)
        getGameScreenshots(gameId.toString())
        getStores(gameId.toString())


    }

    fun obtenerDetallesJuego(gameId: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (gameId != null) {
                val response = RetrofitClient.retrofit.obtenerDetallesJuego(gameId, Constants.API_KEY)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        _juegoSeleccionado.value = response.body()
                        if (_juegoSeleccionado.value != null) {
                            println("Respuesta de juegos:${response.code()},${response.message()}")
                            println("El juego con ID: $gameId se ha encontrado")
                            println("Nombre: ${_juegoSeleccionado.value?.nombre}")
                            println("Puntuacion metracritic: ${_juegoSeleccionado.value?.metacritic}")
                            println("Fecha de lanzamiento: ${_juegoSeleccionado.value?.fecha}")
                            println("Rating: ${_juegoSeleccionado.value?.rating}")
                        } else {
                            println("El juego con ID: $gameId no se encontró en la respuesta de la API.")
                        }
                    } else {
                        println("Error al obtener respuesta de juegos:${response.code()},${response.message()}")
                    }
                }
            }
        }
    }

    fun getGameScreenshots(gamePk: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = RetrofitClient.retrofit.getGameScreenshots(gamePk, Constants.API_KEY)
            call.enqueue(object : Callback<ScreenshotResponse> {
                override fun onResponse(
                    call: Call<ScreenshotResponse>,
                    response: Response<ScreenshotResponse>
                ) {
                    viewModelScope.launch(Dispatchers.Main) {
                        handleResponse(response)
                    }
                }

                override fun onFailure(call: Call<ScreenshotResponse>, t: Throwable) {
                    println("Error al obtener respuesta de screenshots: ${t.message}")
                }
            })
        }
    }

    fun getStores(gamePk: String){
        viewModelScope.launch(Dispatchers.IO) {
            val call = RetrofitClient.retrofit.getGameStores(gamePk, Constants.API_KEY)
            call.enqueue(object : Callback<StoresResponse> {
                override fun onResponse(
                    call: Call<StoresResponse>,
                    response: Response<StoresResponse>
                ) {
                    viewModelScope.launch(Dispatchers.Main) {
                        handleResponse2(response)
                    }
                }

                override fun onFailure(call: Call<StoresResponse>, t: Throwable) {
                    println("Error al obtener respuesta de stores: ${t.message}")
                }
            })
        }
    }

    private suspend fun handleResponse(response: Response<ScreenshotResponse>) {
        withContext(Dispatchers.Main) {
            if (response.isSuccessful) {
                println("Respuesta de screenshots:${response.code()},${response.message()}")
                val screenshotUrls = response.body()?.results?.map { it.image }
                _screenshots.value = screenshotUrls
                println("Screenshots: $screenshotUrls")
            } else {
                println("Error al obtener respuesta de screenshots:${response.code()},${response.message()}")
            }
        }
    }

    private suspend fun handleResponse2(response: Response<StoresResponse>) {
        withContext(Dispatchers.Main) {
            if (response.isSuccessful) {
                println("Respuesta de store:${response.code()},${response.message()}")
                val storeUrls = response.body()?.results?.map { it.url }
                _stores.value = storeUrls
                println("Screenshots: $storeUrls")
            } else {
                println("Error al obtener respuesta de screenshots:${response.code()},${response.message()}")
            }
        }
    }



}

