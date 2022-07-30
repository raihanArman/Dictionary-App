package com.example.dictionary.presentation.feature.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.animequotes.base.wrapper.ViewResource
import com.example.dictionary.base.arch.BaseViewModel
import com.example.dictionary.domain.usecase.GetWordInfoUseCase
import com.example.dictionary.domain.viewparams.WordInfo
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
class HomeViewModel(
    private val getWordInfoUseCase: GetWordInfoUseCase
): BaseViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null

    fun onSearch(query: String){
        _searchQuery.value = query
        if(query.isNotEmpty()) {
            _state.value = state.value.copy(
                isLoading = true
            )
            searchJob?.cancel()
            searchJob = viewModelScope.launch {
                delay(500)
                getWord(query)
            }
        }else{
            _state.value = state.value.copy(
                isLoading = false
            )
        }
    }

    fun getWord(query: String){
        launch {
            getWordInfoUseCase(GetWordInfoUseCase.Param(query))
                .collect { result ->
                    when (result) {
                        is ViewResource.Success -> {
                            _state.value = state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is ViewResource.Error -> {
                            _state.value = state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = false,
                                errorMessage = result.message
                            )
                            _eventFlow.emit(
                                UIEvent.ShowSnackbar(
                                    result.message ?: "Unknown error"
                                )
                            )
                        }
                        is ViewResource.Loading -> {
                            _state.value = state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }
        }
    }


    sealed class UIEvent{
        data class ShowSnackbar(val message: String): UIEvent()
    }

}