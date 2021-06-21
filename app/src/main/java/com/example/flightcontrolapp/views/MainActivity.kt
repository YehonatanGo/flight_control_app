package com.example.flightcontrolapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.flightcontrolapp.R
import kotlinx.android.synthetic.main.activity_main.*
import java.net.Socket

class MainActivity : AppCompatActivity() {
    private lateinit var ip: String;
    private lateinit var port: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun on_button_click(view: View) {
        var joystick = findViewById<Joystick>(R.id.joystick)
        joystick.changeColor()
//        var found : TextView = findViewById<TextView>(R.id.text_box)
//        var editText:EditText = findViewById(R.id.editText)
//        var editText2:EditText = findViewById(R.id.editText2)
//        found.text = editText.text
//        ip = editText.text.toString()
//        port = editText2.text.toString()
//
//        var fg:Socket = Socket("172.19.3.158", 7555)
//        var x = 5
//        var t = Thread{
//            var client = Socket(ip, port.toInt())
//        }


    }
}
