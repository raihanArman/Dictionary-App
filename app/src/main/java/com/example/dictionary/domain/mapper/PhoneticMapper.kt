package com.example.dictionary.domain.mapper

import com.example.dictionary.data.network.model.PhoneticResponse
import com.example.dictionary.domain.viewparams.Phonetic

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
object PhoneticMapper{
    fun PhoneticResponse.mapToViewParam() = Phonetic(
        audio = audio,
        text = text
    )
}