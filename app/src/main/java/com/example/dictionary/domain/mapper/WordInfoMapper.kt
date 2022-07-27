package com.example.dictionary.domain.mapper

import com.example.dictionary.data.network.model.WordInfoResponse
import com.example.dictionary.domain.mapper.MeaningMapper.mapToViewParam
import com.example.dictionary.domain.mapper.WordInfoMapper.mapToViewParams
import com.example.dictionary.domain.viewparams.WordInfo

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
object WordInfoMapper {
    fun WordInfoResponse.mapToViewParam() = WordInfo(
        meanings = meanings.map {it.mapToViewParam()},
        origin = origin ?: "",
        phonetic = phonetic ?: "",
        word = word
    )

    fun List<WordInfoResponse>?.mapToViewParams() = mutableListOf<WordInfo>().apply {
        addAll(this@mapToViewParams?.map {
            it.mapToViewParam()
        } ?: listOf())
    }
}