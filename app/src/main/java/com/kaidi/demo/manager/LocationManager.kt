package com.kaidi.demo.manager

import android.content.Context
import android.location.Location
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * @创建者 ykd
 * @描述
 */
class LocationManager(
    private val context: Context,
    private val callback: (Location) -> Unit
) : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        start()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        stop()
    }

    private fun start() {
        Log.d("LocationManager","start")
        // 使用高德之类的 SDK 请求地理位置
    }

    private fun stop() {
        Log.d("LocationManager","stop")
        // 停止

    }
}
