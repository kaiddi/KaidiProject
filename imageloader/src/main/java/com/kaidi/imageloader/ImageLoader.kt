package com.kaidi.imageloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

/**
 * @创建者 ykd
 * @描述
 */
class ImageLoader {

    private lateinit var mImageCache: LruCache<String, Bitmap>

    // TODO 线程池 原理
    private val mExecutorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    private val mUIHandler = Handler(Looper.getMainLooper())

    init {
        initImageLoader()
    }

    private fun initImageLoader() {
        // 取jvm分配给应用的最大内存
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()

        // 取1/4做缓存
        val cacheSize = maxMemory / 4
        // TODO lruCache 原理
        mImageCache = object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String?, bitmap: Bitmap): Int {
                return bitmap.rowBytes * bitmap.height / 1024
            }
        }
    }

    fun displayImage(url: String, imageView: ImageView) {
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
