package com.kaidi.demo.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kaidi.demo.R
import com.kaidi.demo.activity.anim.AnimActivity
import com.kaidi.demo.activity.touch.TouchTestActivity
import com.kaidi.demo.manager.LocationManager
import com.kaidi.demo.util.dialog.AInterceptorImpl
import com.kaidi.demo.util.dialog.BInterceptorImpl
import com.kaidi.demo.util.dialog.DialogManager
import com.kaidi.imageloader.ImageLoader
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @创建者 ykd
 * @描述
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animTest()
//        touchEventTest()
//        screenChangeTest()
//        serviceTest()
//        lifecycleScopeTest()
//        locationTest()
//        imageLoaderTest()
//        dialogInterceptorTest()
    }

    private fun animTest() {
        btn1.setOnClickListener {
            startActivity(Intent(this, AnimActivity::class.java))
        }
    }

    private fun touchEventTest() {
        findViewById<View>(R.id.btn1).setOnClickListener {
            startActivity(Intent(this, TouchTestActivity::class.java))
        }
    }

    private fun screenChangeTest() {
        findViewById<View>(R.id.btn1).setOnClickListener {
            startActivity(Intent(this, ScreenChangeActivity::class.java))
        }
    }

    private fun serviceTest() {
        findViewById<View>(R.id.btn1).setOnClickListener {
            startActivity(Intent(this, TestServiceActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun lifecycleScopeTest() {
        // 协程也是有生命周期的，使用 lifecycleScope 可以确保宿主销毁后，当中的协程任务也被取消
        lifecycleScope.launchWhenResumed {

        }
    }

    private fun locationTest() {
        val locationManager = LocationManager(this) {

        }
        lifecycle.addObserver(locationManager)
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

        findViewById<View>(R.id.btn1).setOnClickListener {
            DialogManager.show(this)
        }
    }
}
