package com.gaby.gameotekaapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaby.gameotekaapp.data.network.RetrofitClient
import com.gaby.gameotekaapp.model.ListaVideojuegos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RawGViewModel: ViewModel (){

    private val _juegos = MutableStateFlow<List<ListaVideojuegos>>(emptyList())
    val juegos  = _juegos.asStateFlow()

    private val _novedades = MutableStateFlow<List<ListaVideojuegos>>(emptyList())
    val novedades  = _novedades.asStateFlow()

    private val _masValorados = MutableStateFlow<List<ListaVideojuegos>>(emptyList())
    val masValorados  = _masValorados.asStateFlow()

    private val _proximosLanzamientos = MutableStateFlow<List<ListaVideojuegos>>(emptyList())
    val proximosLanzamientos  = _proximosLanzamientos.asStateFlow()



    init {
        obtenerjuegos()
        novedades()
        masValorados()
        proximosLanzamientos()

    }

    private fun obtenerjuegos() {
        viewModelScope.launch (Dispatchers.IO){
            withContext(Dispatchers.Main){
                val response = RetrofitClient.retrofit.obtenerJuegos()
                _juegos.value = response.body()?.results ?: emptyList()

            }
        }
    }


    private fun novedades() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val response = RetrofitClient.retrofit.novedades()
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
                val response = RetrofitClient.retrofit.masValorados()
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
                val response = RetrofitClient.retrofit.proximosLanzamientos()
                _proximosLanzamientos.value = response.body()?.results ?: emptyList()

            }
        }
    }
}