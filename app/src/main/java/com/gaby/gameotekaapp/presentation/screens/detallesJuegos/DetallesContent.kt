package com.gaby.gameotekaapp.presentation.screens.detallesJuegos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowRightAlt
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.gaby.gameotekaapp.R
import com.gaby.gameotekaapp.model.Developer
import com.gaby.gameotekaapp.presentation.RawGViewModelDetail
import com.gaby.gameotekaapp.presentation.components.CardDetalles
import com.gaby.gameotekaapp.presentation.components.ScreenshotCard


@Composable
fun DetallesContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    viewModel: RawGViewModelDetail
) {

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxWidth().verticalScroll(scrollState).background(Color.White)) {


        val juegoSeleccionado by viewModel.juegoSeleccionado.collectAsState()
        val screenshots by viewModel.screenshots.collectAsState()
        val stores by viewModel.stores.collectAsState()
        val urlTienda: String? = juegoSeleccionado?.stores?.getOrNull(0)?.url
        val LikeCount = 0
        val nombreDesarrollador: String? = juegoSeleccionado?.developers?.getOrNull(0)?.nombre
        val developer: Developer? = juegoSeleccionado?.developers?.getOrNull(0)
        val nombrePublisher: String? = juegoSeleccionado?.publishers?.getOrNull(0)?.nombre
        val idPublisher: Int? = juegoSeleccionado?.publishers?.getOrNull(0)?.id
        val idDeveloper: Int? = juegoSeleccionado?.developers?.getOrNull(0)?.id
        val nombreGeneros: String? = juegoSeleccionado?.genres?.getOrNull(0)?.nombre
        val website: String? = juegoSeleccionado?.website
        val plataformas: List<String>? = juegoSeleccionado?.platforms?.map { it.platform.nombre }
        val description = juegoSeleccionado?.description



        Spacer(modifier = Modifier.height(10.dp))

        if (juegoSeleccionado?.id != null) {

            Column(
                modifier = Modifier.padding(start = 8.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CardDetalles(
                    juego = juegoSeleccionado!!, navController = navHostController
                )

                Text(
                    text = "${juegoSeleccionado!!.nombre}",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))

//                @Composable
//                fun getPlatformIcon(platform: String): Painter {
//                    return when (platform) {
//                        "PlayStation 4" -> painterResource(R.drawable.ps4_icon)
//                        "PlayStation 5" -> painterResource(R.drawable.ps5_icon)
//                        "Xbox One" -> painterResource(R.drawable.xbox_icon)
//                        "Xbox Series S/X" -> painterResource(R.drawable.xs_icon)
//                        "PC" -> painterResource(R.drawable.windows_icon)
//
//                        // Agrega más plataformas aquí
//                        else -> painterResource(R.drawable.ps5_icon)
//                    }
//                }

//                Row(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
//                    plataformas?.forEach { platform ->
//                        val platformIcon = getPlatformIcon(platform)
//                        Icon(
//                            painter = platformIcon,
//                            contentDescription = platform,
//                            modifier = Modifier.size(24.dp)
//                        )
//                    }
//                }

                Row(modifier = Modifier.fillMaxWidth()) {


                    Row(modifier = Modifier) {
                        OutlinedCard(
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier.padding(start = 10.dp).height(40.dp),
                            border = BorderStroke(1.dp, Color.Gray),
                        ) {
                            Text(
                                text = "Lanzamiento:${juegoSeleccionado!!.fecha}",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(10.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                    }


                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.padding(start = 10.dp).height(40.dp),
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {
                        Row {
                            Image(
                                painter = painterResource(R.drawable.logometacritic),
                                contentDescription = "RawG",
                                modifier = Modifier.size(45.dp)
                                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                            )
                            Text(
                                // TODO: if metacritic is null, show N/A
                                text = "${juegoSeleccionado!!.metacritic}",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(end = 10.dp, start = 2.dp)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }

                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.padding(start = 10.dp).height(40.dp),
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {
                        Row {
                            Icon(
                                Icons.Outlined.FavoriteBorder,
                                contentDescription = "Star",
                                modifier = Modifier.size(45.dp)
                                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                                    .align(Alignment.CenterVertically),
                                tint = Color.Red
                            )
                            Text(
                                text = "$LikeCount",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(end = 10.dp, start = 2.dp)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }

                Row(modifier = Modifier) {
                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.padding(start = 10.dp, top = 14.dp, end = 28.dp)
                            .fillMaxWidth(),
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {
                        Text(
                            text = "Genero:  ${nombreGeneros ?: "No disponible"}",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally)
                        )
                    }
                }

//


                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 10.dp, top = 14.dp, end = 28.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.fillMaxWidth()
                            .clickable {
                                navHostController.navigate("desarrollador/${idDeveloper}")
                                       },
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Desarrollador:  ${nombreDesarrollador ?: "No disponible"}",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(
                                    start = 30.dp,
                                    top = 10.dp,
                                    bottom = 10.dp
                                )
                            )

                            Icon(
                                Icons.Outlined.ArrowRightAlt,
                                contentDescription = "Star",
                                modifier = Modifier.size(60.dp).padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    bottom = 10.dp,
                                    end = 20.dp
                                )
                            )
                        }
                    }
                }





                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 10.dp, top = 14.dp, end = 28.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.fillMaxWidth()
                            .clickable { navHostController.navigate("distribuidor/${idPublisher}") },
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Distribuidor:  ${nombrePublisher ?: "No disponible"}",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(
                                    start = 30.dp,
                                    top = 10.dp,
                                    bottom = 10.dp
                                )
                            )

                            Icon(
                                Icons.Outlined.ArrowRightAlt,
                                contentDescription = "Star",
                                modifier = Modifier.size(60.dp).padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    bottom = 10.dp,
                                    end = 20.dp
                                )
                            )
                        }
                    }
                }



                Row {

                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.padding(start = 10.dp, top = 14.dp, end = 28.dp)
                            .fillMaxWidth(),
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {

                    }

                }


                Text(
                    text = "Screenshots:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                        .align(Alignment.Start)

                )

                LazyRow(modifier = Modifier.padding(horizontal = 10.dp)) {
                    items(screenshots.orEmpty()) { screenshotUrl ->
                        ScreenshotCard(screenshotUrl = screenshotUrl)
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }

                val cleanDescription = description?.replace("<p>", "")?.replace("</p>", "")

                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Sobre el juego:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                    )

                    Text(
                        text = "$cleanDescription",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp)
                    )
                }


                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 10.dp, top = 14.dp, end = 28.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.fillMaxWidth()
                            .clickable { navHostController.navigate("tiendas") },
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Tiendas:${urlTienda ?: "No disponible"}",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(
                                    start = 30.dp,
                                    top = 10.dp,
                                    bottom = 10.dp
                                )
                            )

