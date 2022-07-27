package com.example.dictionary.data.network.datasource

import com.example.dictionary.data.network.DictionaryApi
import com.example.dictionary.data.network.model.WordInfoResponse
import retrofit2.Response

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */

class DictionaryNetworkDataSourceImpl(
    private val api: DictionaryApi
): DictionaryNetworkDataSource{
    override suspend fun getWordInfo(word: String): Response<List<WordInfoResponse>> {
        return api.getWordInfo(word)
    }
}

interface DictionaryNetworkDataSource {
    suspend fun getWordInfo(word: String): Response<List<WordInfoResponse>>
}