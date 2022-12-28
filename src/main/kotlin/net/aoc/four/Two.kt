package net.aoc.four

fun getPartTwoResult(idRangeList: List<List<IdRange>>): Int {
    var partiallyContainedCounter = 0
    for (idRange in idRangeList) {
        if (idRange[0] has idRange[1] || idRange[1] has idRange[0]) {
            partiallyContainedCounter++
        }
    }
    return partiallyContainedCounter
}