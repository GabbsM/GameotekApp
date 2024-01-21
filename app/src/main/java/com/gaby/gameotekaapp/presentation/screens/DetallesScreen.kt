package com.gaby.gameotekaapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.components.DefaultTopBar
import com.gaby.gameotekaapp.presentation.components.NavegacionInferior
import com.gaby.gameotekaapp.presentation.contents.DetallesContent
import com.gaby.gameotekaapp.presentation.viewModels.DetallesViewModel

@Composable
fun detallesScreen(navHostController: NavHostController, viewModel: DetallesViewModel, gameId: Int) {

    Scaffold(
        topBar = {  DefaultTopBar(title = "GameOTeka", upAvailable = false, navController = navHostController,color= Color.White) },
        content = { paddingValues ->
            Column {
                Spacer(modifier = Modifier.height(56.dp)) // Añade un espacio de 56.dp que es la altura típica de una TopBar

                DetallesContent(
                    paddingValues = paddingValues,
                    navHostController = navHostController,
                    viewModel = viewModel
                )
            }
        },
        bottomBar = { NavegacionInferior(navHostController)  }
    )
}
// contents
//    DescubreContent
//    DetallesJuegosContent
// screens
//    DescubreScreen
//    DetallesJuegosScreen
// viewModel
//    DescubreViewModel
//    DetallesJuegoViewModel