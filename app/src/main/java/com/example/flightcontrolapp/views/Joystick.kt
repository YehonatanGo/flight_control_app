package com.example.flightcontrolapp.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import kotlin.math.min

private const val DEBUG_TAG = "Velocity"

@FunctionalInterface
interface changeHandler {
    fun onChange(a: Float, e: Float)
}

class Joystick @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE
        color = Color.BLUE
        isAntiAlias = true
    }
    private var radius: Float = 0f
    private var center: PointF = PointF()
    private var orig_center: PointF = PointF(center.x, center.y)
    private var x_on_down: Float = 0f
    private var y_on_down: Float = 0f
    public lateinit var changeHandler: changeHandler

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = 0.25f * min(width, height)
        center = PointF(width / 2.0f, height / 2.0f)
        orig_center = PointF(center.x, center.y)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(center.x, center.y, radius, paint)
    }

    fun changeColor() {
        paint.color = Color.MAGENTA
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
//                    Log.d("", "X velocity: ${x_on_down}")
//                    Log.d("", "Y velocity: ${y_on_down}")
//                Log.d("", "getX: ${event.getX()}")
//                Log.d("", "getY: ${event.getY()}")

                changeHandler.onChange((event.x - orig_center.x)/measuredWidth*2, (event.y - orig_center.y)/measuredHeight*2)
                center.x += event.getX() - x_on_down
                center.y += event.getY() - y_on_down
                x_on_down = event.getX()
                y_on_down = event.getY()
                invalidate()
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                center = PointF(orig_center.x, orig_center.y)
//                Log.d("", "X up: ${x_on_down}")
//                Log.d("", "Y up: ${y_on_down}")
                invalidate()
            }
        }
        return true
    }

    //    interface JoystickMoveHandler {
//        fun handleMove(a: Float, e: Float)
//    }
//    lateinit var moveHandler: JoystickMoveHandler
}

