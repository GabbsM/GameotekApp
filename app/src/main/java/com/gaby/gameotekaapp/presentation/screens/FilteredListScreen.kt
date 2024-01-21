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
import com.gaby.gameotekaapp.presentation.viewModels.FilteredListViewModel
import com.gaby.gameotekaapp.presentation.contents.filteredListContent

@Composable
fun filteredListScreen(navController: NavHostController, viewModel: FilteredListViewModel) {

    Scaffold(
        topBar = {  DefaultTopBar(title = "Desarrollador", upAvailable = false, navController = navController,color= Color.White) },
        content = { paddingValues ->
            Column {
                Spacer(modifier = Modifier.height(56.dp)) // Añade un espacio de 56.dp que es la altura típica de una TopBar

                filteredListContent(paddingValues = paddingValues, navHostController = navController, viewModel = viewModel)
            }
        },
        bottomBar = { NavegacionInferior(navController)  }
    )

}