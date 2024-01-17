package com.gaby.gameotekaapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.navigation.Items_Menu

@Composable
fun NavegacionInferior(navController: NavHostController) {

    val menu_items = listOf(

        Items_Menu.Home,
        Items_Menu.Buscar,
        Items_Menu.Descubre,
        Items_Menu.MyGameoTeka,
        Items_Menu.Usuario,

    )

    BottomAppBar(modifier = Modifier.fillMaxWidth(1f)){
        NavigationBar(containerColor = Color.White, modifier = Modifier.fillMaxWidth()){
            menu_items.forEach { item ->
                NavigationBarItem(selected = false,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = item.title, tint = Color.Black)
                    },
                    label = {
                        Text(text = item.title, color = Color.Black)
                    })
            }
        }
    }


}