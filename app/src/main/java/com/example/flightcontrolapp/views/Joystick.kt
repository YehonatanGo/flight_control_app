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

class Joystick @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs,defStyleAttr) {

    private val paint = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE
        color = Color.BLUE
        isAntiAlias = true
    }
    private var radius: Float = 0f
    private var center: PointF = PointF()
    private var orig_center: PointF = PointF()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = 0.3f* min(width,height)
        center = PointF(width/2.0f, height/2.0f)
    }

    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        paint.color = Color.BLACK
        canvas.drawCircle(center.x, center.y, radius, paint)
    }

    public fun changeColor(){
        paint.color = Color.MAGENTA
        invalidate()
    }

    private var mVelocityTracker: VelocityTracker? = null

    override fun onTouchEvent(event: MotionEvent): Boolean {
         var x_on_down:Float = 0f
         var y_on_down:Float= 0f

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                // Reset the velocity tracker back to its initial state.
                mVelocityTracker?.clear()
                // If necessary retrieve a new VelocityTracker object to watch the
                // velocity of a motion.
                mVelocityTracker = mVelocityTracker ?: VelocityTracker.obtain()
                // Add a user's movement to the tracker.
                mVelocityTracker?.addMovement(event)

                x_on_down = getX()
                y_on_down = getY()
                Log.d("", "X on_down: ${x_on_down}")
                Log.d("", "Y on_down: ${y_on_down}")

            }
            MotionEvent.ACTION_MOVE -> {
                mVelocityTracker?.apply {
                    val pointerId: Int = event.getPointerId(event.actionIndex)
                    addMovement(event)
                    // When you want to determine the velocity, call
                    // computeCurrentVelocity(). Then call getXVelocity()
                    // and getYVelocity() to retrieve the velocity for each pointer ID.
                    computeCurrentVelocity(1000)
                    // Log velocity of pixels per second
                    // Best practice to use VelocityTrackerCompat where possible.
                    Log.d("", "X velocity: ${x_on_down}")
                    Log.d("", "Y velocity: ${y_on_down}")
                    center.x += event.getX() - x_on_down
                    center.y += event.getY() - y_on_down
                    invalidate()
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                // Return a VelocityTracker object back to be re-used by others.
                mVelocityTracker?.recycle()
                mVelocityTracker = null
                center = orig_center
                Log.d("", "X up: ${x_on_down}")
                Log.d("", "Y down: ${y_on_down}")
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

