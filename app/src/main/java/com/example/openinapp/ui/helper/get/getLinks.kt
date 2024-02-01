package com.example.openinapp.ui.helper.get

import com.example.openinapp.data.api.models.RecentLink
import com.example.openinapp.data.api.models.TopLink
import com.example.openinapp.data.local.LinkApi


fun convertToLinkListApi(topLinks: List<TopLink>): List<LinkApi> {
    return topLinks.map { convertToLinkApi(it) }
}


fun convertToLinkApi(topLink: TopLink): LinkApi {
    return LinkApi(
        image = topLink.originalImage,
        companyName = topLink.title,
        date = topLink.createdAt,
        count = topLink.totalClicks,
        info = "Clicks",
        url = topLink.webLink
    )
}


fun convertToLinkListApiRecent(recentLink: List<RecentLink>): List<LinkApi> {
    return recentLink.map { convertToLinkApiRecent(it) }
}


fun convertToLinkApiRecent(recentLink: RecentLink): LinkApi {
    return LinkApi(
        image = recentLink.originalImage,
        companyName = recentLink.title,
        date = recentLink.createdAt,
        count = recentLink.totalClicks,
        info = "Clicks",
        url = recentLink.webLink
    )
}