//                            Icon(Icons.Outlined.ArrowRightAlt,
//                                contentDescription = "Star",
//                                modifier = Modifier
//                                    .size(60.dp)
//                                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 20.dp))
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 10.dp, top = 14.dp, end = 28.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.fillMaxWidth()
                            .clickable { navHostController.navigate("ediciones") },
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Ediciones y DLCs",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(
                                    start = 30.dp,
                                    top = 10.dp,
                                    bottom = 10.dp
                                )
                            )

                            Icon(
                                Icons.Outlined.ArrowRightAlt,
                                contentDescription = "Star",
                                modifier = Modifier.size(60.dp).padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    bottom = 10.dp,
                                    end = 20.dp
                                )
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 10.dp, top = 14.dp, end = 28.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedCard(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.fillMaxWidth()
                            .clickable { navHostController.navigate("reviews") },
                        border = BorderStroke(1.dp, Color.Gray),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Reviews mas recientes",
                                fontSize = 14.sp,
                                modifier = Modifier.padding(
                                    start = 30.dp,
                                    top = 10.dp,
                                    bottom = 10.dp
                                )
                            )

                            Icon(
                                Icons.Outlined.ArrowRightAlt,
                                contentDescription = "Star",
                                modifier = Modifier.size(60.dp).padding(
                                    start = 10.dp,
                                    top = 10.dp,
                                    bottom = 10.dp,
                                    end = 20.dp
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "$website",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )

            }
        }
        Spacer(modifier = Modifier.height(140.dp))
    }

}
