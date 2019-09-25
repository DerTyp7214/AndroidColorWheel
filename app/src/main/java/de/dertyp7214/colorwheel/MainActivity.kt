package de.dertyp7214.colorwheel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorWheel.setTouchListener {
            window.statusBarColor = it
            slider.setColor(it)
        }
        slider.setOnSlideListener { color, raw ->
            window.statusBarColor = color
            textView.text = raw.toString()
        }
    }
}
