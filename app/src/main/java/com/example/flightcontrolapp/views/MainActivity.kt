package com.example.flightcontrolapp.views

import android.net.InetAddresses.isNumericAddress
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.flightcontrolapp.R
import com.example.flightcontrolapp.view_model.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    private lateinit var ip: String
    private var port: Int = 0
    private val view_model = ViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var joystick = findViewById<Joystick>(R.id.joystick)


        joystick.changeHandler = object : changeHandler {
            override fun onChange(a: Float, e: Float) {
                view_model.setAileron(a)
                view_model.setElevator(e)
            }
        }

        val throttleSeekBar = findViewById<VerticalSeekBar>(R.id.throttle)
        throttleSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                view_model.setThrottle(progress.toFloat() / 100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

        }
        )

        val rudderSeekBar = findViewById<SeekBar>(R.id.rudder)
        rudderSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                view_model.setRudder(progress.toFloat() / 100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        }
        )

    }


    fun validateFields(ip: EditText, port: EditText): Boolean {

        if (ip.getText().length < 1) {
            ip.setError("Your Input is too short");
            return false;
        } else if (port.getText().length < 1) {
            editText2.setError("Your Input is too short");
            return false;
        } else {
            return true;
        }
    }


    fun on_button_click(view: View) {
        var joystick = findViewById<Joystick>(R.id.joystick)

        var editText: EditText = findViewById(R.id.editText)
        var editText2: EditText = findViewById(R.id.editText2)
        if (validateFields(editText,editText2)){
            ip = editText.text.toString()
            port = Integer.parseInt(editText2.text.toString())
            view_model.connect(ip, port)
            joystick.changeColor()
        }

    }
}
