package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tossButton: Button = findViewById(R.id.button2)
        tossButton.setOnClickListener { clickbutton() }
    }

    private fun clickbutton() {
        val firstDice = Dice(6)
        val roll1 = firstDice.roll()
        val diceImage1: ImageView = findViewById(R.id.diceImage1)
        when (roll1) {
            1 -> diceImage1.setImageResource(R.drawable.dice1)
            2 -> diceImage1.setImageResource(R.drawable.dice2)
            3 -> diceImage1.setImageResource(R.drawable.dice3)
            4 -> diceImage1.setImageResource(R.drawable.dice4)
            5 -> diceImage1.setImageResource(R.drawable.dice5)
            6 -> diceImage1.setImageResource(R.drawable.dice6)
        }

        val secondDice = Dice(6)
        val roll2 = secondDice.roll()
        val diceImage2: ImageView = findViewById(R.id.diceImage2)
        when (roll2) {
            1 -> diceImage2.setImageResource(R.drawable.dice1)
            2 -> diceImage2.setImageResource(R.drawable.dice2)
            3 -> diceImage2.setImageResource(R.drawable.dice3)
            4 -> diceImage2.setImageResource(R.drawable.dice4)
            5 -> diceImage2.setImageResource(R.drawable.dice5)
            6 -> diceImage2.setImageResource(R.drawable.dice6)
        }


        val coin = Coin()
        val toss = coin.toss()
        val diceImage3: ImageView = findViewById(R.id.coinImage)
        when(toss){
            "Heads" -> diceImage3.setImageResource(R.drawable.coin1)
            "Tails" -> diceImage3.setImageResource(R.drawable.coin2)
        }
    }
}


class Coin {
    fun toss(): String {
        val x = (1..2).random()
        return if(x==1) "Heads"
        else "Tails"
    }
}



class Dice (private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}