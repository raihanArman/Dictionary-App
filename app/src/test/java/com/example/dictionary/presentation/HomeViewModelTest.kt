package com.example.dictionary.presentation

import com.example.animequotes.base.wrapper.ViewResource
import com.example.dictionary.base.BaseViewModelTest
import com.example.dictionary.base.runBlockingMainTest
import com.example.dictionary.domain.mapper.WordInfoMapper.mapToViewParams
import com.example.dictionary.domain.repository.DictionaryRepository
import com.example.dictionary.domain.usecase.GetWordInfoUseCase
import com.example.dictionary.presentation.feature.home.HomeState
import com.example.dictionary.presentation.feature.home.HomeViewModel
import com.example.dictionary.util.DummyWord.getWordInfoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author Raihan Arman
 * @date 29/07/2022
 */

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest: BaseViewModelTest() {

    private lateinit var getWordInfoUseCase: GetWordInfoUseCase
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp(){
        getWordInfoUseCase = Mockito.mock(GetWordInfoUseCase::class.java)
        viewModel = HomeViewModel(getWordInfoUseCase)
    }

    @Test
    fun `Given word info when word info should returns success`() = runBlockingMainTest {

        //GIVEN
        val flowOutput = flowOf(ViewResource.Success(getWordInfoData().mapToViewParams()))

        //WHEN
        Mockito.`when`(getWordInfoUseCase.execute()).thenReturn(flowOutput)
//        Mockito.doReturn(flowOutput).`when`(getWordInfoUseCase).execute()


        print("Viewmodel Test -> ${viewModel.state.value}")

        //THEN
        assert(viewModel.state.value.wordInfoItems.size == 1)

    }

}