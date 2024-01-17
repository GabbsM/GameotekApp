package com.gaby.gameotekaapp.presentation.screens.ediciones

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.RawGViewModelList
import com.gaby.gameotekaapp.presentation.RawgViewModelFilteredList
import com.gaby.gameotekaapp.presentation.components.DefaultTopBar
import com.gaby.gameotekaapp.presentation.components.NavegacionInferior

@Composable
fun EdicionesScreen(navController: NavHostController, viewModel: RawgViewModelFilteredList) {

    Scaffold(
        topBar = {  DefaultTopBar(tittle = "Ediciones", upAvailable = false, navController = navController,color= Color.White) },
        content = { paddingValues ->
            Column {
                Spacer(modifier = Modifier.height(56.dp))

                EdicionesContent(paddingValues = paddingValues, navHostController = navController, viewModel = viewModel)
            }
        },
        bottomBar = { NavegacionInferior(navController)  }
    )

}