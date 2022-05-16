package com.kaidi.demo.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * @创建者 ykd
 * @描述
 */
class CircleView : View {

    private val mShader = LinearGradient(
        0f, 0f, width.toFloat(), height.toFloat(), Color.parseColor("#E91E63"),
        Color.parseColor("#2196F3"), Shader.TileMode.CLAMP
    )

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 30f
        strokeCap = Paint.Cap.ROUND
    }

    /**
     * 动画绘制比例
     */
    private var mDrawRatio = 1f
        set(value) {
            field = value
            invalidate()
        }

    /**
     * 圆弧之间的间隔
     */
    private var mArcSpace = 5f

    constructor(mContext: Context) : super(mContext, null)

    constructor(mContext: Context, attrs: AttributeSet) : super(mContext, attrs, 0)

    constructor(mContext: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        mContext,
        attrs,
        defStyleAttr
    ) {
        init(mContext, attrs)
    }

    private fun init(mContext: Context, attrs: AttributeSet) {

    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.shader = LinearGradient(
            0f, 0f, width.toFloat(), height.toFloat(), Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"), Shader.TileMode.CLAMP
        )

        val w = width.toFloat()
        val padding = 20f

        val rect = RectF(0f + padding, 0f + padding, w - padding, w - padding)

        canvas.drawArc(
            rect,
            -180f + mArcSpace,
            (180f - mArcSpace * 2) * mDrawRatio,
            false,
            mPaint
        )

        canvas.drawArc(
            rect,
            0f + mArcSpace,
            (180f - mArcSpace * 2) * mDrawRatio,
            false,
            mPaint
        )

    }

    fun startMode1() {
        ObjectAnimator.ofFloat(this, "mDrawRatio", 0f, 1f).apply {
            duration = 2000
            start()
        }
    }

    fun startMode2() {
        val drawAnim = ObjectAnimator.ofFloat(this, "mDrawRatio", 0f, 1f).apply {
            duration = 2000
            repeatCount = -1
            repeatMode = ValueAnimator.REVERSE
        }

        val roteAnim = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f).apply {
            duration = 2000
            repeatCount = -1
        }

        AnimatorSet().apply {
            play(drawAnim).with(roteAnim)
            start()
        }
    }
}
