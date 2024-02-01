package com.example.openinapp.ui.helper.get

fun getMonthAbbreviation(index: Int): String {
    val months =
        listOf(
            "",
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec"
        )
    return months.getOrElse(index) { "" }
}