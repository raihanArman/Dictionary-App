package com.example.dictionary.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.dictionary.util.DummyWord.getWordInfoData
import com.example.dictionary.data.network.DictionaryApi
import com.example.dictionary.data.network.datasource.DictionaryNetworkDataSourceImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class NetworkDataSourceTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var api: DictionaryApi

    private lateinit var networkDataSource: DictionaryNetworkDataSourceImpl

    @Before
    fun setUp(){
        networkDataSource = DictionaryNetworkDataSourceImpl(api)
    }

    @Test
    fun `Given word info when returns success`() = runBlocking {
        // GIVEN
        val data = getWordInfoData()
        Mockito.`when`(api.getWordInfo("")).thenReturn(Response.success(data))

        //WHEN
        val output = networkDataSource.getWordInfo("")

        //THEN
        assert(output.body()?.size == 1)
    }

//    @Test
//    fun `Given word info when returns error`() = runBlocking {
//        //GIVEN
//        Mockito.`when`(api.getWordInfo("")).thenReturn(Response.error(500, "".toResponseBody()))
//
//        //WHEN
//        val output = networkDataSource.getWordInfo("")
//
//
//        //THEN
//        assert(output.message() == Response.error<List<WordInfoResponse>>())
//
//    }

}