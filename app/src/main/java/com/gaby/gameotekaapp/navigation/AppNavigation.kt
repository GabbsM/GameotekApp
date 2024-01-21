package com.gaby.gameotekaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gaby.gameotekaapp.presentation.viewModels.FilteredListViewModel
import com.gaby.gameotekaapp.presentation.viewModels.DetallesViewModel
import com.gaby.gameotekaapp.presentation.viewModels.DescubreViewModel
import com.gaby.gameotekaapp.presentation.screens.filteredListScreen
import com.gaby.gameotekaapp.presentation.screens.DescubreScreen
import com.gaby.gameotekaapp.presentation.screens.detallesScreen
import com.gaby.gameotekaapp.presentation.screens.EdicionesScreen
import com.gaby.gameotekaapp.presentation.screens.LoginScreen
import com.gaby.gameotekaapp.presentation.screens.MyGameoTekaScreen
import com.gaby.gameotekaapp.presentation.screens.ReviewScreen
import com.gaby.gameotekaapp.presentation.screens.SignUpScreen
import com.gaby.gameotekaapp.presentation.screens.TiendasScreen
import com.gaby.gameotekaapp.presentation.screens.UsuarioScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.Descubre.route
    ) {

        composable("juegos") {
            DescubreScreen(navController, viewModel = DescubreViewModel())
        }

        composable(AppScreen.Login.route) {
            LoginScreen(navController)
        }

        composable(AppScreen.SignUp.route) {
            SignUpScreen(navController)
        }

        composable(AppScreen.Usuario.route) {
            UsuarioScreen(navController, viewModel = DescubreViewModel())
        }


        composable(AppScreen.MyGameoTeka.route) {
            MyGameoTekaScreen(navController, viewModel = DescubreViewModel())
        }

        composable(AppScreen.Descubre.route) {
            DescubreScreen(navController, viewModel = DescubreViewModel())
        }

        composable(AppScreen.Reviews.route) {
            ReviewScreen(navController, viewModel = DescubreViewModel())
        }

        composable(AppScreen.Tiendas.route) {
            TiendasScreen(navController, viewModel = DescubreViewModel())
        }

        composable(AppScreen.Ediciones.route){
            EdicionesScreen(navController, viewModel = FilteredListViewModel())
        }

        composable(AppScreen.DetallesJuego.route + "/{gameId}") { backStackEntry ->
            val gameId = backStackEntry.arguments?.getString("gameId")?.toIntOrNull()
            if (gameId != null) {
                detallesScreen(navController, viewModel = DetallesViewModel(gameId), gameId = gameId)
            } else {
                // Manejar el caso en que gameId no es un número válido
            }
        }

        composable("desarrollador/{developerId}"){
             backStackEntry ->
                val developerId = backStackEntry.arguments?.getString("developerId")?.toIntOrNull()
                if (developerId != null) {
                    filteredListScreen(navController, viewModel = FilteredListViewModel(developerId=developerId))
                } else {
                    // Manejar el caso en que gameId no es un número válido
                }
        }

        composable("distribuidor/{publisherId}"){
                backStackEntry ->
            val publisherId = backStackEntry.arguments?.getString("publisherId")?.toIntOrNull()
            if (publisherId != null) {
                filteredListScreen(navController, viewModel = FilteredListViewModel(publisherId=publisherId))
            } else {
                // Manejar el caso en que gameId no es un número válido
            }
        }

    }

}