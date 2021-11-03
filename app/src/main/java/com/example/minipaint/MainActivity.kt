package com.example.minipaint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        create instance
        val myCanvasView = MyCanvasView(this)

//        request full screen for layout of myCanvasView
        myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN

//        add content description
        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)

//        set content view to myCanvasView
        setContentView(myCanvasView)
    }
}