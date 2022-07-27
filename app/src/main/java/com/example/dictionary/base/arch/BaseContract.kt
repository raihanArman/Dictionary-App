package com.example.dictionary.base.arch

import com.example.animequotes.base.wrapper.ViewResource

/**
 * @author Raihan Arman
 * @date 27/07/2022
 */
interface BaseContract {
    interface BaseView {
        fun observeData()
        fun showContent(isContentVisible: Boolean)
        fun showEmptyData(isEmpty: Boolean)
        fun showLoading(isShowLoading: Boolean)
        fun showError(isErrorEnabled: Boolean, exception: Exception? = null)
        fun <T: ViewResource<*>> handleData(viewResource: T)
        fun <T> showData(data: T)
    }

    interface BaseRepository {
        fun logResponse(msg: String?)
    }
}