package net.aoc.four

fun getPartOneResult(idRangeList: List<List<IdRange>>): Int {
    var fullyContainedCounter = 0
    for (idRange in idRangeList) {
        if (idRange[0] in idRange[1] || idRange[1] in idRange[0]) {
            fullyContainedCounter++
        }
    }
    return fullyContainedCounter
}