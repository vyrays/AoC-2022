package net.aoc.eight

fun getPartTwoResult(trees: MutableMap<Pair<Int, Int>, Tree>): Int {
    return trees.map { it.value.viewDistance.values.reduce { acc, i -> acc * i } }.max()
}