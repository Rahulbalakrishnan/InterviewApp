package com.example.openinapp.ui.composable.dashboard.middle


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinapp.R
import com.example.openinapp.data.api.models.OpenInAppResponse
import com.example.openinapp.data.local.LinkApi
import com.example.openinapp.ui.helper.get.convertDateString
import com.example.openinapp.ui.helper.get.convertToLinkListApi
import com.example.openinapp.ui.helper.get.convertToLinkListApiRecent
import com.example.openinapp.ui.helper.get.copyTextToClipboard
import com.example.openinapp.ui.helper.get.getCompanyLogo


// TODO -> The Entire List Screen can be viewed here.
@Composable
fun ListScreen(apiResponse: OpenInAppResponse) {
    Surface(
        color = Color(240, 240, 245, 255),
        modifier = Modifier.fillMaxHeight()
    ) {
        Column(

        ) {
            MenuListScreenCategory(apiResponse)

        }
    }
}


// TODO [COMPLETED] -> The Horizontal Button lists, can be updated here!
@Composable
fun MenuListScreenCategory(res: OpenInAppResponse) {
    val context = LocalContext.current
    var selectedList by remember { mutableStateOf<List<LinkApi>>(convertToLinkListApi(res.data.topLinks)) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        var isSelectedTopLink by remember { mutableStateOf(true) }
        var isSelectedRecentLink by remember { mutableStateOf(false) }


        ClickableText(
            text = AnnotatedString(" Top Links "),
            onClick = {
                isSelectedTopLink = true
                isSelectedRecentLink = false
                selectedList = convertToLinkListApi(res.data.topLinks)

            },
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.figtree)),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                color = if (isSelectedTopLink) Color.White else Color.Black

            ),
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .padding(5.dp)
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelectedTopLink) Color(
                        14,
                        111,
                        255,
                        240
                    ) else Color.Transparent
                )
                .border(
                    width = 2.dp,
                    color = if (isSelectedTopLink) Color(
                        14,
                        111,
                        255,
                        240
                    ) else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        )

        Spacer(modifier = Modifier.padding(horizontal = 5.dp))

        ClickableText(
            text = AnnotatedString(" Recent Links "),
            onClick = {
                isSelectedTopLink = false
                isSelectedRecentLink = true
                selectedList = convertToLinkListApiRecent(res.data.recentLinks)
            }, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.figtree)),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                color = if (isSelectedRecentLink) Color.White else Color.Black


            ),
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .padding(5.dp)
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isSelectedRecentLink) Color(
                        14,
                        111,
                        255,
                        240
                    ) else Color.Transparent
                )
                .border(
                    width = 2.dp,
                    color = if (isSelectedRecentLink) Color(
                        14,
                        111,
                        255,
                        240
                    ) else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        )



        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_search_bar),
            contentDescription = "Search bar Icon",
            modifier = Modifier
                .size(35.dp)
                .clickable {
                    Toast
                        .makeText(context, "Not implemented!", Toast.LENGTH_SHORT)
                        .show()
                }
        )
    }
    // Now, you can pass selectedList to MenuListScreenLink
    MenuListScreenLink(res = res, linksListApi = selectedList)
}

// TODO [COMPLETED] -> The Vertical Card lists, can be updated here!
@Composable
fun MenuListScreenLink(res: OpenInAppResponse, linksListApi: List<LinkApi>) {

    Spacer(modifier = Modifier.padding(top = 10.dp))

    // TODO [COMPLETED] -> Links from Api
    val listToShow: List<LinkApi> = linksListApi
// Add a state variable to track whether to show all links or not
    var showAllLinks by remember { mutableStateOf(false) }
    val displayedLinks = if (showAllLinks) listToShow else listToShow.take(4)
    displayedLinks.forEach {
        MenuListScreenLinkHelper(link = it)
    }

    Button(
        onClick = { showAllLinks = !showAllLinks },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(Color(240, 240, 245, 255))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_links),
                contentDescription = "Link Icon"
            )
            Text(
                text = if (showAllLinks) "Hide Links" else "View All Links",
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

}

// TODO [COMPLETED] -> The Vertical Card lists Helper!
@Composable
fun MenuListScreenLinkHelper(link: LinkApi) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        // Main Column
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
        ) {

            // Top Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
            ) {
                // Image

                val painter = getCompanyLogo(imageUrl = link.image)
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(shape = CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Main Column 2nd row - Company Name, Text Name, Two Texts
                Column(
                    modifier = Modifier.padding(2.dp)
                ) {
                    // TODO [COMPLETED] - update with API Data
                    Text(
                        text = link.companyName,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(R.font.figtree)),
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 24.sp,
                        letterSpacing = 0.sp,
                        modifier = Modifier
                            .padding(1.dp)
                            .fillMaxWidth(0.5f)
                    )

                    // TODO [COMPLETED] - update with API Data
                    Text(
                        text = convertDateString(link.date),
                        fontFamily = FontFamily(Font(R.font.figtree)),
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        lineHeight = 24.sp,
                        letterSpacing = 0.sp,
                        modifier = Modifier.padding(1.dp)
                    )

                }
                Spacer(modifier = Modifier.weight(1f))
                // Main Column 3rd row
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    // TODO [COMPLETED] - update with API Data
                    Text(
                        text = link.count.toString(), fontFamily = FontFamily(Font(R.font.figtree)),
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 24.sp,
                        letterSpacing = 0.sp,
                        modifier = Modifier.padding(1.dp)
                    )

                    // TODO [COMPLETED] - update with API Data
                    Text(
                        text = link.info, fontFamily = FontFamily(Font(R.font.figtree)),
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        lineHeight = 24.sp,
                        letterSpacing = 0.sp,
                        modifier = Modifier.padding(1.dp)
                    )
                }
            }


            // Bottom Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(166, 199, 255, 110))
                    .padding(5.dp)
                    .padding(5.dp, 1.dp)
            ) {
                Text(
                    text = link.url,
                    fontFamily = FontFamily(Font(R.font.figtree)),
                    color = Color(14, 111, 255, 200),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 24.sp,
                    letterSpacing = 0.sp,
                    modifier = Modifier.padding(0.dp),

                    )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_copy),
                    contentDescription = "Copy Icon",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {

                            copyTextToClipboard(context, link.url)

                            Toast
                                .makeText(context, "Copied!", Toast.LENGTH_SHORT)
                                .show()
                        },
                )
            }


        }
    } // card ending


}






