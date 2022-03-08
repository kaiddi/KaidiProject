package com.kaidi.demo.view

import android.graphics.*
import android.graphics.drawable.Drawable
import com.drawable.learning.tools.px

/**
 * @创建者 ykd
 * @描述 篮球🏀
 */
class BallDrawable : Drawable() {
    val paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#D2691E")
    }

    val linePaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 1f.px
        color = Color.BLACK
    }

    override fun draw(canvas: Canvas) {
        val width = bounds.width().toFloat()
        val height = bounds.height().toFloat()

        val radius = width / 2
        canvas.drawCircle(width / 2, height / 2, radius, paint)

        canvas.drawLine(0f, height / 2, width, height / 2, linePaint)
        canvas.drawLine(width / 2, 0f, width / 2, height, linePaint)

        val path = Path()
        val sinValue = kotlin.math.sin(Math.toRadians(45.0)).toFloat()
        //left curve
        path.moveTo(radius - sinValue * radius,
            radius - sinValue * radius
        )
        path.cubicTo(radius - sinValue * radius,
            radius - sinValue * radius,
            radius,
            radius,
            radius - sinValue * radius,
            radius + sinValue * radius
        )
        //right curve
        path.moveTo(radius + sinValue * radius,
            radius - sinValue * radius
        )
        path.cubicTo(radius + sinValue * radius,
            radius - sinValue * radius,
            radius,
            radius,
            radius + sinValue * radius,
            radius + sinValue * radius
        )
        canvas.drawPath(path, linePaint)
    }

    override fun setAlpha(p0: Int) {
        paint.alpha = alpha

    }

    override fun setColorFilter(p0: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return when (paint.alpha) {
            0xff -> PixelFormat.OPAQUE
            0x00 -> PixelFormat.TRANSPARENT
            else -> PixelFormat.TRANSLUCENT
        }
    }

}
