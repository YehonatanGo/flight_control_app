package com.example.flightcontrolapp.model

import android.util.Log
import java.io.PrintWriter
import java.io.Writer
import java.lang.Thread.sleep
import java.net.Socket
import kotlin.concurrent.thread

class FGModel {
    private lateinit var socket : Socket
    private lateinit var out : Writer
    fun setAileron(new_aileron:Float){
        /*
         TODO: make sure value is not bigger than 1 or smaller than -1 can
         */

        Log.d("", "new_aileron:${new_aileron}")
        thread {
            out.write("set /controls/flight/aileron "+new_aileron+"\r\n")
            out.flush()
        }

    }

    fun setElevator(new_elevator:Float){
        Log.d("", "new_elevator:${new_elevator}\n")
        thread {
            out.write("set /controls/flight/elevator "+new_elevator+"\r\n")
            out.flush()
        }

    }

    fun setRudder(new_rudder: Float){
        thread {
            out.write("set /controls/flight/rudder "+new_rudder+"\r\n")
            out.flush()
        }

    }

    fun setThrottle(new_throttle:Float){
        thread {
            out.write("set /controls/engines/current-engine/throttle " +new_throttle+"\r\n")
            out.flush()
        }

    }

    fun connect(ip:String, port:Int){
        Log.d("","IP: ${ip}, Port: ${port}")
        thread {
            socket = Socket(ip,port)
            out = PrintWriter(socket.getOutputStream(),true)
        }

    }

    fun doStuff() {
        Log.d("", "Did stuff. Happy now?")
    }
}