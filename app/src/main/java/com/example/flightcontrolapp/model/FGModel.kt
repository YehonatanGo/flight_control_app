package com.example.flightcontrolapp.model

import android.util.Log

class FGModel {
    fun setAileron(new_aileron:Float){
        /*
         TODO: make sure value is not bigger than 1 or smaller than -1 can
         */

        Log.d("", "new_aileron:${new_aileron}")
        //out.print("set /controls/flight/aileron "+new_aileron+"\r\n")
    }

    fun setElevator(new_elevator:Float){
        Log.d("", "new_elevator:${new_elevator}\n")
        //out.print("set /controls/flight/elevator "+new_elevator+"\r\n")
    }

    fun setRudder(new_rudder: Float){
        //out.print("set /controls/flight/rudder "+new_rudder+"\r\n")
    }

    fun setThrottle(new_throttle:Float){
        //out.print("set /controls/engines/current-engine/throttle "+v+"\r\n")
    }

    fun connect(ip:String, port:Int){
        // in an new thread, open a socket and connect FG
    }

    fun doStuff() {
        Log.d("", "Did stuff. Happy now?")
    }
}