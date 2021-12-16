package com.example.fullappkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
        rollButton.setOnClickListener {
            /*Muestran un toast
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()*/
            rollDice()

        }
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        val resultTextView: TextView = findViewById(id.dicerollertextview)
        val resultTextView2: TextView = findViewById(id.diceroller2textview)
        resultTextView.text = diceRoll.toString()
        resultTextView2.text = diceRoll2.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}