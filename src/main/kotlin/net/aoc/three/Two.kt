package net.aoc.three

private fun findMatchingCharacter(rucksack: String, rucksacks: List<String>): Char? {
    var matchingCharacter: Char? = null
    outer@for (letter in rucksack) {
        inner@for (_rucksack in rucksacks) {
            if (_rucksack.any { c: Char -> c == letter }) {
                if (matchingCharacter != null) {
                    return letter
                }

                matchingCharacter = letter
                continue@inner
            } else {
                // If the character is not in the following rucksack, reset it and start from scratch.
                if (matchingCharacter != null) {
                    matchingCharacter = null
                }
                continue@outer
            }
        }
    }

    return matchingCharacter
}

fun getPartTwoResults(lines: List<String>): Int {
    val groupOfThree = lines.chunked(3)
    return groupOfThree.map {
        val firstLine = it.first()
        findMatchingCharacter(firstLine, it.subList(1, it.size))?.let { c: Char -> getPriority(c) }
    }.sumOf { it ?: 0 }
}
