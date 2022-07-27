package com.example.dictionary.presentation.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.animequotes.base.wrapper.ViewResource
import com.example.dictionary.base.arch.BaseViewModel
import com.example.dictionary.domain.usecase.GetWordInfoUseCase
import com.example.dictionary.domain.viewparams.WordInfo
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
class HomeViewModel(
    private val getWordInfoUseCase: GetWordInfoUseCase
): BaseViewModel() {

    val observeWordInfo: LiveData<ViewResource<MutableList<WordInfo>>>
        get() = _observeWordInfo
    private val _observeWordInfo = MutableLiveData<ViewResource<MutableList<WordInfo>>>()

    fun getWordInfo(word: String){
        viewModelScope.launch {
            getWordInfoUseCase(GetWordInfoUseCase.Param(word))
                .collect{
                    _observeWordInfo.value = it
                }
        }
    }

}