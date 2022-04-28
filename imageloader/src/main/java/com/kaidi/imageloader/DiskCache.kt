package com.kaidi.imageloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

/**
 * @创建者 ykd
 * @描述 采用 lruCache 实现缓存
 */
class DiskCache : ImageCache {

    companion object {
        const val cacheDir = "sdcard/cache/"
    }

    init {
    }

    override fun put(url: String, bitmap: Bitmap) {
        var fileOutputStream: FileOutputStream? = null
        try {
            fileOutputStream = FileOutputStream(cacheDir + url)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            try {
                fileOutputStream?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }

    override fun get(url: String): Bitmap? {
        return BitmapFactory.decodeFile(cacheDir + url)
    }
}
