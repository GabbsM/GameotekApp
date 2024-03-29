package com.gaby.gameotekaapp.presentation.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.presentation.components.CardJuego
import com.gaby.gameotekaapp.presentation.viewModels.FilteredListViewModel


@Composable
fun filteredListContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    viewModel: FilteredListViewModel
) {
    val listaDeJuegosFiltrada by viewModel.listaDeJuegosFiltrada.collectAsState()

    Box(modifier = Modifier.fillMaxWidth().background(Color.White)) {
        LazyColumn (modifier = Modifier.fillMaxWidth().background(Color.White)) {
            items(listaDeJuegosFiltrada.orEmpty()) { videoJuegoItem ->
                Row {
                    Column {
                        CardJuego(
                            juego = videoJuegoItem,
                            navController = navHostController,
                            onClick = {}
                        )
                        Text(text = videoJuegoItem.nombre,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 8.dp, top = 10.dp, bottom = 10.dp).align(Alignment.CenterHorizontally))
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(100.dp).fillMaxWidth())
            }
        }
    }
}
