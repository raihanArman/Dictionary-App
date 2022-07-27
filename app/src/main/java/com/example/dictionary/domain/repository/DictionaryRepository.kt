package com.example.dictionary.domain.repository

import com.example.animequotes.base.wrapper.DataResource
import com.example.dictionary.data.network.model.WordInfoResponse
import kotlinx.coroutines.flow.Flow

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
interface DictionaryRepository {
    suspend fun getWordInfo(word: String): Flow<DataResource<List<WordInfoResponse>>>
}