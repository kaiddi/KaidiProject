package com.kaidi.imageloader

import android.graphics.Bitmap

/**
 * @创建者 ykd
 * @描述
 */
class DoubleCache : ImageCache {
    private val mDiskCache = DiskCache()
    private val mMemoryCache = MemoryCache()

    override fun put(url: String, bitmap: Bitmap) {
        mDiskCache.put(url, bitmap)
        mMemoryCache.put(url, bitmap)
    }

    override fun get(url: String): Bitmap? {
        var bitmap: Bitmap?
        bitmap = mMemoryCache.get(url)
        if (bitmap == null) {
            bitmap = mDiskCache.get(url)
        }
        return bitmap
    }

}
