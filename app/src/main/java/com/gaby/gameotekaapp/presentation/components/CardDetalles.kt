package com.gaby.gameotekaapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.model.VideoJuegoDetalles

@Composable
fun CardDetalles(juego: VideoJuegoDetalles, navController: NavHostController) {

    Card(shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(300.dp)
            .background(Color.Transparent)
            .size(300.dp)
            .shadow(5.dp)
            .clickable {})
    {
        Column {
            InicioImagen(imagen = juego.imagen)

        }
    }
}