package de.dertyp7214.colorwheel

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.SeekBar

class ContrastSlider : androidx.appcompat.widget.AppCompatSeekBar {
    constructor(context: Context) : super(context) {
        setUp(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setUp(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setUp(context)
    }

    private var color = Color.BLACK

    private fun setUp(context: Context) {
        max = 100
    }

    fun setColor(color: Int) {
        this.color = color
        val hsv = floatArrayOf(0f, 0f, 0f)
        Color.colorToHSV(color, hsv)
        progress = (hsv[2] * 100).toInt()
    }

    fun setOnSlideListener(listener: (color: Int, raw: Int) -> Unit) {
        setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val hsv = floatArrayOf(0f, 0f, 0f)
                Color.colorToHSV(color, hsv)
                hsv[2] = progress.toFloat() / 100F
                listener(Color.HSVToColor(hsv), progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}