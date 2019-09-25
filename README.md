# AndroidColorWheel

usage

```kotlin
colorWheel.setTouchListener {
    window.statusBarColor = it
    slider.setColor(it)
}
slider.setOnSlideListener { color, raw ->
    window.statusBarColor = color
    textView.text = raw.toString()
}
```

[example](https://github.com/DerTyp7214/AndroidColorWheel/blob/master/app/src/main/java/de/dertyp7214/colorwheel/MainActivity.kt)
