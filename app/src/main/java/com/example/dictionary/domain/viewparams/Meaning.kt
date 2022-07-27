package com.example.dictionary.domain.viewparams

import com.google.gson.annotations.SerializedName

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)