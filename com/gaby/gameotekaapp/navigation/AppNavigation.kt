package com.gaby.gameotekaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gaby.gameotekaapp.presentation.RawGViewModel
import com.gaby.gameotekaapp.presentation.screens.descubre.DescubreScreen
import com.gaby.gameotekaapp.presentation.screens.home.HomeScreen
import com.gaby.gameotekaapp.presentation.screens.login.LoginScreen
import com.gaby.gameotekaapp.presentation.screens.myGameoteka.MyGameoTekaScreen
import com.gaby.gameotekaapp.presentation.screens.singUp.SignUpScreen
import com.gaby.gameotekaapp.presentation.screens.usuario.UsuarioScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.Descubre.route
    ) {
        composable(AppScreen.Login.route) {
            LoginScreen(navController)
        }

        composable(AppScreen.SignUp.route) {
            SignUpScreen(navController)
        }

        composable(AppScreen.Home.route) {
            HomeScreen(navController, viewModel = RawGViewModel())
        }

        composable(AppScreen.Usuario.route) {
            UsuarioScreen(navController, viewModel = RawGViewModel())
        }


        composable(AppScreen.MyGameoTeka.route) {
            MyGameoTekaScreen(navController, viewModel = RawGViewModel())
        }

        composable(AppScreen.Descubre.route) {
            DescubreScreen(navController, viewModel = RawGViewModel())
        }

    }

}