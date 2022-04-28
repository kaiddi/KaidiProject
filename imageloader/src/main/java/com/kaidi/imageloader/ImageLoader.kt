package com.kaidi.imageloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

/**
 * @创建者 ykd
 * @描述
 * TODO 线程池 原理
 */
object ImageLoader {

    const val TAG = "ImageLoader"

    private val mImageCache = ImageCache()

    private val mExecutorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    private val mUIHandler = Handler(Looper.getMainLooper())

    fun displayImage(url: String, imageView: ImageView) {
        val cacheBitmap = mImageCache.get(url)
        if (cacheBitmap != null) {
            imageView.setImageBitmap(cacheBitmap)
            return
        }

        imageView.tag = url
        mExecutorService.submit {
            val bitmap = downloadImage(url) ?: return@submit
            if (imageView.tag == url) {
                updateImageView(imageView, bitmap)
            }
            mImageCache.put(url, bitmap)
        }
    }

    private fun updateImageView(imageView: ImageView, bitmap: Bitmap) {
        mUIHandler.post {
            imageView.setImageBitmap(bitmap)
        }
    }

    private fun downloadImage(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val url = URL(imageUrl)
            val conn = url.openConnection() as HttpURLConnection
            bitmap = BitmapFactory.decodeStream(conn.inputStream)
            conn.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }
}
