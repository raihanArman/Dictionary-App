package com.example.dictionary.util

import com.example.dictionary.data.network.model.WordInfoResponse

/**
 * @author Raihan Arman
 * @date 29/07/2022
 */
object DummyWord {
    fun getWordInfoData() = listOf(
            WordInfoResponse(
                meanings = emptyList(),
                origin = "item",
                phonetic = "item",
                word = "item",
                phonetics = emptyList()
            ),
        )

}