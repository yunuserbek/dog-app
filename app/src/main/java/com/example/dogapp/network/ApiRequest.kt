package com.example.dogapp.network

import com.example.dogapp.model.Dog
import retrofit2.Response
import retrofit2.http.GET

interface ApiRequest {
    @GET("api/breeds/image/random")
    suspend fun getRandomDog():Response<Dog>
}