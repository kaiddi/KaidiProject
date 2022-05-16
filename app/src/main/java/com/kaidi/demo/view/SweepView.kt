package com.kaidi.demo.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.kaidi.demo.R

/**
 * @创建者 ykd
 * @描述
 */
class SweepView : View {

    private val mPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader =
                SweepGradient(
                    width / 2f,
                    height / 2f,
                    Color.parseColor("#E91E63"),
                    Color.parseColor("#2196F3")
                )

            colorFilter = LightingColorFilter(0x00ffff, 0x000000)

        }
    }

    private val mTextPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            setShadowLayer(10f, 10f, 10f, Color.GRAY)
            textSize = 50f
        }
    }

    private val mBitmapShaderPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            val bitmap1 = BitmapFactory.decodeResource(resources, R.mipmap.batman)
            val shader1 = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

            val bitmap2 = BitmapFactory.decodeResource(resources, R.mipmap.batman_logo)
            val shader2 = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

            shader = ComposeShader(shader1, shader2, PorterDuff.Mode.DST_OUT)

//            maskFilter = EmbossMaskFilter(floatArrayOf(), 0.2f, 8f, 1f)
            maskFilter = BlurMaskFilter(50f,BlurMaskFilter.Blur.NORMAL)
        }
    }

    private var mSweepRatio = 1f
        set(value) {
            field = value
            invalidate()
        }

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

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        canvas?.drawArc(
//            0f, 0f, width.toFloat(), height.toFloat(), 0f, 360f * mSweepRatio, true, mPaint
//        )

//        canvas?.drawText("Hello World", 80f, 300f, mTextPaint);

        val radius = 220f

        canvas?.drawCircle(
            radius,
            radius,
            radius,
            mBitmapShaderPaint
        )

    }

    fun start() {
        /*  ObjectAnimator.ofFloat(this, "mSweepRatio", 0f, 1f).apply {
              duration = 2000
              repeatCount = -1
              start()
          }*/
    }
}
