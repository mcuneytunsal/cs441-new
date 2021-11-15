package com.example.clickergame

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.isInvisible
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    //variables are set here
    private var currentGold=0
    private var currentStage=1
    private var currentClickPower=1
    private var currentIdlePower=0
    private var currentPrestige=0

    private var clickUpgrade=10
    private var idleUpgrade=300
    private var prestigeUpgrade=3
    private var stageUpgrade=100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //values are set here
        val background: RelativeLayout=findViewById(R.id.activity_main)
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
        val btnStage:Button=findViewById(R.id.upStage)
        val showCurrentStageCost: TextView=findViewById(R.id.currentStageCost)
        val showCurrentStage: TextView=findViewById(R.id.currentStage)
        val btnResetGame: Button=findViewById(R.id.resetGame)

        val tmpGold: TextView=findViewById(R.id.tmpGold)
        val tmpGc1: TextView=findViewById(R.id.tmpGc1)
        val tmpGc2: TextView=findViewById(R.id.tmpGc2)
        val tmpGc3: TextView=findViewById(R.id.tmpGc3)
        val tmpStage: TextView=findViewById(R.id.tmpStage)
        val tmpNextStage: TextView=findViewById(R.id.tmpNextStage)
        val tmpGpc: TextView=findViewById(R.id.tmpGpc)
        val tmpGps: TextView=findViewById(R.id.tmpGps)
        val tmpLevel: TextView=findViewById(R.id.tmpLevel)


        val ending1: TextView=findViewById(R.id.endingTop)
        val ending2: TextView=findViewById(R.id.endingBot)
        ending1.visibility=View.GONE
        ending2.visibility=View.GONE
        btnResetGame.visibility=View.GONE

        showCurrentStage.text="$currentStage"
        showCurrentStageCost.text="$stageUpgrade"
        showClickCost.text="$clickUpgrade"
        showIdleCost.text="$idleUpgrade"
        showPrestigeCost.text="$prestigeUpgrade"
        imgEnemy.setImageResource(R.drawable.enemy1)

        //change background with this code
        background.setBackgroundResource(R.drawable.bg1)

        //increments gold in each click
        imgEnemy.setOnClickListener{
            currentGold += currentClickPower
            showGold.text="$currentGold"

        }

        btnResetGame.setOnClickListener{
            imgEnemy.setImageResource(R.drawable.enemy1)
            currentStage=1
            currentGold=0
            currentClickPower=1
            currentIdlePower=0
            clickUpgrade=10
            idleUpgrade=300
            stageUpgrade=100
            prestigeUpgrade=3
            currentPrestige=0

            showPrestige.text = "$currentPrestige"
            showPrestigeCost.text="$prestigeUpgrade"

            ending1.visibility=View.GONE
            ending2.visibility=View.GONE
            btnResetGame.visibility=View.GONE


            btnClickPower.visibility=View.VISIBLE
            btnIdlePower.visibility=View.VISIBLE
            btnPrestige.visibility=View.VISIBLE
            btnStage.visibility=View.VISIBLE
            showClickCost.visibility=View.VISIBLE
            showClickPower.visibility=View.VISIBLE
            showCurrentStage.visibility=View.VISIBLE
            showCurrentStage.visibility=View.VISIBLE
            showGold.visibility=View.VISIBLE
            showIdleCost.visibility=View.VISIBLE
            showCurrentStageCost.visibility=View.VISIBLE
            showIdlePower.visibility=View.VISIBLE
            showPrestige.visibility=View.VISIBLE
            showPrestigeCost.visibility=View.VISIBLE
            showCurrentStage.visibility=View.VISIBLE
            tmpGc1.visibility=View.VISIBLE
            tmpGc2.visibility=View.VISIBLE
            tmpGc3.visibility=View.VISIBLE
            tmpGold.visibility=View.VISIBLE
            tmpGpc.visibility=View.VISIBLE
            tmpGps.visibility=View.VISIBLE
            tmpLevel.visibility=View.VISIBLE
            tmpNextStage.visibility=View.VISIBLE
            tmpStage.visibility=View.VISIBLE

        }

        //upgrades click power
        btnClickPower.setOnClickListener{
            if (currentGold>=clickUpgrade) {
                currentGold -= clickUpgrade
                currentClickPower*=2
                clickUpgrade*=2
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
                idleUpgrade*=2
                showIdlePower.text = "$currentIdlePower"
                showIdleCost.text="$idleUpgrade"
                //always update current gold
                showGold.text = "$currentGold"

            }
            else{
                Toast.makeText(this,"Need More Gold!", Toast.LENGTH_SHORT).show()
            }
        }

        //upgrades Stage
        btnStage.setOnClickListener{
            if(currentGold>stageUpgrade) {
                if(currentStage==1){
                    background.setBackgroundResource(R.drawable.bg2)
                }
                if(currentStage==2){
                    background.setBackgroundResource(R.drawable.bg3)
                }
                if(currentStage==3){
                    background.setBackgroundResource(R.drawable.bg4)
                }
                if(currentStage==4){
                    background.setBackgroundResource(R.drawable.bg5)
                }
                if(currentStage==5){
                    background.setBackgroundResource(R.drawable.bg6)
                }
                if(currentStage==6){
                    background.setBackgroundResource(R.drawable.bg7)
                }
                currentStage++
                currentGold -= stageUpgrade
                stageUpgrade *= 10
                currentClickPower*=3
                clickUpgrade*=2
                showClickPower.text = "$currentClickPower"
                showCurrentStageCost.text = "$stageUpgrade"
                showGold.text = "$currentGold"
                showCurrentStage.text="$currentStage"
                showClickCost.text="$clickUpgrade"

            }
            else{
                Toast.makeText(this,"Need More Gold!", Toast.LENGTH_SHORT).show()
            }
        }

        //upgrades Prestige
        btnPrestige.setOnClickListener{
            if (currentStage>=prestigeUpgrade) {
                if (currentPrestige == 0){
                    imgEnemy.setImageResource(R.drawable.enemy2)
                }
                if (currentPrestige == 1){
                    imgEnemy.setImageResource(R.drawable.enemy3)
                }
                if (currentPrestige == 2){
                    imgEnemy.setImageResource(R.drawable.enemy4)
                }
                if (currentPrestige == 3){
                    imgEnemy.setImageResource(R.drawable.enemy5)
                }

                //game ending
                if (currentPrestige == 4){
                    imgEnemy.setImageResource(R.drawable.enemy6)
                    btnClickPower.visibility=View.GONE
                    btnIdlePower.visibility=View.GONE
                    btnPrestige.visibility=View.GONE
                    btnStage.visibility=View.GONE
                    showClickCost.visibility=View.GONE
                    showClickPower.visibility=View.GONE
                    showCurrentStage.visibility=View.GONE
                    showCurrentStage.visibility=View.GONE
                    showGold.visibility=View.GONE
                    showIdleCost.visibility=View.GONE
                    showCurrentStageCost.visibility=View.GONE
                    showIdlePower.visibility=View.GONE
                    showPrestige.visibility=View.GONE
                    showPrestigeCost.visibility=View.GONE
                    showCurrentStage.visibility=View.GONE
                    tmpGc1.visibility=View.GONE
                    tmpGc2.visibility=View.GONE
                    tmpGc3.visibility=View.GONE
                    tmpGold.visibility=View.GONE
                    tmpGpc.visibility=View.GONE
                    tmpGps.visibility=View.GONE
                    tmpLevel.visibility=View.GONE
                    tmpNextStage.visibility=View.GONE
                    tmpStage.visibility=View.GONE

                    ending1.visibility=View.VISIBLE
                    ending2.visibility=View.VISIBLE
                    btnResetGame.visibility=View.VISIBLE
                }

                //resets progression and leveling up
                background.setBackgroundResource(R.drawable.bg1)
                currentStage=1
                currentGold=0
                currentClickPower=1
                currentIdlePower=0
                currentPrestige++
                clickUpgrade=10
                idleUpgrade=300
                prestigeUpgrade++
                stageUpgrade=100
                //update everything on screen
                showGold.text = "$currentGold"
                showIdlePower.text = "$currentIdlePower"
                showClickPower.text = "$currentClickPower"
                showClickCost.text="$clickUpgrade"
                showIdleCost.text="$idleUpgrade"
                showPrestige.text = "$currentPrestige"
                showPrestigeCost.text="$prestigeUpgrade"
                showCurrentStage.text="$currentStage"
                showCurrentStageCost.text="$stageUpgrade"

            }
            else{
                Toast.makeText(this,"Reach needed stage to Prestige!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}