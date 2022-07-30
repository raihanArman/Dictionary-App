package com.example.dictionary.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.dictionary.util.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runners.MethodSorters

/**
 * @author Raihan Arman
 * @date 29/07/2022
 */
@ExperimentalCoroutinesApi
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
abstract class BaseViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineDispatcherRule = MainCoroutineRule()

}

@ExperimentalCoroutinesApi
fun BaseViewModelTest.runBlockingMainTest(block: suspend TestCoroutineScope.() -> Unit): Unit =
    coroutineDispatcherRule.testCoroutineDispatcher.runBlockingTest(block)