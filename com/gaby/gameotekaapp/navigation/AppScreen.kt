package com.gaby.gameotekaapp.navigation

sealed class AppScreen(val route: String) {

    object Login: AppScreen("login")
    object SignUp: AppScreen("signUp")
    object Home: AppScreen("home")
    object Usuario: AppScreen("usuario")
    object MyGameoTeka: AppScreen("myGameoTeka")
    object Descubre: AppScreen("descubre")


}

