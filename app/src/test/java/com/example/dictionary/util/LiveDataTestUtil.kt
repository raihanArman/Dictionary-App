package com.example.dictionary.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * @author Raihan Arman
 * @date 29/07/2022
 */

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data = o
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    afterObserve.invoke()

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        this.removeObserver(observer)
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}

/**
 * Observes a [LiveData] until the `block` is done executing.
 */
fun <T> LiveData<T>.observeForTesting(block: () -> Unit) {
    val observer = Observer<T> { }
    try {
        observeForever(observer)
        block()
    } finally {
        removeObserver(observer)
    }
}