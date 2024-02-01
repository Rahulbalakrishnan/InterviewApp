package com.example.openinapp.ui.composable.dashboard.bottom

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.openinapp.data.local.Contact
import com.example.openinapp.data.local.Contacts


// TODO [COMPLETED] -> The Contact screen
@Composable
fun ContactScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .background(Color(240, 240, 245, 255))
            .padding(top = 30.dp, bottom = 40.dp),
    ) {
        Contacts.forEach {
            ContactScreenHelper(contact = it)

        }
    }


}

// TODO [COMPLETED] -> The Contact screen helper
@Composable
fun ContactScreenHelper(contact: Contact) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        border = BorderStroke(
            1.dp,
            if (contact.image == R.drawable.ic_wtsapp) Color.Green else Color(14, 111, 255, 112),
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (contact.image == R.drawable.ic_wtsapp) Color(
                74,
                209,
                95,
                10
            ) else Color(232, 241, 255, 220)
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Image(
                painter = painterResource(id = contact.image),
                contentDescription = "Icon",
                modifier = Modifier
                    .padding(vertical = 15.dp)
                    .padding(start = 1.dp)
                    .size(20.dp).clickable {
                    Toast
                        .makeText(context, "Not implemented!", Toast.LENGTH_SHORT)
                        .show()
                }
            )
            Text(
                text = contact.info,
                fontFamily = FontFamily(Font(R.font.figtree)),
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 32.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Left,
                color = Color.Black,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}