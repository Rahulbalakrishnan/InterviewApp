package com.example.openinapp.ui.helper.get

import java.text.SimpleDateFormat
import java.util.*



fun convertDateString(input: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("yyyy-MMM-dd", Locale.getDefault())

    try {
        val date = inputFormat.parse(input)
        return outputFormat.format(date!!)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return "" // Return an empty string or handle the error accordingly
}

fun convertDateStringToDayMonth(input: List<String>): List<String> {
    val outputFormat = SimpleDateFormat("d MMM", Locale.getDefault())
    val result: MutableList<String> = mutableListOf()

    for (dateString in input) {
        try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = inputFormat.parse(dateString)
            result.add(outputFormat.format(date!!))
        } catch (e: Exception) {
            e.printStackTrace()
            result.add("") // Handle the error by adding an empty string to the result list
        }
    }

    return result
}

