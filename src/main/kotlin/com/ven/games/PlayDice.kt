package com.ven.games

fun main() {
    playGame()
}

private fun playGame() {
    gameInstructions()
    val diceSimulation = DiceSimulation()
    var ans: String
    var validInstructions = setOf(Constants.ZERO, Constants.ONE, Constants.TWO)
    while (true) {
        val prompt = readLine()
        if (!validInstructions.contains(prompt)) {
            println(Constants.INVALID_CHOICE)
            println(Constants.SEPARATOR)
            continue
        }
        when (prompt) {
            Constants.ONE -> {
                diceSimulation.resetTries()
                println(Constants.STARTING_GAME_AGAIN)
                println(Constants.SEPARATOR)
                validInstructions = setOf(Constants.ZERO, Constants.ONE, Constants.TWO)
                gameInstructions()
            }
            Constants.TWO -> {
                ans = diceSimulation.rollDice()
                println(ans)

                if (ans.contains(Constants.WON_IN) || ans == Constants.TRIES_EXCEEDED) {
                    println(Constants.PLAY_AGAIN)
                    println(Constants.SEPARATOR)
                    validInstructions = setOf(Constants.ZERO, Constants.ONE)
                    gameInstructions(false)
                }
            }
            Constants.ZERO -> {
                println(Constants.EXIT_GAME)
                break
            }
        }
    }
}

fun gameInstructions(showRollAgain: Boolean = true) {
    println(Constants.COMMON_INSTRUCTIONS)
    if (showRollAgain) {
        println(Constants.ROLL_AGAIN_INSTRUCTION)
    }
    println(Constants.SEPARATOR)
}