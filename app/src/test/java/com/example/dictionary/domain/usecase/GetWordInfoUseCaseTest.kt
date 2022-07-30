package com.example.dictionary.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.animequotes.base.wrapper.DataResource
import com.example.dictionary.util.DummyWord.getWordInfoData
import com.example.dictionary.domain.repository.DictionaryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
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
class GetWordInfoUseCaseTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DictionaryRepository
    private lateinit var useCase: GetWordInfoUseCase

    @Before
    fun setUp(){
        useCase = GetWordInfoUseCase(repository, Dispatchers.IO)
    }

    @Test
    fun `When execute then returns expected wordlist`() = runTest{
        withContext(Dispatchers.Default) {
            // GIVEN
            val inputFlow = flowOf(DataResource.Success(getWordInfoData()))
            Mockito.`when`(repository.getWordInfo("")).thenReturn(inputFlow)

            val output = useCase.execute().last()

            // THEN
            assert(output.data?.size == 1)
        }
    }

}