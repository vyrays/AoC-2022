package net.aoc.one

import net.aoc.lib.readInputFileLines

private fun getAggregatedCaloriesList(): List<Int> {
    val inputFileDirectory = System.getenv("inputFileDirectory") ?: return listOf()

    val lines = readInputFileLines(inputFileDirectory)
    var addedCalories = 0
    val calories = mutableListOf<Int>()
    for (line in lines) {
        if (line.isEmpty() && addedCalories > 0) {
            calories.add(addedCalories)
            addedCalories = 0
            continue
        }
        addedCalories += line.toInt()
    }
    calories.sortDescending()
    return calories
}

fun main() {
    val aggregatedCaloriesList = getAggregatedCaloriesList()

    println("The elf with the most calories carries ${getDayOneResult(aggregatedCaloriesList)} calories.")
    println("the calories total for the top 3 elves is ${getDayTwoResult(aggregatedCaloriesList)} calories.")
}