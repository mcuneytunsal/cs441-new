package com.example.weather2


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val CITY: String = "istanbul,tr"
    val API: String = "c76860c21cacc1b856fe3519b6835ce8" // Use API key

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}