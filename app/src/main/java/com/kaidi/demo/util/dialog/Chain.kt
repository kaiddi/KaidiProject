package com.kaidi.demo.util.dialog

import android.content.Context

/**
 * @创建者 ykd
 * @描述
 */
class Chain(val interceptors: MutableList<DialogInterceptor>, val index: Int) {

    fun proceed(context :Context) {
        val next = Chain(interceptors,index + 1)

        val curInterceptor = interceptors.getOrNull(index)
        curInterceptor?.show(context,next)
    }
}
