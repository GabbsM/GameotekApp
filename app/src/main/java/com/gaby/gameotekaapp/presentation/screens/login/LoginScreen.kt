package com.gaby.gameotekaapp.presentation.screens.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.screens.login.components.LoginBottomBar
import com.gaby.gameotekaapp.presentation.screens.login.components.LoginContent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {

    Scaffold(
        topBar = {  },
        content = {paddingValues -> LoginContent(paddingValues) },
        bottomBar = { LoginBottomBar(navController) }
    )
}

