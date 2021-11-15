package com.example.clickergame

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    //variables are set here
    private var currentGold=0
    private var currentStage=1
    private var currentClickPower=1
    private var currentIdlePower=0
    private var currentPrestige=0

    private var clickUpgrade=25
    private var idleUpgrade=300
    private var prestigeUpgrade=5



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //values are set here
        val imgEnemy: ImageView = findViewById(R.id.imgEnemy)
        val showGold: TextView= findViewById(R.id.currentGold)
        val btnClickPower: Button=findViewById(R.id.upClick)
        val showClickPower: TextView=findViewById(R.id.currentClickPower)
        val showClickCost: TextView=findViewById(R.id.currentClickCost)
        val btnIdlePower: Button= findViewById(R.id.upIdle)
        val showIdlePower: TextView=findViewById(R.id.currentIdlePower)
        val showIdleCost: TextView=findViewById(R.id.currentIdleCost)
        val btnPrestige: Button= findViewById(R.id.upPrestige)
        val showPrestige: TextView =findViewById(R.id.currentPrestige)
        val showPrestigeCost: TextView=findViewById(R.id.currentPrestigeCost)
        val showStage:TextView=findViewById(R.id.currentStage)

        showStage.text="$currentStage"
        showClickCost.text="$clickUpgrade"
        showIdleCost.text="$idleUpgrade"
        showPrestigeCost.text="$prestigeUpgrade"


        //increments gold in each click
        imgEnemy.setOnClickListener{
            currentGold += currentClickPower
            showGold.text="$currentGold"

        }

        //upgrades click power
        btnClickPower.setOnClickListener{
            if (currentGold>=clickUpgrade) {
                currentGold -= clickUpgrade
                currentClickPower+=currentClickPower
                clickUpgrade+=clickUpgrade
                showClickPower.text = "$currentClickPower"
                showClickCost.text="$clickUpgrade"
                //always update current gold
                showGold.text="$currentGold"
            }
            else{
                Toast.makeText(this,"Need More Gold!", Toast.LENGTH_SHORT).show()
            }
        }

        //upgrades idle power
        btnIdlePower.setOnClickListener{
            if (currentGold>=idleUpgrade) {
                currentGold-=idleUpgrade
                currentIdlePower++
                idleUpgrade+=idleUpgrade
                showIdlePower.text = "$currentIdlePower"
                showIdleCost.text="$idleUpgrade"
                //always update current gold
                showGold.text = "$currentGold"

            }
            else{
                Toast.makeText(this,"Need More Gold!", Toast.LENGTH_SHORT).show()
            }
        }

        //upgrades Prestige
        btnPrestige.setOnClickListener{
            if (currentStage>=1) {
                currentStage=1
                currentGold=0
                currentClickPower=1
                currentIdlePower=0
                currentPrestige++
                clickUpgrade=25
                idleUpgrade=300
                prestigeUpgrade++
                showPrestige.text = "$currentPrestige"
                //update everything on screen
                showGold.text = "$currentGold"
                showIdlePower.text = "$currentIdlePower"
                showClickPower.text = "$currentClickPower"
                showClickCost.text="$clickUpgrade"
                showIdleCost.text="$idleUpgrade"
                showPrestigeCost.text="$prestigeUpgrade"
            }
            else{
                Toast.makeText(this,"Reach needed stage to Prestige!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}