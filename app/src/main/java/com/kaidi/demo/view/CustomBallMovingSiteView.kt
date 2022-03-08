package com.kaidi.demo.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView

/**
 * @创建者 ykd
 * @描述
 */
class CustomBallMovingSiteView(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    FrameLayout(context, attributeSet, defStyleAttr) {

    private lateinit var ballContainerIv: ImageView
    private val radius = 50
    private val ballDrawable = BallDrawable()


    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    init {
        initView(context)
    }

    private fun initView(context: Context) {
        //generate a ball by dynamic
        ballContainerIv = ImageView(context).apply {
            layoutParams = LayoutParams(radius * 2, radius * 2).apply {
                gravity = Gravity.CENTER
            }

            setImageDrawable(ballDrawable)
            //setBackgroundColor(Color.BLUE)
        }

        addView(ballContainerIv)
        setWillNotDraw(false)
    }
}
