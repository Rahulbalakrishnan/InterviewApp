package com.example.openinapp.data.api.di

import com.example.openinapp.data.api.repository.OpenInAppRepository
import com.example.openinapp.data.api.repository.OpenInAppRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import com.example.openinapp.data.api.network.OpenInAppHttpClient


// TODO [COMPLETED] -> Module Setup

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun getHttpClient(httpClient: OpenInAppHttpClient): HttpClient = httpClient.getHttpClient()

    @Provides
    fun getOpenInAppRepository(impl: OpenInAppRepositoryImpl): OpenInAppRepository = impl

}