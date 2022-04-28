package com.kaidi.demo.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kaidi.demo.R
import com.kaidi.demo.util.dialog.AInterceptorImpl
import com.kaidi.demo.util.dialog.BInterceptorImpl
import com.kaidi.demo.util.dialog.DialogManager

/**
 * @创建者 ykd
 * @描述
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DialogManager.addInterceptor(AInterceptorImpl())
        DialogManager.addInterceptor(BInterceptorImpl())

        findViewById<View>(R.id.btn_show).setOnClickListener {
            DialogManager.show(this)
        }
    }
}
