package com.example.flightcontrolapp.model

import android.util.Log
import java.io.PrintWriter
import java.io.Writer
import java.net.Socket
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.concurrent.thread





class FGModel {
    private lateinit var socket : Socket
    private lateinit var out : Writer
    private var executor : Executor = Executors.newSingleThreadExecutor()


    class SendMessage(private var out: Writer, private var message: String) : Runnable{

        override fun run() {
            out.write(message)
            out.flush()
        }

    }
    fun setAileron(new_aileron:Float){
        /*
         TODO: make sure value is not bigger than 1 or smaller than -1 can
         */

        Log.d("", "new_aileron:${new_aileron}")
        //aileron.sendAileron(new_aileron)
        executor.execute(SendMessage(out,"set /controls/flight/aileron "+new_aileron+"\r\n"))

    }

    fun setElevator(new_elevator:Float){
        Log.d("", "new_elevator:${new_elevator}\n")
        executor.execute(SendMessage(out,"set /controls/flight/elevator "+new_elevator+"\r\n"))

    }

    fun setRudder(new_rudder: Float){
        executor.execute(SendMessage(out,"set /controls/flight/elevator "+new_rudder+"\r\n"))

    }

    fun setThrottle(new_throttle:Float){
        executor.execute(SendMessage(out,"set /controls/engines/current-engine/throttle "+new_throttle+"\r\n"))

    }

    fun connect(ip:String, port:Int){
        Log.d("","IP: ${ip}, Port: ${port}")
        executor.execute(Runnable {
            socket = Socket(ip,port)
            out = PrintWriter(socket.getOutputStream(),true)
        })

    }

    fun doStuff() {
        Log.d("", "Did stuff. Happy now?")
    }
}