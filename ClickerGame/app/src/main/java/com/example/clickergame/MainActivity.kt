package com.example.clickergame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //currentGold variable set to 0
    private var currentGold=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ImageView set as imgEnemy
        val imgEnemy: ImageView = findViewById(R.id.imgEnemy)
        val showGold: TextView= findViewById(R.id.currentGold)

        //increments gold in each click
        imgEnemy.setOnClickListener{
            currentGold ++
            showGold.text="$currentGold"
        }
    }
}