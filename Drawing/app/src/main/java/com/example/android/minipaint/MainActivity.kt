package com.example.android.minipaint
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import com.example.minipaint.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //creating new drawing object
        val newDrawing = Drawing(this)

        //makes fullscreen
        newDrawing.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN

        //description
        newDrawing.contentDescription = getString(R.string.drawingDescription)

        //content view is drawing object
        setContentView(newDrawing)
    }
}
