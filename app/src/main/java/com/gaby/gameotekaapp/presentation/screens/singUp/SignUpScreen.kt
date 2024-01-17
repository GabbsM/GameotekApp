package com.gaby.gameotekaapp.presentation.screens.singUp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.components.DefaultTopBar
import com.gaby.gameotekaapp.presentation.screens.singUp.components.SignUpContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController : NavHostController) {
    Scaffold(
        topBar = { DefaultTopBar(
            tittle = "Nuevo Usuario",
            upAvailable = true,
            navController = navController,
            color = Color.White )  },
        content = {paddingValues -> SignUpContent(paddingValues)
                  Text(text = "SignUpScreen")
        },
        bottomBar = { }
    )
}