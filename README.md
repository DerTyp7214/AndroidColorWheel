# AndroidColorWheel

[![](https://jitpack.io/v/DerTyp7214/AndroidColorWheel.svg)](https://jitpack.io/#DerTyp7214/AndroidColorWheel)

## installation

`build.gradle` (project)
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

`build.gradle` (app)
```gradle
dependencies {
        implementation 'com.github.DerTyp7214:AndroidColorWheel:<version>'
}
```

## usage

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
