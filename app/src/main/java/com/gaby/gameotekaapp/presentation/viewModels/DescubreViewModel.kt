package com.gaby.gameotekaapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaby.gameotekaapp.data.network.RetrofitClient
import com.gaby.gameotekaapp.data.network.rawg.model.VideoJuegoListaItem
import com.gaby.gameotekaapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DescubreViewModel: ViewModel() {


    private val _juegos = MutableStateFlow<List<VideoJuegoListaItem>>(emptyList())
    val juegos = _juegos.asStateFlow()

    private val _novedades = MutableStateFlow<List<VideoJuegoListaItem>>(emptyList())
    val novedades  = _novedades.asStateFlow()

    private val _masValorados = MutableStateFlow<List<VideoJuegoListaItem>>(emptyList())
    val masValorados  = _masValorados.asStateFlow()

    private val _proximosLanzamientos = MutableStateFlow<List<VideoJuegoListaItem>>(emptyList())
    val proximosLanzamientos  = _proximosLanzamientos.asStateFlow()


    init {
        masPopulares()
        novedades()
        masValorados()
        proximosLanzamientos()

    }

    private fun masPopulares(){
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val response = RetrofitClient.apiRawg.masPopulares(Constants.RAWG_API_KEY)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        _juegos.value = response.body()?.results ?: emptyList()

                    } else {
                        println("Error al obtener respuesta de juegos:${response.code()},${response.message()}")
                    }
                }
            }
        }
    }

    private fun novedades() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val response = RetrofitClient.apiRawg.novedades(Constants.RAWG_API_KEY)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        _novedades.value = response.body()?.results ?: emptyList()

                    }else{
                        println("Error al obtener respuesta de novedades:${response.code()},${response.message()}")
                    }
                }
            }
        }
    }
    private fun masValorados() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val response = RetrofitClient.apiRawg.masValorados(Constants.RAWG_API_KEY)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        _masValorados.value = response.body()?.results ?: emptyList()

                    }else{
                        println("Error al obtener respuesta de masValorad0s:${response.code()},${response.message()}")
                    }
                }
            }
        }
    }

    private fun proximosLanzamientos() {
        viewModelScope.launch (Dispatchers.IO){
            withContext(Dispatchers.Main){
                val response = RetrofitClient.apiRawg.proximosLanzamientos(Constants.RAWG_API_KEY)
                _proximosLanzamientos.value = response.body()?.results ?: emptyList()

            }
        }
    }

}