package com.example.dictionary.base.arch

import com.example.animequotes.base.wrapper.ViewResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import kotlin.jvm.Throws

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
abstract class BaseUseCase<P, R: Any?> constructor(
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(param: P? = null): Flow<ViewResource<R>>{
        return execute(param)
            .catch {
                emit(ViewResource.Error(Exception(it)))
            }
            .flowOn(dispatcher)
    }

    @Throws(RuntimeException::class)
    abstract suspend fun execute(param: P? = null): Flow<ViewResource<R>>

}