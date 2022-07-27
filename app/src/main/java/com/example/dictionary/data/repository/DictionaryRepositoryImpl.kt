package com.example.dictionary.data.repository

import com.example.animequotes.base.wrapper.DataResource
import com.example.dictionary.base.arch.BaseRepositoryImpl
import com.example.dictionary.data.network.datasource.DictionaryNetworkDataSource
import com.example.dictionary.data.network.model.WordInfoResponse
import com.example.dictionary.domain.repository.DictionaryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
class DictionaryRepositoryImpl(
    private val networkDataSource: DictionaryNetworkDataSource
): DictionaryRepository, BaseRepositoryImpl() {
    override suspend fun getWordInfo(word: String): Flow<DataResource<List<WordInfoResponse>>> = flow {
        emit(safeNetwrokCall { networkDataSource.getWordInfo(word) })
    }
}