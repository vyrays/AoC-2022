package net.aoc.seven

import net.aoc.lib.readInputFileLines


class Folder(
    val name: String,
    var parent: Folder?,
    val folders: MutableList<Folder> = mutableListOf(),
    val files: MutableList<File> = mutableListOf()
) {

    fun has(name: String): Boolean {
        return this.folders.any { it.name == name }
    }

    fun assign(folder: Folder) {
        folder.parent = this
        this.folders.add(folder)
    }

    fun assign(file: File) {
        file.assign(this)
        this.files.add(file)
    }

    fun select(name: String): Folder {
        return this.folders.single { it.name == name }
    }

    fun top(): Folder {
        if (this.parent == null) {
            return this
        }
        return this.parent!!.top()
    }

}

class File(val size: Int, private var folder: Folder) {

    fun assign(folder: Folder) {
        this.folder = folder
    }

}

fun getFolderSizes(folder: Folder, name: String): MutableMap<String, Int> {
    val fileSum = folder.files.sumOf { it.size }
    val map = mutableMapOf(name to fileSum)
    if (folder.folders.isEmpty()) {
        return map
    }

    for (_folder in folder.folders) {
        val childMap = getFolderSizes(_folder,"${name}:${_folder.name}")
        for ((folderName, size) in childMap) {
            map[folderName] = size
            if (folderName == "${name}:${_folder.name}") {
                map[name] = map[name]!! + size
            }
        }
    }

    return map
}

fun main() {
    val inputLines = readInputFileLines(System.getenv("inputFileDirectory"))
    val folders = mutableListOf<Folder>()
    println("The solution of part one is: ${sumOfFolders(inputLines, folders)}")
    println("The solution of part two is: ${evaluateSmallestFolderToDelete(folders)}")
}