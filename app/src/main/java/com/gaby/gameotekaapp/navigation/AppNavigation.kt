package com.gaby.gameotekaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gaby.gameotekaapp.presentation.RawgViewModelFilteredList
import com.gaby.gameotekaapp.presentation.RawGViewModelDetail
import com.gaby.gameotekaapp.presentation.RawGViewModelList
import com.gaby.gameotekaapp.presentation.screens.desarrollador.DesarrolladorScreen
import com.gaby.gameotekaapp.presentation.screens.descubre.DescubreScreen
import com.gaby.gameotekaapp.presentation.screens.detallesJuegos.detallesScreen
import com.gaby.gameotekaapp.presentation.screens.ediciones.EdicionesScreen
import com.gaby.gameotekaapp.presentation.screens.home.HomeScreen
import com.gaby.gameotekaapp.presentation.screens.login.LoginScreen
import com.gaby.gameotekaapp.presentation.screens.myGameoteka.MyGameoTekaScreen
import com.gaby.gameotekaapp.presentation.screens.reviews.ReviewScreen
import com.gaby.gameotekaapp.presentation.screens.singUp.SignUpScreen
import com.gaby.gameotekaapp.presentation.screens.tiendas.TiendasScreen
import com.gaby.gameotekaapp.presentation.screens.usuario.UsuarioScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.Descubre.route
    ) {

        composable("juegos") {
            DescubreScreen(navController, viewModel = RawGViewModelList())
        }

        composable(AppScreen.Login.route) {
            LoginScreen(navController)
        }

        composable(AppScreen.SignUp.route) {
            SignUpScreen(navController)
        }

        composable(AppScreen.Home.route) {
            HomeScreen(navController, viewModel = RawGViewModelList())
        }

        composable(AppScreen.Usuario.route) {
            UsuarioScreen(navController, viewModel = RawGViewModelList())
        }


        composable(AppScreen.MyGameoTeka.route) {
            MyGameoTekaScreen(navController, viewModel = RawGViewModelList())
        }

        composable(AppScreen.Descubre.route) {
            DescubreScreen(navController, viewModel = RawGViewModelList())
        }

        composable(AppScreen.Reviews.route) {
            ReviewScreen(navController, viewModel = RawGViewModelList())
        }

        composable(AppScreen.Tiendas.route) {
            TiendasScreen(navController, viewModel = RawGViewModelList())
        }

        composable(AppScreen.Ediciones.route){
            EdicionesScreen(navController, viewModel = RawgViewModelFilteredList())
        }

        composable("detalles/{gameId}") { backStackEntry ->
            val gameId = backStackEntry.arguments?.getString("gameId")?.toIntOrNull()
            if (gameId != null) {
                detallesScreen(navController, viewModel = RawGViewModelDetail(gameId), gameId = gameId)
            } else {
                // Manejar el caso en que gameId no es un número válido
            }
        }

        composable("desarrollador/{developerId}"){
             backStackEntry ->
                val developerId = backStackEntry.arguments?.getString("developerId")?.toIntOrNull()
                if (developerId != null) {
                    DesarrolladorScreen(navController, viewModel = RawgViewModelFilteredList(developerId=developerId))
                } else {
                    // Manejar el caso en que gameId no es un número válido
                }
        }

        composable("distribuidor/{publisherId}"){
                backStackEntry ->
            val publisherId = backStackEntry.arguments?.getString("publisherId")?.toIntOrNull()
            if (publisherId != null) {
                DesarrolladorScreen(navController, viewModel = RawgViewModelFilteredList(publisherId=publisherId))
            } else {
                // Manejar el caso en que gameId no es un número válido
            }
        }

    }

}