package net.aoc.two

import net.aoc.lib.readInputFileLines

interface Day {

    var action: Action
    var response: Response

    fun getDayAction(): Action {
        return action
    }

    fun setDayAction(action: String): Day {
        this.action = when (action) {
            "A" -> Action.ROCK
            "B" -> Action.PAPER
            "C" -> Action.SCISSORS
            else -> Action.ROCK
        }
        return this
    }

    fun getDayResponse(): Response {
        return response
    }

    fun setDayResponse(response: String): Day

}

enum class Action(actionName: String) {
    ROCK("A"),
    PAPER("B"),
    SCISSORS("C");
}

enum class Response(response: String) {
    ROCK("X"),
    PAPER("Y"),
    SCISSORS("Z");
}

fun calculateScore(action: Action, response: Response): Int {
    // Set the winning, draw or losing scores.
    var score: Int = when (response) {
        Response.ROCK -> if (action == Action.SCISSORS) 6 else if (action == Action.ROCK) 3 else 0
        Response.PAPER -> if (action == Action.ROCK) 6 else if (action == Action.PAPER) 3 else 0
        Response.SCISSORS -> if (action == Action.PAPER) 6 else if (action == Action.SCISSORS) 3 else 0
    }

    // Add the response scores afterwards.
    score += when (response) {
        Response.ROCK -> 1
        Response.PAPER -> 2
        Response.SCISSORS -> 3
    }

    return score
}

fun unzipLines(lines: List<String>, day: Day): List<Int> {
    val scores = mutableListOf<Int>()
    for (line in lines) {
        val actionResponse = line.split(" ");
        if (actionResponse.count() != 2) {
            continue
        }

        val action = day.setDayAction(actionResponse[0]).getDayAction()
        val response = day.setDayResponse(actionResponse[1]).getDayResponse()

        scores.add(calculateScore(action, response))
    }
    return scores
}

fun getReducedLines(unzippedLines: List<Int>): Int {
    return unzippedLines.reduce { acc, score -> acc + score }
}

fun main() {
    val inputFileDirectory = System.getenv("inputFileDirectory") ?: ""
    var unzippedLines = unzipLines(readInputFileLines(inputFileDirectory), One())
    println("The guide's day-one-score is ${getReducedLines(unzippedLines)}.")
    unzippedLines = unzipLines(readInputFileLines(inputFileDirectory), Two())
    println("The guide's day-two-score is ${getReducedLines(unzippedLines)}.")
}