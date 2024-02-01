package com.example.openinapp.ui.helper.get

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@OptIn(ExperimentalCoilApi::class)
@Composable
fun getCompanyLogo(imageUrl: String): AsyncImagePainter {
    // Use Coil to load the image from the URL
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = imageUrl).apply(block = fun ImageRequest.Builder.() {
            crossfade(true)
        }).build()
    )

    return painter
}