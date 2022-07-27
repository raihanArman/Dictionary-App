package com.example.dictionary.data.network.model

import com.google.gson.annotations.SerializedName

data class WordInfoResponse(
    @SerializedName("meanings")
    val meanings: List<MeaningResponse>,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("phonetic")
    val phonetic: String?,
    @SerializedName("phonetics")
    val phonetics: List<PhoneticResponse>,
    @SerializedName("word")
    val word: String
)