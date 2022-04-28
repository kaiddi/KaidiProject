package com.kaidi.demo.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kaidi.demo.R
import com.kaidi.demo.util.dialog.AInterceptorImpl
import com.kaidi.demo.util.dialog.BInterceptorImpl
import com.kaidi.demo.util.dialog.DialogManager
import com.kaidi.imageloader.ImageLoader

/**
 * @创建者 ykd
 * @描述
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageLoaderTest()
//        dialogInterceptorTest()
    }

    private fun imageLoaderTest() {
        ImageLoader.displayImage(
            url = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png",
            imageView = findViewById(R.id.imageview)
        )

        Handler(Looper.getMainLooper()).postDelayed({
            ImageLoader.displayImage(
                url = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png",
                imageView = findViewById(R.id.imageview2)
            )
        }, 2000)
    }

    private fun dialogInterceptorTest() {
        DialogManager.addInterceptor(AInterceptorImpl())
        DialogManager.addInterceptor(BInterceptorImpl())

        findViewById<View>(R.id.btn_show).setOnClickListener {
            DialogManager.show(this)
        }
    }
}
