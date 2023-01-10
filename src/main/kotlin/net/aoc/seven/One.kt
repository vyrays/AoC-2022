package net.aoc.seven

fun sumOfFolders(inputLines: List<String>, folders: MutableList<Folder>): Int {
    var folder = Folder("/", null)
    folders.add(folder)
    for (line in inputLines) {
        val parts = line.split(' ')
        when (parts[0]) {
            "$" -> when (parts[1]) {
                "cd" -> when (parts[2]) {
                    ".." -> if (folder.parent != null) {
                        folder = folder.parent!!
                    }

                    else -> if (folder.has(parts[2])) {
                        folder = folder.select(parts[2])
                    }
                }

                "ls" -> continue
            }

            "dir" -> {
                with (Folder(parts[1], folder)) {
                    folder.assign(this)
                    folders.add(this)
                }
            }

            else -> {
                // This is definitely a file.
                folder.assign(File(parts[0].toInt(), folder))
            }
        }
    }

    return getFolderSizes(folder.top(), "/").filterValues { it in 0..100000 }.values.sum()
}