package com.example.dictionary.di

import com.example.dictionary.data.network.datasource.DictionaryNetworkDataSource
import com.example.dictionary.data.network.datasource.DictionaryNetworkDataSourceImpl
import com.example.dictionary.data.repository.DictionaryRepositoryImpl
import com.example.dictionary.di.NetworkModule.network
import com.example.dictionary.domain.repository.DictionaryRepository
import com.example.dictionary.domain.usecase.GetWordInfoUseCase
import com.example.dictionary.presentation.feature.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

/**
 * @author Raihan Arman
 * @date 14/07/2022
 */
object InjectionModules {
    fun getModules() = listOf(network, dataSource, repository, useCases, viewModels)

    private val dataSource = module {
        single<DictionaryNetworkDataSource> { DictionaryNetworkDataSourceImpl(get()) }
    }

    private val repository = module {
        single<DictionaryRepository> { DictionaryRepositoryImpl(get()) }
    }

    private val useCases = module {
        single { GetWordInfoUseCase(get(), dispatcher = Dispatchers.IO) }
    }

    private val viewModels = module {
        single { HomeViewModel(get()) }
    }

}