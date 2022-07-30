package com.example.dictionary.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.dictionary.util.DummyWord.getWordInfoData
import com.example.dictionary.data.network.datasource.DictionaryNetworkDataSource
import com.example.dictionary.domain.repository.DictionaryRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

/**
 * @author Raihan Arman
 * @date 29/07/2022
 */

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DictionaryRepositoryImplTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var repository: DictionaryRepository

    @Mock
    lateinit var networkDataSource: DictionaryNetworkDataSource

    @Before
    fun setUp(){
        repository = DictionaryRepositoryImpl(networkDataSource)
    }

    @Test
    fun `Given word info when returns success`() = runBlocking {
        //GIVEN
        val data = getWordInfoData()
        Mockito.`when`(networkDataSource.getWordInfo("")).thenReturn(Response.success(data))

        //WHEN
        val output = repository.getWordInfo("").last()

        //THEN
        assert(output.data?.size == 1)
    }

}