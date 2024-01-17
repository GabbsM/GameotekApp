package com.gaby.gameotekaapp.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gaby.gameotekaapp.presentation.RawGViewModelList
import com.gaby.gameotekaapp.presentation.components.DefaultTopBar
import com.gaby.gameotekaapp.presentation.components.NavegacionInferior
import com.gaby.gameotekaapp.presentation.screens.descubre.DescubreContent
import com.gaby.gameotekaapp.presentation.screens.home.components.HomeContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(navController : NavHostController, viewModel: RawGViewModelList) {

    Scaffold(
        topBar = {  DefaultTopBar(tittle = "GameOTeka", upAvailable = false, navController = navController,color= Color.White) },
        content = { paddingValues ->
            Column {
                Spacer(modifier = Modifier.height(56.dp)) // Añade un espacio de 56.dp que es la altura típica de una TopBar

                HomeContent(paddingValues = paddingValues, navHostController = navController, viewModel = viewModel)
            }
        },
        bottomBar = { NavegacionInferior(navController)  }
    )

}
