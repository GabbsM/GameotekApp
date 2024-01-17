package com.gaby.gameotekaapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Items_Menu(

    val icon: ImageVector,
    val title: String,
    val route: String
) {

    object Home : Items_Menu(Icons.Outlined.Home, "Home", "home")
    object Buscar : Items_Menu(Icons.Default.Search, "Buscar", "buscar")
    object Descubre : Items_Menu(Icons.Outlined.Explore, "Descubre", "descubre")
    object MyGameoTeka : Items_Menu(Icons.Default.List, "My Games", "myGameoTeka")
    object Usuario : Items_Menu(Icons.Outlined.Person, "Usuario", "usuario")

}
