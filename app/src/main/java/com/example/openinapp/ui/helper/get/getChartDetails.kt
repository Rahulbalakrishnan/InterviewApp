package com.example.openinapp.ui.helper.get


fun extractChartData(input: Map<String, Int>): Triple<List<Int>, List<Int>, List<String>> {
    val xValues = mutableListOf<Int>()
    val yValues = mutableListOf<Int>()
    val xDate = mutableListOf<String>()

    for ((date, value) in input) {
        xDate.add(date)
        xValues.add(xValues.size)
        yValues.add(value)
    }

    return Triple(xValues, yValues, xDate)
}

