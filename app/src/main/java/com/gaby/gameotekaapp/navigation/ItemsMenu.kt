package com.gaby.gameotekaapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ItemsMenu(

    val icon: ImageVector,
    val title: String,
    val route: String
) {

    object Home : ItemsMenu(Icons.Outlined.Home, "Home", AppScreen.Descubre.route)
    object Buscar : ItemsMenu(Icons.Default.Search, "Buscar", AppScreen.Search.route)
    object Descubre : ItemsMenu(Icons.Outlined.Explore, "Descubre", AppScreen.Descubre.route)
    object MyGameoTeka : ItemsMenu(Icons.Default.List, "My Games", AppScreen.MyGameoTeka.route)
    object Usuario : ItemsMenu(Icons.Outlined.Person, "Usuario", AppScreen.Usuario.route)

}
