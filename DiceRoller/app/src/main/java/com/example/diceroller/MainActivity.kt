package com.example.diceroller

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<View>(R.id.Button)
        rollButton.setOnClickListener{ rollDice() }

    }
//Creando el obejto Dice con 6 lados y un giro
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll){
           1 -> R.drawable.dice_1
           2 -> R.drawable.dice_2
           3 -> R.drawable.dice_3
           4 -> R.drawable.dice_4
           5 -> R.drawable.dice_5
           else -> R.drawable.dice_6
    }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
}
class Dice(val numSides: Int){

    fun roll(): Int{

        return (1..numSides).random()
    }
}