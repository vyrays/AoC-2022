package net.aoc.three

private fun calculatePriorities(lines: List<String>): Int {
    return lines.map { line ->
        val compartments = listOf(line.substring(0, (line.length / 2)), line.substring((line.length / 2), line.length))
        findMatchingCharacter(compartments[0], compartments[1])?.let { getPriority(it) }
    }.sumOf { it ?: 0 }
}

private fun findMatchingCharacter(firstString: String, secondString: String): Char? {
    var matchingCharacter: Char? = null
    for (letter in firstString) {
        if (secondString.any { c: Char -> c == letter }) {
            matchingCharacter = letter
            break
        }
    }

    return matchingCharacter
}

fun getPartOneResults(lines: List<String>): Int {
    return calculatePriorities(lines)
}
