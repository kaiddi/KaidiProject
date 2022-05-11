package com.kaidi.demo.activity.touch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.kaidi.demo.R
import com.kaidi.demo.adapter.TestAdapter

/**
 * @创建者 ykd
 * @描述 滑动冲突
 */
class TouchTestActivity : AppCompatActivity() {
    companion object {
        const val TAG = "TouchTestActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_test)


        val list = mutableListOf<String>()
        for (i in 1..10){
            list.add(i.toString())
        }
        val adapter = TestAdapter(list)
        findViewById<RecyclerView>(R.id.recyclerview).adapter = adapter
    }
}
