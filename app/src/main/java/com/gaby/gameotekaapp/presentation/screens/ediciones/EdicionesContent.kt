package com.gaby.gameotekaapp.presentation.screens.ediciones

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.RawgViewModelFilteredList

@Composable
fun EdicionesContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    viewModel: RawgViewModelFilteredList
) {

    val listaJuegosFiltrada by viewModel.listaDeJuegosFiltrada.collectAsState()
    val scrollState = rememberScrollState()

    Text(text = "Hola")



}
