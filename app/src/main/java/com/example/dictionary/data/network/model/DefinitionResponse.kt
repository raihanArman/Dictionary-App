package com.example.dictionary.data.network.model

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
data class DefinitionResponse(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
)