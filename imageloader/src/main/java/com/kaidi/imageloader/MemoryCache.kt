package com.kaidi.imageloader

import android.graphics.Bitmap
import android.util.LruCache

/**
 * @创建者 ykd
 * @描述 采用 lruCache 实现缓存
 * TODO lruCache 原理
 */
class MemoryCache : ImageCache {

    private lateinit var mImageCache: LruCache<String, Bitmap>

    init {
        initImageCache()
    }

    private fun initImageCache() {
        // 取jvm分配给应用的最大内存
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()

        // 取1/4做缓存
        val cacheSize = maxMemory / 4
        mImageCache = object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String?, bitmap: Bitmap): Int {
                return bitmap.rowBytes * bitmap.height / 1024
            }
        }
    }

    override fun put(url: String, bitmap: Bitmap) {
        mImageCache.put(url, bitmap)
    }

    override fun get(url: String): Bitmap? {
        return mImageCache.get(url)
    }
}
