package com.gaby.gameotekaapp.presentation.components


import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    tittle: String,
    upAvailable: Boolean = false,
    navController: NavHostController? = null,
    color: Color
) {

    val textState = remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current

    TopAppBar(
        title = {
            Text(
                text = "GameotekApp Logo",
                fontSize = 20.sp,
                color = Color.Gray,
                fontWeight = FontWeight.ExtraBold
            )
        },
        //PINTAR LA TOPAPPBAR:
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.White
        ),

        actions = {
            IconButton(onClick = { /* Acción al hacer clic en el icono */ }) {
                Icon(
                    imageVector = Icons.Default.Settings, // Reemplaza 'YourIcon' con el icono que deseas usar
                    "",
                    tint = Color.Black
                )
            }
        }

}