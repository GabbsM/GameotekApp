package com.gaby.gameotekaapp.presentation.contents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.viewModels.DescubreViewModel

@Composable
fun TiendasContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    viewModel: DescubreViewModel
){
Text(text = "Tiendas")
}