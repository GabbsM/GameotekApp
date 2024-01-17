package com.gaby.gameotekaapp.presentation.screens.desarrollador

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.model.VideoJuegoDetalles
import com.gaby.gameotekaapp.model.VideoJuegosModel
import com.gaby.gameotekaapp.presentation.RawgViewModelFilteredList
import com.gaby.gameotekaapp.presentation.components.CardDeveloper
import com.gaby.gameotekaapp.presentation.components.CardJuego

@Composable
fun DesarrolladorContent(
    navHostController: NavHostController,
    viewModel: RawgViewModelFilteredList
){

    val listaDeJuegosDelDeveloper by viewModel.listaDeJuegosFiltrada.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ){
        listaDeJuegosDelDeveloper?.results?.forEach {
            Column {
                // TODO: fix this part
//                CardDeveloper(
//                    developer = it,
//                    navController = navHostController,
//                    onClick = {}
//                )
            }
        }
    }
}

//@Composable
//fun CardDeveloper(developer: Int, navController: NavHostController) {
//
//}
//@Composable
//fun items(count: VideoJuegosModel?, itemContent: LazyItemScope.(index: Int) -> Unit) {
//
//}


