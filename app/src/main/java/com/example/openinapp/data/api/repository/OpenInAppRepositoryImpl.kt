package com.example.openinapp.data.api.repository


import io.ktor.client.HttpClient
import io.ktor.client.request.get
import com.example.openinapp.data.api.Resource
import com.example.openinapp.data.api.models.OpenInAppResponse
import com.example.openinapp.data.api.network.BASE_URL
import javax.inject.Inject

private const val DASHBOARD_URL = "$BASE_URL/api/v1/dashboardNew"

class OpenInAppRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : OpenInAppRepository {

    override suspend fun getOpenInAppResponse(): Resource<OpenInAppResponse> {
        return try {
            val response: OpenInAppResponse = httpClient.get(DASHBOARD_URL)
            Resource.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}