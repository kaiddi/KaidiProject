package com.kaidi.demo.util.dialog

import android.app.AlertDialog
import android.content.Context


/**
 * @创建者 ykd
 * @描述
 */
class BInterceptorImpl :DialogInterceptor {
    override fun show(context: Context, next: Chain) {
        if (enable()) {
            AlertDialog.Builder(context)
                .setTitle("DialogB")
                .setNegativeButton("否") { p0, p1 ->

                }.setPositiveButton("是") { p0, p1 ->
                    next.proceed(context)
                }
                .create()
                .show()
        }
    }

    override fun enable() = true
}
