package com.kaidi.demo.service

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import android.util.Log

/**
 * @创建者 ykd
 * @描述
 */
class TestService:Service() {

    companion object{
        const val TAG = "TestService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG,"onCreate")
    }
    override fun onBind(p0: Intent?): IBinder? {
        Log.e(TAG,"onBind")
        return Binder()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG,"onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG,"onUnbind")
        return super.onUnbind(intent)
    }

    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
        Log.e(TAG,"unbindService")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy")
    }
}
