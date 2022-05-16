package com.kaidi.demo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaidi.demo.R
import kotlinx.android.synthetic.main.activity_custom_view.*

/**
 * @创建者 ykd
 * @描述
 */
class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)


        sweepView.start()
    }
}
