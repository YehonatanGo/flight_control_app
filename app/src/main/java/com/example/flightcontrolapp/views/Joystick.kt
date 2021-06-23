package com.example.flightcontrolapp.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlin.math.max
import kotlin.math.min


@FunctionalInterface
interface changeHandler {
    fun onChange(a: Float, e: Float)
}

class Joystick @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    lateinit var changeHandler: changeHandler
    private val innerCircle = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE
        color = 0xfafafa
        isAntiAlias = true
    }
    private val outterCircle = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth  = 10F
        color = Color.BLACK
    }
    private var radius: Float = 0f
    private var center: PointF = PointF()
    private var orig_center: PointF = PointF(center.x, center.y)
    private var x_on_down: Float = 0f
    private var y_on_down: Float = 0f


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = 0.25f * min(width, height)
        center = PointF(width / 2.0f, height / 2.0f)
        orig_center = PointF(center.x, center.y)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(orig_center.x, orig_center.y, radius * 1.8f, outterCircle)

        canvas.drawCircle(center.x, center.y, radius, innerCircle)

    }

    fun changeColor() {
        innerCircle.color = Color.RED
        outterCircle.color = Color.GRAY
        outterCircle.style = Paint.Style.FILL_AND_STROKE
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                x_on_down = event.getX()
                y_on_down = event.getY()
                Log.d("", "X on_down: ${x_on_down}")
                Log.d("", "Y on_down: ${y_on_down}")

            }
            MotionEvent.ACTION_MOVE -> {

                changeHandler.onChange(
                    (event.x - orig_center.x) / measuredWidth * 2,
                    (event.y - orig_center.y) / measuredHeight * 2
                )
                center.x = max(min(center.x + event.getX() - x_on_down, width.toFloat()), 0f)
                center.y = max(min(center.y + event.getY() - y_on_down, height.toFloat()), 0f)

                x_on_down = event.getX()
                y_on_down = event.getY()
                invalidate()
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                center = PointF(orig_center.x, orig_center.y)
                invalidate()
            }
        }
        return true
    }
}