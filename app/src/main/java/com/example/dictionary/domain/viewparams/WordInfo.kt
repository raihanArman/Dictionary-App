package com.example.dictionary.domain.viewparams

import com.google.gson.annotations.SerializedName

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)