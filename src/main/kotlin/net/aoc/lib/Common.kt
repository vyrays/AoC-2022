package net.aoc.lib

import java.io.File

fun readInputFileLines(inputFileResourcePath: String): List<String> {
    return File(inputFileResourcePath).readLines()
}