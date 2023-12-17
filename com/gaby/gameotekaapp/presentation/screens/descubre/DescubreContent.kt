package com.gaby.gameotekaapp.presentation.screens.descubre

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.gaby.gameotekaapp.model.ListaVideojuegos
import com.gaby.gameotekaapp.presentation.RawGViewModel
import com.gaby.gameotekaapp.presentation.components.DefaultTextHeader

@Composable
fun DescubreContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    viewModel: RawGViewModel
){


    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState).background(Color.White)
    ) {


        DefaultTextHeader(
            text = "Juegos más populares",
            fontSize = 25,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(5.dp))
        DefaultTextHeader(
            text = "2023", fontSize = 14, color = Color.Gray,
        )
        val juegos by viewModel.juegos.collectAsState()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            items(juegos) {
                Column {
                    CardJuego(
                        juego = it
                    ) { }
                    Box {
                        Text(
                            text = it.nombre,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            fontSize = 10.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                                .width(140.dp)

                        )
                    }

                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedCard(colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .height(60.dp)
                .shadow(5.dp)
                .clickable { }) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Lista completa",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

            }
        }

        Spacer(modifier = Modifier.height(30.dp))


        DefaultTextHeader(
            text = "Novedades", fontSize = 25, fontWeight = FontWeight.Bold, color = Color.Black
        )
        val novedades by viewModel.novedades.collectAsState()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            items(novedades) {
                Column {
                    CardJuego(
                        juego = it
                    ) { }
                    Box {
                        Text(
                            text = it.nombre,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            fontSize = 10.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                                .width(140.dp)

                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        DefaultTextHeader(
            text = "Proximos lanzamientos",
            fontSize = 25,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        DefaultTextHeader(
            text = "Enero 2024", fontSize = 14, color = Color.Gray,
        )
        val proximosLanzamientos by viewModel.proximosLanzamientos.collectAsState()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            items(proximosLanzamientos) {
                Column {
                    CardJuego(
                        juego = it
                    ) { }
                    Box {
                        Text(
                            text = it.nombre,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            fontSize = 10.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                                .width(140.dp)

                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedCard(colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .height(60.dp)
                .shadow(5.dp)
                .clickable { }) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Seleccion Retro",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

            }
        }



        Spacer(modifier = Modifier.height(30.dp))

        DefaultTextHeader(
            text = "Mejores valorados 2023",
            fontSize = 25,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        DefaultTextHeader(
            text = "By Metacritic", fontSize = 14, color = Color.Gray,
        )
        val masValorados by viewModel.masValorados.collectAsState()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            items(masValorados) {
                Column {
                    CardJuego(
                        juego = it
                    ) { }
                    Box {
                        Text(
                            text = it.nombre,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            fontSize = 10.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                                .width(140.dp)

                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(140.dp))
    }
}


@Composable
fun CardJuego(juego: ListaVideojuegos, onClick: () -> Unit) {

    Card(shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
            .size(140.dp)
            .shadow(5.dp)
            .clickable { onClick }) {
        Column {
            InicioImagen(imagen = juego.imagen)
        }
    }
}

//USO DE LA LIBRERIA COIL PARA CARGAR IMAGEN DE UNA URL
@Composable
fun InicioImagen(imagen: String) {

    val imagen = rememberAsyncImagePainter(model = imagen)


    Image(
        painter = imagen,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().height(250.dp)
    )

}