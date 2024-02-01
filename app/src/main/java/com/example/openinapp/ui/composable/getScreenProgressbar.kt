package com.example.openinapp.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun GetScreenProgressbar() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(14, 111, 255, 240)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = Color.White )
    }
}