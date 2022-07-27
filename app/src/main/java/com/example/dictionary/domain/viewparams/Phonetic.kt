package com.example.dictionary.domain.viewparams


import com.google.gson.annotations.SerializedName

data class Phonetic(
    val audio: String,
    val text: String
)