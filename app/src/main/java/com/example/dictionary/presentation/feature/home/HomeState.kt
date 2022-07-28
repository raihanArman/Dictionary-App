package com.example.dictionary.presentation.feature.home

import com.example.dictionary.domain.viewparams.WordInfo

/**
 * @author Raihan Arman
 * @date 28/07/2022
 */

data class HomeState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)