package net.aoc.five

import java.io.File

interface Part {

    fun moveCrates(crates: MutableList<MutableList<Char>>, amount: Int, fromStack: Int, toStack: Int)

}

fun main() {
    val inputFileDirectory: String = System.getenv("inputFileDirectory")


    // Print the last crates of each stack of part one.
    for (crate in moveCrates(File(inputFileDirectory), One())) {
        print(crate.last())
    }

    println()

    moveCrates(File(inputFileDirectory), Two())
    // Print the last crates of each stack of part two.
    for (crate in moveCrates(File(inputFileDirectory), Two())) {
        print(crate.last())
    }
}

fun moveCrates(file: File, day: Part): MutableList<MutableList<Char>> {
    val crates: MutableList<MutableList<Char>> = mutableListOf(mutableListOf())
    var switchRecording = false
    file.bufferedReader().forEachLine {
        if (it.isEmpty()) {
            switchRecording = true
            for (crate in crates) {
                crate.reverse()
            }
        }

        if (!switchRecording) {
            if (it.any { it.isDigit() }) {
                return@forEachLine
            }

            for ((index, chunk) in it.chunked(4).withIndex()) {
                if (crates.getOrNull(index) == null) {
                    crates.add(mutableListOf())
                }

                if (chunk.isNotBlank()) {
                    crates[index].add(chunk[1])
                }
            }
        } else if (it.startsWith("move")) {
            val matches = Regex("(\\d+)").findAll(it).toList().map { it.value.toInt() }
            if (matches.count() < 3) return@forEachLine

            day.moveCrates(crates, matches[0], matches[1] - 1, matches[2] - 1)
        }
    }

    return crates
}