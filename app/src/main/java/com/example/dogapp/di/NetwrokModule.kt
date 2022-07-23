package com.example.dogapp.di

import com.example.dogapp.network.ApiRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun retrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Singleton
    @Provides
    fun apiFactory(retrofit: Retrofit) = retrofit.create(ApiRequest::class.java)
}