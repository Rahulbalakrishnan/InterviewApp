package com.example.openinapp.ui.composable.dashboard.top


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.openinapp.R
import com.example.openinapp.data.api.models.OpenInAppResponse
import com.example.openinapp.data.local.Info
import com.example.openinapp.ui.helper.get.convertDateStringToDayMonth
import com.example.openinapp.ui.helper.get.extractChartData
import com.example.openinapp.ui.helper.get.getGreeting


@Composable
fun WelcomeScreen(apiResponse: OpenInAppResponse) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(14, 111, 255, 240))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp))
                .background(
                    Color(240, 240, 245, 255),
                    shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
                ),
        ) {
            // TODO [COMPLETED] -> ADD/Remove Welcome Screen Composable here
            WelcomeScreenBanner(apiResponse)
            WelcomeScreenGraph(apiResponse)
            WelcomeScreenCard(apiResponse)
        }
    }


}


@Composable
// TODO [COMPLETED] -> Welcome screen, This composable wishes the user with the username
fun WelcomeScreenBanner(res: OpenInAppResponse) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp).padding(top=10.dp)
    ) {
        Text(
            text = getGreeting(),
            fontFamily = FontFamily(Font(R.font.figtree)),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Left,
            color = Color.Gray,
            modifier = Modifier
                .wrapContentSize()
        )

        Row {
            //Text composable
            Text(
                text = "Ajay Manva",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 32.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Left,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.figtree)),
                modifier = Modifier
                    .width(127.dp)
                    .height(32.dp)
            )
            // Spacer is used to provide a space between "username" and "emoji"
            Spacer(modifier = Modifier.width(2.dp))

            // Image composable
            Image(
                painter = painterResource(id = R.drawable.ic_handwave),
                contentDescription = "Waving hand Image",
                modifier = Modifier.size(26.dp)
            )

        }
    }
}

// TODO [COMPLETED] -> Welcome Screen, The Graph
@Composable
fun WelcomeScreenGraph(res: OpenInAppResponse) {
    val chartDetails: Map<String, Int> = res.data.overallUrlChart
    val chartInfo = extractChartData(chartDetails)
    val (xPoint, yPoint, xDate) = chartInfo.toList()

    // TODO [COMPLETED] -> xPoint, yPoints and xDate are List of Comparable and Serializable
    val xFloatValues: List<Float> = xPoint.map { it.toString().toFloat() }
    val yFloatValues: List<Float> = yPoint.map { it.toString().toFloat() }
    val xDateData: List<String> = xDate.map { it.toString() }

    // TODO [COMPLETED] -> A shorter version of date, having just month and year.
    val xDateShort: List<String> = convertDateStringToDayMonth(xDateData)

    // TODO [COMPLETED] -> Extract values for top button info
    val startDate = xDateShort[0]
    val endDate = xDateShort[xDateShort.lastIndex]


//    TODO [COMPLETED] -> ChatGpt Generated Regex pattern.
//    val startYear = Regex("""\d{2}(?=-)""").find(xDateData[0])?.value
//    val endYear = Regex("""\d{2}(?=-)""").find(xDateData[xDateData.lastIndex])?.value

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.White)


    ) {
        Row {
            Text(
                text = "Overview",
                fontFamily = FontFamily(Font(R.font.figtree)),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp,
                letterSpacing = 0.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))


            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = Modifier.padding(top = 7.dp, end = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,),
                ) {
                Text(
                    text = String.format("%s -  %s ", startDate, endDate),
                    fontFamily = FontFamily(Font(R.font.figtree)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp,
                    letterSpacing = 0.sp,
                    color = Color.Black,
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "Clock Image",
                    modifier = Modifier.size(25.dp).padding(end = 0.dp)

                )

            }

        }
        val steps = 4
        val pointsData: List<Point> = xFloatValues.zip(yFloatValues) { x, y ->
            Point(x, y)
        }
        val xAxisData = AxisData.Builder()
            .axisStepSize(50.dp)
            .backgroundColor(Color.White)
            .steps(pointsData.size - 1)
            .labelData { i ->
                xDateShort.getOrNull(i) ?: ""
            }
            .labelAndAxisLinePadding(20.dp)
            .axisLineColor(Color.Transparent)
            .axisLabelColor(Color.Gray)
            .build()

        val yAxisData = AxisData.Builder()
            .steps(steps)
            .backgroundColor(Color.White)

            .labelAndAxisLinePadding(20.dp)
            .labelData { i ->
                val yScale = 100 / steps
                (i * yScale).toString()
            }
            .axisLineColor(Color.Transparent)
            .axisLabelColor(Color.Gray)
            .build()

        val lineChartData = LineChartData(
            linePlotData = LinePlotData(
                lines = listOf(
                    Line(
                        dataPoints = pointsData,
                        LineStyle(
                            color = Color(
                                14,
                                111,
                                255,
                                210
                            ),
                            lineType = LineType.Straight(isDotted = false)
                        ),
                        IntersectionPoint(
                            color = Color.Transparent
                        ),
                        SelectionHighlightPoint(
                            color = Color(
                                14,
                                111,
                                255,
                                210
                            )
                        ),
                        ShadowUnderLine(
                            alpha = 0.5f,
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(
                                        14,
                                        111,
                                        255,
                                        210
                                    ),
                                    Color.Transparent
                                )
                            )
                        ),
                        SelectionHighlightPopUp()
                    )
                ),
            ),
            xAxisData = xAxisData,
            yAxisData = yAxisData,
            gridLines = GridLines(),
            backgroundColor = Color.White
        )


        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            lineChartData = lineChartData
        )


    }

}


// TODO [COMPLETED] -> Welcome Screen card
@Composable
fun WelcomeScreenCard(res: OpenInAppResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(bottom = 15.dp)
    ) {


        //TODO [COMPLETED] -> From the Api
        val infoFromApi = listOf<Info>(
            Info(R.drawable.ic_pointer, res.todayClicks.toString(), "Today's Click"),
            Info(R.drawable.ic_location, res.topLocation, "Top Location"),
            Info(R.drawable.ic_internet, res.topSource, "Top Source")
        )

        // TODO [COMPLETED] -> Can add even more cards on future
        LazyRow(
            modifier = Modifier.padding(top=10.dp)
        ) {

            // TODO [COMPLETED] -> Replace "info" to "infoFromApi"
            items(infoFromApi) { info ->
                Row(
                    modifier = Modifier.padding(start = 15.dp)
                ) {
                    WelcomeScreenCardHelper(info)
                }
            }
        }
        // button -start

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth().padding(top = 5.dp)
                .padding(16.dp).padding(bottom = 30.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(Color(240, 240, 245, 255))
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(0.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = "Link Icon"
                )
                Text(
                    text = "View Analytics ",
                    fontFamily = FontFamily(Font(R.font.figtree)),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 24.sp,
                    letterSpacing = 0.sp,
                    textAlign = TextAlign.Left,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }

        }

        // button -end


    }

}

// TODO [COMPLETED] -> Welcome Screen card helper
@Composable
fun WelcomeScreenCardHelper(info: Info) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .width(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = info.image),
                contentDescription = "Icon",
                modifier = Modifier.size(32.dp)

            )
            Text(
                text = info.info1,
                fontFamily = FontFamily(Font(R.font.figtree)),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 24.sp,
                letterSpacing = 0.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
            Text(
                text = info.info2,
                fontFamily = FontFamily(Font(R.font.figtree)),
                color = Color.Gray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 24.sp,
                letterSpacing = 0.sp,
                modifier = Modifier.padding(1.dp)
            )
        }
    }

}






