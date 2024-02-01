package com.example.openinapp.navigation

import com.example.openinapp.R



// TODO -> Add/Update/Delete Destinations here
interface Destinations {
    val route: String
    val icon: Int
    val title: String
}

object Home: Destinations {
    override val route = "Home"
    override val icon = R.drawable.ic_links
    override val title = "Links"
}

object Courses: Destinations {
    override val route = "Courses"
    override val icon = R.drawable.ic_magazine
    override val title ="Courses"
}

object Add: Destinations {
    override val route ="Add"
    override val icon = R.drawable.ic_blue_add
    override val title ="Add"
}

object Campaigns: Destinations {
    override val route = "Campaign"
    override val icon = R.drawable.ic_campaign
    override val title ="Campaign"
}

object Profile: Destinations {
    override val route = "Profile"
    override val icon = R.drawable.ic_user
    override val title ="Profile"
}