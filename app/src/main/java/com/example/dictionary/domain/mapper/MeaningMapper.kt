package com.example.dictionary.domain.mapper

import com.example.dictionary.data.network.model.MeaningResponse
import com.example.dictionary.domain.mapper.DefinitionMapper.mapToViewParam
import com.example.dictionary.domain.viewparams.Meaning

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
object MeaningMapper {
    fun MeaningResponse.mapToViewParam() = Meaning(
        definitions = definitions.map { it.mapToViewParam() },
        partOfSpeech = partOfSpeech
    )
}