package com.kaidi.demo.activity.anim

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaidi.demo.R
import kotlinx.android.synthetic.main.activity_anim.*

/**
 * @创建者 ykd
 * @描述
 */
class AnimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        llAddAccount.setOnClickListener {
            val objectAnimation = ObjectAnimator.ofFloat(llAddAccount, "translationX", 0f, -70f)
            objectAnimation.start()
        }
    }
}
