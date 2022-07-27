package com.example.dictionary.domain.mapper

import com.example.dictionary.data.network.model.DefinitionResponse
import com.example.dictionary.domain.viewparams.Definition

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
object DefinitionMapper {
    fun DefinitionResponse.mapToViewParam() = Definition(
        antonyms = antonyms,
        definition = definition,
        example = example ?: "",
        synonyms = synonyms
    )
//    fun QuoteResponse?.mapToViewParam() = Quote(
//        id = this?.id ?: 0,
//        anime = this?.anime.orEmpty(),
//        name = this?.name.orEmpty(),
//        quote = this?.quote.orEmpty(),
//    )

}