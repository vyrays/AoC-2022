package net.aoc.one

fun getDayTwoResult(aggregatedCalories: List<Int>): Int {
    return aggregatedCalories.subList(0, 3).reduce { acc, calories -> acc + calories }
}