package com.example.openinapp.data.local

import com.example.openinapp.R
// TODO [COMPLETED] -> update this here for further expansion.


data class Link(
    val image: Int,
    val companyName: String,
    val date: String,
    val count: String,
    val info: String,
    val url: String
)

// TODO [COMPLETED] -> Customized Link based on assignment needs.
data class LinkApi(
    val image: String,
    val companyName: String,
    val date: String,
    val count: Int,
    val info: String ,
    val url: String
)

// TODO [COMPLETED] -> Dummy Data used during UI Prep.
val Links = listOf(
    Link(
        R.drawable.ic_company_logo, "Sample link name...", "22 Aug 2022",
        "2323", "Clicks", "https://samplelink.oia.bio/ashd..."
    ),
    Link(
        R.drawable.ic_company_logo, "Sample link name...", "22 Aug 2022",
        "2323", "Clicks", "https://samplelink.oia.bio/ashd..."
    ),
    Link(
        R.drawable.ic_company_logo, "Sample link name...", "22 Aug 2022",
        "2323", "Clicks", "https://samplelink.oia.bio/ashd..."
    ),
    Link(
        R.drawable.ic_company_logo, "Sample link name...", "22 Aug 2022",
        "2323", "Clicks", "https://samplelink.oia.bio/ashd..."
    ), Link(
        R.drawable.ic_company_logo, "Sample link name...", "22 Aug 2022",
        "2323", "Clicks", "https://samplelink.oia.bio/ashd..."
    )


)