package net.aoc.five

class Two : Part {

    override fun moveCrates(crates: MutableList<MutableList<Char>>, amount: Int, fromStack: Int, toStack: Int) {
        val craneList = crates[fromStack].subList(crates[fromStack].count() - amount, crates[fromStack].count())
        crates[toStack].addAll(craneList)
        crates[fromStack].removeFromEnd(amount)
    }

}

fun MutableList<Char>.removeFromEnd(index: Int) {
    for (i in 1..index) {
        this.removeAt(this.lastIndex)
    }
}