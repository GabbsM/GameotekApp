package com.gaby.gameotekaapp.presentation.screens.myGameoteka

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.components.DefaultTopBar
import com.gaby.gameotekaapp.presentation.components.NavegacionInferior
import com.gaby.gameotekaapp.presentation.screens.home.components.HomeContent
import com.gaby.gameotekaapp.presentation.RawGViewModel
import com.gaby.gameotekaapp.presentation.screens.myGameoteka.components.MyGameOtekaContent

@Composable
fun MyGameoTekaScreen(navController : NavHostController, viewModel: RawGViewModel) {

    Scaffold(
        topBar = {  DefaultTopBar(tittle = "GameOTeka", upAvailable = false, navController = navController,color= Color.White) },
        content = { paddingValues ->
            Column {
                Spacer(modifier = Modifier.height(56.dp)) // Añade un espacio de 56.dp que es la altura típica de una TopBar

                MyGameOtekaContent(paddingValues = paddingValues, navHostController = navController, viewModel = viewModel)
            }
        },
        bottomBar = { NavegacionInferior(navController)  }
    )

}