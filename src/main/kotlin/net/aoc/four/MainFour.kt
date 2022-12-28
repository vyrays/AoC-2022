package net.aoc.four

import net.aoc.lib.readInputFileLines

data class IdRange(val ids: MutableList<Int>) {

    operator fun get(i: Int): Int {
        return this.ids[i]
    }

    fun add(i: Int) {
        this.ids.add(i)
    }

    operator fun contains(idRange: IdRange): Boolean {
        return idRange.ids.containsAll(this.ids)
    }

    operator fun plusAssign(i: Int) {
        this.ids.add(i)
    }

    infix fun has(idRange: IdRange): Boolean {
        return idRange.ids.any { it in this.ids }
    }

}

private fun generateRangeList(lines: List<String>): List<List<IdRange>> {
    val idRangeList = lines.map {
        val idRanges: List<IdRange> = it.split(",").map { it.split("-").map { it.toInt() }.toMutableList() }.map { IdRange(it) }
        for (range in idRanges) {
            for (i in range[0] .. range[1]) {
                if (i > range[0] && i < range[1]) {
                    range += i
                }
            }
            range.ids.sort()
        }
        return@map idRanges
    }
    return idRangeList
}

fun main() {
    val inputFileDirectory = System.getenv("inputFileDirectory") ?: ""
    val idRangeList = generateRangeList(readInputFileLines(inputFileDirectory))
    println("The sections of all elves fully overlap ${getPartOneResult(idRangeList)} times")
    println("The sections of all elves fully overlap ${getPartTwoResult(idRangeList)} times")
}