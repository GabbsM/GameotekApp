package com.gaby.gameotekaapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaby.gameotekaapp.data.network.RetrofitClient
import com.gaby.gameotekaapp.model.VideoJuegoListaItem
import com.gaby.gameotekaapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RawgViewModelFilteredList(developerId: Int? = null, publisherId: Int? = null) : ViewModel(){


    private val _listDeJuegosFiltrada = MutableStateFlow<List<VideoJuegoListaItem>?>(null)
    val listaDeJuegosFiltrada = _listDeJuegosFiltrada.asStateFlow()

    init {
        // TODO: create a Filter class to hold different filter params and use it as argument here
        obtenerJuegosPorDeveloper(developerId, publisherId)
    }

    private fun obtenerJuegosPorDeveloper(developerId: Int?, publisherId: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = if (developerId != null) {
                RetrofitClient.retrofit.obtenerJuegosPorDeveloper(Constants.API_KEY, developerId)
            } else if (publisherId != null) {
                RetrofitClient.retrofit.obtenerJuegosPorPublisher(Constants.API_KEY, publisherId)
            } else {
                null
            }

            withContext(Dispatchers.Main) {
                if (response!!.isSuccessful) {
                    _listDeJuegosFiltrada.value = response.body()?.results

                }
            }
        }
    }
}