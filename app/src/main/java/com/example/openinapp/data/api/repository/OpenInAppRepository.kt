package com.example.openinapp.data.api.repository


import com.example.openinapp.data.api.Resource
import com.example.openinapp.data.api.models.OpenInAppResponse

interface OpenInAppRepository {
    suspend fun getOpenInAppResponse(): Resource<OpenInAppResponse>
}