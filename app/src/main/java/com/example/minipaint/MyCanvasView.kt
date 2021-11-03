package com.example.minipaint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import androidx.core.content.res.ResourcesCompat

class MyCanvasView (context: Context) : View(context) {

//    define member variables for canvas
    private lateinit var extraCanvas: Canvas

//    define member variable for bitmap
    private lateinit var extraBitmap: Bitmap

//    define class level variable for background color of the canvas
    private val backgroundColor = ResourcesCompat.getColor(resources, R.color.colorBackground, null)

    //    this callback method is called by Android system with the changed screen dimensions,
//    with new width and height (to change to) and old width and height (to change from)
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

//        instance with new w and h
        extraBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)

//        create Canvas instance
        extraCanvas = Canvas(extraBitmap)

//        specify background color in which to fill extraCanvas
        extraCanvas.drawColor(backgroundColor)

//        new bitmap and canvas are created every time function executes. We need a
//        new bitmap because size has changed. However, this is a memory leak because
//        we leave old bitmaps. To fix this recycle extraBitmap before creating the new one
        if (::extraBitmap.isInitialized) extraBitmap.recycle()

//        draw contents of the cached extraBitmap on the canvas associated with the view.


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(extraBitmap, 0f,0f, null)
    }
}