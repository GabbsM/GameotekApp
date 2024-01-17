package com.gaby.gameotekaapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


//USO DE LA LIBRERIA COIL PARA CARGAR IMAGEN DE UNA URL
@Composable
fun InicioImagen(imagen: String) {

    val imagen = rememberAsyncImagePainter(model = imagen)


    Image(
        painter = imagen,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().height(300.dp)
    )
}
