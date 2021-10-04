package com.example.android.minipaint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.core.content.res.ResourcesCompat
import com.example.minipaint.R
import kotlin.math.abs

class Drawing(context: Context) : View(context) {
    // holds the path
    private var path = Path()

    //getting from colors.xml
    private val draw_color = ResourcesCompat.getColor(resources, R.color.colorPaint, null)
    private val bgColor = ResourcesCompat.getColor(resources, R.color.colorBackground, null)

    //caching what was drawn
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap

    // setting up paint color,style,width stuff
    private val paint = Paint().apply {
        color = draw_color
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    //I used scaledTouchSlop to not draw every pixel, like a touch tolerance
    private val tolerance = ViewConfiguration.get(context).scaledTouchSlop

    //current X and Y, also touch X and Y are here
    private var cX = 0f
    private var cY = 0f
    private var touchX = 0f
    private var touchY = 0f

    //got this part mostly from developers.com
    override fun onSizeChanged(width: Int, height: Int, oWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oWidth, oldHeight)

        //creating new bitmap as canvas
        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(bgColor)  //bg color
    }

    //overrides the first map and adds drawn stuff by bitmap
    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(extraBitmap, 0f, 0f, null)
    }

    //boolean, got from developers.com
    override fun onTouchEvent(event: MotionEvent): Boolean {
        touchX = event.x
        touchY = event.y
        //looks to our finger movements
        when (event.action) {
            MotionEvent.ACTION_DOWN -> tStart()
            MotionEvent.ACTION_MOVE -> tMove()
            MotionEvent.ACTION_UP -> tUp()
        }
        return true
    }

    //start drawing
    private fun tStart() {
        path.reset()
        path.moveTo(touchX, touchY)
        cX = touchX
        cY = touchY
    }

    //moving the fingers or touch move
    //calculates the oath between current x and touch x
    private fun tMove() {
        val dx = abs(touchX - cX)
        val dy = abs(touchY - cY)
        if (dx >= tolerance || dy >= tolerance) {
            path.quadTo(cX, cY, (touchX + cX) / 2, (touchY + cY) / 2)
            cX = touchX
            cY = touchY
            // drawn in extra map so we can save
            extraCanvas.drawPath(path, paint)
        }
        invalidate()
    }

    //resets location so we can draw elsewhere when we stop drawing
    private fun tUp() {
        path.reset()
    }
}