package net.aoc.eight

import net.aoc.lib.readInputFileLines

enum class Direction {
    UP, RIGHT, DOWN, LEFT
}

class Tree(private val size: Char) {
    var visible: Boolean = false
    var viewDistance: MutableMap<Direction, Int> = mutableMapOf()
    var topTree: Tree? = null
    var rightTree: Tree? = null
    var bottomTree: Tree? = null
    var leftTree: Tree? = null

    fun lookAround(initialTree: Tree, direction: Direction): Boolean {
        val neighborTree = when (direction) {
            Direction.UP -> topTree
            Direction.RIGHT -> rightTree
            Direction.DOWN -> bottomTree
            Direction.LEFT -> leftTree
        }

        if (initialTree.viewDistance[direction] == null) {
            initialTree.viewDistance[direction] = 0
        }

        if (neighborTree != null) {
            // Increase the view distance if there is a neighbor tree.
            initialTree.viewDistance[direction] = initialTree.viewDistance[direction]!! + 1
            if (neighborTree.size >= initialTree.size) {
                return false
            }
            if (!neighborTree.lookAround(initialTree, direction)) {
                return false
            }
            initialTree.visible = true
        } else {
            visible = true
        }
        return true
    }
}

private fun buildTreeMatrix(inputLines: List<String>): MutableMap<Pair<Int, Int>, Tree> {
    val trees = mutableMapOf<Pair<Int, Int>, Tree>()
    val lines = inputLines.size - 1
    for (i in 0..lines) {
        val digits = inputLines[i].length - 1
        for (j in 0..digits) {
            val tree = Tree(inputLines[i][j])

            var topTree: Tree?
            if (trees.containsKey(Pair(i - 1, j))) {
                topTree = trees[Pair(i - 1, j)]!!
                tree.topTree = topTree
                topTree.bottomTree = tree
            }

            var leftTree: Tree?
            if (trees.containsKey(Pair(i, j - 1))) {
                leftTree = trees[Pair(i, j - 1)]!!
                tree.leftTree = leftTree
                leftTree.rightTree = tree
            }

            trees[Pair(i, j)] = tree
        }
    }
    return trees
}

fun main() {
    val inputLines = readInputFileLines(System.getenv("inputFileDirectory"))
    val trees = buildTreeMatrix(inputLines)
    println("There are ${getPartOneResult(trees)} visible trees in the forest from each angle.")
    println("The maximum view distance of any tree would be ${getPartTwoResult(trees)} trees.")
}