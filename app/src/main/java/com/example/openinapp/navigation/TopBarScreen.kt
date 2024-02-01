package com.example.openinapp.navigation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinapp.R


// TODO [COMPLETED] -> The Top navigation/Bar
@Composable
fun TopBarScreen() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                Color(
                    14,
                    111,
                    255,
                    240
                )
            )
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        // Top bar name
        Text(
            text = "Dashboard",
            fontFamily = FontFamily(Font(R.font.figtree)),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Start,
            color = Color.White,
        )

        // Top bar settings icon
        Image(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .clickable {
                    Toast
                        .makeText(context, "Not implemented!", Toast.LENGTH_SHORT)
                        .show()
                },
            painter = painterResource(id = R.drawable.ic_topsettings),
            contentDescription = "Settings Icon",
        )

    }
}
