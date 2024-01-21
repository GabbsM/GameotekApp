package com.gaby.gameotekaapp.navigation

sealed class AppScreen(val route: String) {

    object Login: AppScreen("login")
    object SignUp: AppScreen("signUp")
    object Usuario: AppScreen("usuario")
    object Search: AppScreen("search")
    object MyGameoTeka: AppScreen("myGameoTeka")
    object DetallesJuego: AppScreen("detalles")
    object Descubre: AppScreen("descubre")
    object Reviews: AppScreen("reviews")
    object  Tiendas: AppScreen("tiendas")
    object  Ediciones: AppScreen("ediciones")


}

