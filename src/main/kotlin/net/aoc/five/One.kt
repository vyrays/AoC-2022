package net.aoc.five

class One : Part {

    override fun moveCrates(crates: MutableList<MutableList<Char>>, amount: Int, fromStack: Int, toStack: Int) {
        for (_amount in 1..amount) {
            crates[toStack].add(crates[fromStack].last())
            crates[fromStack].removeAt(crates[fromStack].lastIndex)
        }
    }

}