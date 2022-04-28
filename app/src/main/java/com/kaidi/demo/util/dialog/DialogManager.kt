package com.kaidi.demo.util.dialog

import android.content.Context

/**
 * @创建者 ykd
 * @描述
 */
object DialogManager {

    private val mInterceptors = mutableListOf<DialogInterceptor>()
    private val mChain = Chain(mInterceptors, 0)

    fun addInterceptor(interceptor: DialogInterceptor) {
        mInterceptors.add(interceptor)
    }

    fun show(context: Context) {
        mChain.proceed(context)
    }
}
