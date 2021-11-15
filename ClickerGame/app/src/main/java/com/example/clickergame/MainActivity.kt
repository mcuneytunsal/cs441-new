package com.example.clickergame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ImageView and TextView's are as values or variables here
        val imgEnemy: ImageView = findViewById(R.id.imgEnemy)
        var currentGold: TextView = findViewById(R.id.currentGold)

        //toasts "Clicked" to check if the method is working, will change this method later
        imgEnemy.setOnClickListener{
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
        }
    }
}