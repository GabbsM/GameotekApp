package com.gaby.gameotekaapp.navigation

sealed class AppScreen(val route: String) {

    object Login: AppScreen("login")
    object SignUp: AppScreen("signUp")
    object Home: AppScreen("home")
    object Usuario: AppScreen("usuario")
    object MyGameoTeka: AppScreen("myGameoTeka")
    object Descubre: AppScreen("descubre")
    object  Desarrollador: AppScreen("desarrollador")
    object  Distruibuidor: AppScreen("distribuidor")
    object Reviews: AppScreen("reviews")
    object  Tiendas: AppScreen("tiendas")
    object  Ediciones: AppScreen("ediciones")


}

