package com.example.dictionary.data.network.model

import com.google.gson.annotations.SerializedName

data class MeaningResponse(
    @SerializedName("definitions")
    val definitions: List<DefinitionResponse>,
    @SerializedName("partOfSpeech")
    val partOfSpeech: String
)