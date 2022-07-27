package com.example.dictionary.data.network

import com.example.dictionary.data.network.model.WordInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
interface DictionaryApi {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): Response<List<WordInfoResponse>>

}