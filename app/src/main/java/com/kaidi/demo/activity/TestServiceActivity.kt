package com.kaidi.demo.activity

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kaidi.demo.R
import com.kaidi.demo.service.TestService

/**
 * @创建者 ykd
 * @描述
 */
class TestServiceActivity : AppCompatActivity(),ServiceConnection {

    companion object {
        const val TAG = "TestServiceActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_service)

        findViewById<View>(R.id.btn_bind).setOnClickListener {
            //bindservice
            val intent = Intent(this, TestService::class.java)
            bindService(intent, this, Service.BIND_AUTO_CREATE)
        }

        findViewById<View>(R.id.btn_unbind).setOnClickListener {
            unbindService(this)
        }
    }

    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
        Log.e(TAG, "onServiceConnected")
    }

    override fun onServiceDisconnected(p0: ComponentName?) {
        Log.e(TAG, "onServiceDisconnected")
    }
}
