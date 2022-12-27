package net.aoc.three

import net.aoc.lib.readInputFileLines

fun getPriority(letter: Char): Int {
    var lowercaseLetter = 'a';
    for (priority in (1..27)) {
        if (letter == lowercaseLetter) {
            return priority
        }

        lowercaseLetter++
    }

    var uppercaseLetter = 'A'
    for (priority in (27 .. 53)) {
        if (letter == uppercaseLetter) {
            return priority
        }

        uppercaseLetter++
    }

    return 0
}

fun main() {
    val inputLines = readInputFileLines(System.getenv("inputFileDirectory"))
    println("The total priority of part one is: ${getPartOneResults(inputLines)}")
    println("The total priority of part two is: ${getPartTwoResults(inputLines)}")
}