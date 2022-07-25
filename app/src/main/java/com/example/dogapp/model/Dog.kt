package com.example.dogapp.model

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("message")
    val url: String,
    val status: String
)