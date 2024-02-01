package com.example.openinapp.ui.helper.get

import java.time.LocalTime

fun getGreeting(): String {
    val currentTime = LocalTime.now()
    return when (currentTime.hour) {
        in 0..11 -> "Good Morning"
        in 12..16 -> "Good Afternoon"
        in 17..20 -> "Good Evening"
        else -> "Good Night"
    }
}