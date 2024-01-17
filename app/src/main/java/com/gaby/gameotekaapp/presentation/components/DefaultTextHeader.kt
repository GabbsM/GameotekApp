package com.gaby.gameotekaapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DefaultTextHeader(
    modifier: Modifier = Modifier.padding(start=10.dp),
    text : String,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize : Int = 20,
    color: Color

    ) {

   Text(modifier = modifier,text = text, fontWeight = fontWeight, fontSize = fontSize.sp,color = color)

}