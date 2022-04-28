package com.kaidi.demo.util.dialog

import android.content.Context

/**
 * @创建者 ykd
 * @描述
 */
interface DialogInterceptor {

    fun show(context: Context, next: Chain)

    fun enable(): Boolean
}
