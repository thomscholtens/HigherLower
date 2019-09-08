package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    private fun initViews() {
        btnHigher.setOnClickListener {
            onHigherClick() }
        btnLower.setOnClickListener {
            onLowerClick() }
        btnEqual.setOnClickListener {
            onEqualClick() }
        updateUI()
    }

    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)
        when (currentThrow) {
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) onAnswerCorrect() else onAnswerIncorrect()
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow > lastThrow) onAnswerIncorrect() else onAnswerCorrect()
    }

    private fun onEqualClick() {
        if (currentThrow == lastThrow) onAnswerCorrect() else onAnswerIncorrect()
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }
}







