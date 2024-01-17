package com.gaby.gameotekaapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.gaby.gameotekaapp.model.Developers
import com.gaby.gameotekaapp.model.VideoJuegoDetalles


@Composable
fun CardJuego(juego: VideoJuegoDetalles, navController: NavHostController, onClick: () -> Unit) {

    Card(shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .width(140.dp)
            .background(Color.White)
            .size(140.dp)
            .shadow(5.dp)
            .clickable {
                navController.navigate("detalles/${juego.id}")
            }) {
        Column {
            InicioImagen(imagen = juego.imagen)

        }
    }
}

