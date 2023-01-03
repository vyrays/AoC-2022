package net.aoc.six

import net.aoc.lib.readInputFileLines

interface Part {

    val characters: Int

}

fun main() {
    val lineInput = readInputFileLines(System.getenv("inputFileDirectory"))[0]

    println("${processCharacters(lineInput, One())} characters need to be processed to detect the start-of-packet marker.")
    println("${processCharacters(lineInput, Two())} characters need to be processed to detect the start-of-message marker.")
}

fun processCharacters(line: String, part: Part): Int {
    for ((index, window) in line.windowed(part.characters).withIndex()) {
        val letters = window.toSet()
        if (letters.count() == part.characters) {
            return index + letters.count()
        }
    }

    return 0
}