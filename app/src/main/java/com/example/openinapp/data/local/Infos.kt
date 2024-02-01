package com.example.openinapp.data.local

import com.example.openinapp.R


// TODO [COMPLETED] -> update this here for further expansion.

data class Info(
    val image: Int,
    val info1: String,
    val info2: String,
)

val Infos = listOf<Info>(
    Info(R.drawable.ic_pointer, "123", "Today's Click"),
    Info(R.drawable.ic_location, "Ahmedabad", "Top Location"),
    Info(R.drawable.ic_internet, "Instagram", "Top Source")
)

