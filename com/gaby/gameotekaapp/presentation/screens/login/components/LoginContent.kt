package com.gaby.gameotekaapp.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.gaby.gameotekaapp.R
import com.gaby.gameotekaapp.presentation.components.TextFieldDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        BoxHeader()
        CardForm()
    }
}


@Composable
fun BoxHeader() {

    Box(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.height(130.dp)
                    .padding(top = 50.dp),
                painter = painterResource(id = R.drawable.control),
                contentDescription = "Control",
            )
            Text(
                text = "GameOteka", fontSize = 30.sp, fontWeight = FontWeight.Bold,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardForm() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp, top = 180.dp)
            .background(Color.White)
            .zIndex(1f),

        ) {

        Column(modifier = Modifier.padding(20.dp)) {

            Text(
                modifier = Modifier.padding(top = 30.dp),
                text = "LOGIN",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Inicia sesión con tu cuenta de GameOteka",
                fontSize = 12.sp,
                color = Color.Gray
            )

           TextFieldDefault(
                modifier = Modifier.padding(top = 20.dp),
                value = email,
                onValueChange = { email = it },
                label = "Email",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email)


            Spacer(modifier = Modifier.height(10.dp))

            TextFieldDefault(
                modifier = Modifier.padding(top = 20.dp),
                value = password,
                onValueChange = { password = it},
                label = "Contraseña",
                icon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                hideText = true
             )


            Button(
                modifier = Modifier.padding(vertical = 15.dp)
                    .fillMaxWidth(),
                onClick = { },

            ) {
                Text(
                    text = "INICIAR SESIÓN",
                    color = Color.White
                )
            }
        }


    }

}