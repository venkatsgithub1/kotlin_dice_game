package com.ven.games

import kotlin.random.Random

class DiceSimulation {
    private val tries: Int = 6
    private var triesUsed: Int = 0
    private val expectation = Random.nextInt(1, 7).toString()
    fun rollDice(): String {
        triesUsed++
        val ans: String = Random.nextInt(1, 7).toString()
        if (ans == expectation) {
            val ret = "${Constants.WON_IN} $triesUsed ${Constants.TRIES}"
            resetTries()
            return ret
        }
        if (triesUsed >= tries) {
            resetTries()
            return Constants.TRIES_EXCEEDED
        }
        return "${Constants.GOT} $ans"
    }

    fun resetTries() {
        triesUsed = 0
    }
}