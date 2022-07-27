package com.example.dictionary.data.network.model


import com.google.gson.annotations.SerializedName

data class PhoneticResponse(
    @SerializedName("audio")
    val audio: String,
    @SerializedName("text")
    val text: String
)