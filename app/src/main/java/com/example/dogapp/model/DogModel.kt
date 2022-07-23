package com.example.dogapp.model

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("message")
    val url: String,
    val status: String
)