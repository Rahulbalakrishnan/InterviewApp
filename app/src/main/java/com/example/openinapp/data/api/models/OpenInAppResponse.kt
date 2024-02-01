package com.example.openinapp.data.api.models


import com.example.openinapp.data.api.models.Data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


// TODO [COMPLETED] -> Generated by "Kotlin data class file from JSON" Extension.

@Serializable
data class OpenInAppResponse(
    @SerialName("applied_campaign")
    val appliedCampaign: Int,
    @SerialName("data")
    val `data`: Data,
    @SerialName("extra_income")
    val extraIncome: Double,
    @SerialName("links_created_today")
    val linksCreatedToday: Int,
    @SerialName("message")
    val message: String,
    @SerialName("startTime")
    val startTime: String,
    @SerialName("status")
    val status: Boolean,
    @SerialName("statusCode")
    val statusCode: Int,
    @SerialName("support_whatsapp_number")
    val supportWhatsappNumber: String,
    @SerialName("today_clicks")
    val todayClicks: Int,
    @SerialName("top_location")
    val topLocation: String,
    @SerialName("top_source")
    val topSource: String,
    @SerialName("total_clicks")
    val totalClicks: Int,
    @SerialName("total_links")
    val totalLinks: Int
)