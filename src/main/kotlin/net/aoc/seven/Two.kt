package net.aoc.seven

val totalDiskSpace = 70000000
val requiredSpace = 30000000

fun evaluateSmallestFolderToDelete(folders: MutableList<Folder>): Int {
    val folderSizes = getFolderSizes(folders.first(), folders.first().name).toMap()
    val freeSpace = totalDiskSpace - folderSizes.firstNotNullOf { it.value }
    return folderSizes.filter { it.value >= (requiredSpace - freeSpace) }.minBy { it.value }.value
}