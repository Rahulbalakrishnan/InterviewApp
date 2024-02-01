package com.example.openinapp.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.openinapp.R
import com.example.openinapp.data.api.models.OpenInAppResponse
import com.example.openinapp.ui.composable.add.AddScreen
import com.example.openinapp.ui.composable.campaign.CampaignsScreen
import com.example.openinapp.ui.composable.courses.CoursesScreen
import com.example.openinapp.ui.composable.dashboard.DashboardScreen
import com.example.openinapp.ui.composable.profile.ProfileScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationComposable(apiResponse: OpenInAppResponse) {
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            Image(
                painter = painterResource(id = R.drawable.ic_blue_add),
                contentDescription = "FAB Icon",
                modifier = Modifier
                    .padding(0.dp)
                    .size(60.dp)
                    .pointerInput(Unit) {
                        detectTapGestures {
                            navController.navigate("Add")
                        }
                    }
                    .offset(y=((10).dp))

            )

        },
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape,
                backgroundColor = Color.White,
                contentPadding = PaddingValues(0.dp),
            ) {
                BottomNavigationComposable(navController = navController)
            }
        },

        ) {
        NavHost(navController = navController, startDestination = Home.route) {
            composable(Home.route) {
                DashboardScreen(response = apiResponse)
            }
            composable(Courses.route) {
                CoursesScreen()
            }
            composable(Add.route) {
                AddScreen()
            }
            composable(Campaigns.route) {
                CampaignsScreen()
            }
            composable(Profile.route) {
                ProfileScreen()
            }
        }

    }
}

// TODO [COMPLETED] -> The Bottom Navigation Composable
@Composable
fun BottomNavigationComposable(navController: NavController) {
    val destinationList = listOf(
        Home,
        Courses,
        Campaigns,
        Profile
    )
    val selectedIndex = rememberSaveable {
        mutableIntStateOf(0)
    }
    BottomNavigation {
        destinationList.forEachIndexed { index, destinations ->
            val startPadding = if (index ==  2) 20.dp else 0.dp
            val endPadding = if (index == 1) 20.dp else 0.dp
            BottomNavigationItem(
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = startPadding, end = endPadding),

                label = {
                    Text(
                        text = destinations.title,
                        fontFamily = FontFamily(Font(R.font.figtree)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 24.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        color = if (index == selectedIndex.intValue) Color(
                            14,
                            111,
                            255,
                            255
                        ) else Color.Black
                    )
                },
                icon = {
                    Image(
                        painter = painterResource(id = destinations.icon),
                        contentDescription = destinations.title,
                        modifier = Modifier.padding(0.dp).size(18.dp),
                        colorFilter = if (index == selectedIndex.intValue) ColorFilter.tint(
                            Color(14, 111, 255, 255)
                        ) else null
                    )
                },
                selected = index == selectedIndex.intValue,
                onClick = {
                    selectedIndex.intValue = index
                    navController.navigate(destinationList[index].route) {
                        // To remove everything from stack till "Home"
                        popUpTo(Home.route)
                        // To prevent adding the same screen more than once
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}



