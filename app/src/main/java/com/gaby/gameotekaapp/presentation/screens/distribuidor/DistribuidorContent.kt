package com.gaby.gameotekaapp.presentation.screens.distribuidor

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.RawGViewModelList

@Composable
fun DistribuidorContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    viewModel: RawGViewModelList
){
    Text(text = "Distribuidor")
}