package com.example.flightcontrolapp.view_model

import android.util.Log
import com.example.flightcontrolapp.model.FGModel

class ViewModel {
    private val model = FGModel()

    fun setAileron(new_aileron: Float) {
        model.setAileron(new_aileron)
    }

    fun setElevator(new_elevator: Float) {
        model.setElevator(new_elevator)
    }

    fun setRudder(new_rudder: Float) {
        model.setAileron(new_rudder)
    }

    fun setThrottle(new_throttle: Float) {
        model.setAileron(new_throttle)
    }

    fun fake(v:Float){
        Log.d("", "got ya!")
    }

    fun doStuff(){
        model.doStuff()
    }


}