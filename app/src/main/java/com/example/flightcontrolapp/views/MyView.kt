package com.example.flightcontrolapp.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class MyView constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint().apply{
        style = Paint.Style.STROKE
        color = Color.parseColor("#FFC107")
        isAntiAlias = true
    }

    private var radius: Float = 0f
    private var center: PointF = PointF()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = 0.3f * min(width, height).toFloat()
        center = PointF(width/2.0f, height/2.0f)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(center.x, center.y, radius, paint)
    }

}