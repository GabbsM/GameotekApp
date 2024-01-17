package com.gaby.gameotekaapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ScreenshotCard(screenshotUrl: String) {
    val painter = rememberImagePainter(
        data = screenshotUrl,
        builder = {
            transformations(coil.transform.RoundedCornersTransformation(12f))
        }
    )

    Image(
        painter = painter,
        contentDescription = "Screenshot",
        modifier = Modifier
            .height(120.dp)
            .width(200.dp)
    )
}

