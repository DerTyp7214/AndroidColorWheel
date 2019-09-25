package de.dertyp7214.colorwheel

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.graphics.get
import kotlin.math.roundToInt

class ColorWheel : FrameLayout {

    private var layout: ImageView? = null
    private lateinit var bitmap: Bitmap

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

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        setUp(context)
    }

    private fun setUp(context: Context) {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.color_wheel, this, true)

        layout = getChildAt(0) as ImageView
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.wheel)
        layout?.setImageBitmap(bitmap)
    }

    @SuppressLint("ClickableViewAccessibility")
    fun setTouchListener(listener: (color: Int) -> Unit) {
        layout?.setOnTouchListener { _, event ->
            val x = event.x.roundToInt()
            val y = event.y.roundToInt()
            val scaled = Bitmap.createScaledBitmap(bitmap, width, height, false)
            if (x >= 0 && y >= 0 && x < width && y < height) {
                val color = scaled[x, y]
                if (color != Color.TRANSPARENT) listener(color)
            }
            true
        }
    }
}