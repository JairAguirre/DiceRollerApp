package com.example.fullappkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.fullappkotlin.R.id
import com.example.fullappkotlin.R.layout
/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class DiceRoller : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_dice_roller)

        val rollButton: Button = findViewById(id.button2)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
/*
        rollButton.setOnClickListener {
            /*Muestran un toast
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()*/
            rollDice()

        }*/

    }
    fun changeDrawableR(diceRoll: Int): Int {

        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        val diceImage: ImageView = findViewById(R.id.diceRollerImageView)
        val diceImage2: ImageView = findViewById(R.id.diceRollerImageView2)

        diceImage.setImageResource(changeDrawableR(diceRoll))
        diceImage2.setImageResource(changeDrawableR(diceRoll2))
        //Añadir Descripción
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}