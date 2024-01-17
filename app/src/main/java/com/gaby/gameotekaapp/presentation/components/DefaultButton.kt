package com.gaby.gameotekaapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun DefaultButton(
    text : String,
    onClick : () -> Unit,

    ) {

    Button(modifier = Modifier.padding(vertical = 15.dp)
        .fillMaxWidth()
        , onClick = {onClick()},)
    {
        Text(text =  text)
    }
}