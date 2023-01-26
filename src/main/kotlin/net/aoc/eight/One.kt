package net.aoc.eight

fun getPartOneResult(trees: MutableMap<Pair<Int, Int>, Tree>): Int {
    for (tree in trees.map { it.value }) {
        // If the tree is not visible yet, look into all directions and highlight as visible, if that is the tree is high enough.
        for (direction in Direction.values()) {
            tree.lookAround(tree, direction)
        }
    }

    return trees.filter { it.value.visible }.count()
}