package com.example.dictionary.domain.usecase

import com.example.animequotes.base.wrapper.DataResource
import com.example.animequotes.base.wrapper.ViewResource
import com.example.dictionary.base.arch.BaseUseCase
import com.example.dictionary.domain.mapper.WordInfoMapper.mapToViewParams
import com.example.dictionary.domain.repository.DictionaryRepository
import com.example.dictionary.domain.viewparams.WordInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
class GetWordInfoUseCase(
    private val repository: DictionaryRepository,
    private val dispatcher: CoroutineDispatcher
): BaseUseCase<GetWordInfoUseCase.Param, MutableList<WordInfo>>(dispatcher) {
    override suspend fun execute(param: Param?): Flow<ViewResource<MutableList<WordInfo>>> =
        repository.getWordInfo(param?.word ?: "").map {resultNetwork ->
            when(resultNetwork){
                is DataResource.Success ->{
                    if (resultNetwork.data?.isEmpty() == true) {
                        ViewResource.Empty()
                    } else {
                        ViewResource.Success(
                            resultNetwork.data?.mapToViewParams()!!
                        )
                    }
                }else ->{
                    ViewResource.Error(resultNetwork.exception)
                }
            }
        }.onStart { emit(ViewResource.Loading()) }



    data class Param(val word: String?)

}