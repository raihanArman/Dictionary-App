package com.example.dictionary.domain.viewparams

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
)