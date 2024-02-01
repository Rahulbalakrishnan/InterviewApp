package com.example.openinapp.ui.composable.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.openinapp.data.api.models.OpenInAppResponse
import com.example.openinapp.ui.composable.dashboard.bottom.ContactScreen
import com.example.openinapp.ui.composable.dashboard.middle.ListScreen
import com.example.openinapp.navigation.TopBarScreen
import com.example.openinapp.ui.composable.dashboard.top.WelcomeScreen


// TODO -> Main/ Landing page, Update here.
@Composable
fun DashboardScreen(response: OpenInAppResponse) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBarScreen()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                WelcomeScreen(apiResponse = response )
            }
            item {
                ListScreen(apiResponse = response)
            }
            item {
                ContactScreen()
            }

        }
    }
}





