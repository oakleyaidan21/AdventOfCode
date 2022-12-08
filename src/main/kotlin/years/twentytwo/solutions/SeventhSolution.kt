package years.twentytwo.solutions

import Solution
import getLinesOfFile
import kotlin.math.abs


class SeventhSolution : Solution<Int> {
    val CAPACITY = 70000000
    val THRESHOLD = 100000
    val REQUIRED_SPACE = 30000000

    private val inputPath = "22/input7.txt"

    override fun solutions(): List<Int> {
        return listOf(part1(), part2())
    }

    override fun part1(): Int {
        val root = getLinesOfFile(inputPath)?.let { constructDirectoryTree(it) } ?: Directory("/")
        val count = AtomicInt(0)
        findUnderThresholdFiles(root, count)
        return count.value
    }

    override fun part2(): Int {
        val root = getLinesOfFile(inputPath)?.let { constructDirectoryTree(it) } ?: Directory("/")
        val rootSize = root.getSize()
        val spaceNeededToFree = abs(CAPACITY - REQUIRED_SPACE - rootSize)
        val smallest = AtomicInt(Int.MAX_VALUE)
        findSmallestToRemove(root, smallest, spaceNeededToFree)
        return smallest.value
    }

    private fun findSmallestToRemove(root: Directory, smallest: AtomicInt, spaceNeeded: Int) {
        val size = root.getSize()
        if(size < smallest.value && size >= spaceNeeded) smallest.set(size)
        root.subDirectories.forEach {findSmallestToRemove(it.value, smallest, spaceNeeded)}
    }

    private fun findUnderThresholdFiles(root: Directory, count: AtomicInt) {
        if(root.getSize() <= THRESHOLD) count.add(root.getSize())
        root.subDirectories.forEach { findUnderThresholdFiles(it.value, count )}
    }

    private fun constructDirectoryTree(commandList: List<String>): Directory {
        var current = Directory( "/")
        var root = current
        commandList.subList(1, commandList.size).forEach {
            val tokens = it.split(" ")
            when {
                tokens == listOf("$", "ls") -> {

                }
                tokens == listOf("$", "cd", "..") -> {
                    current = current.parent!!
                }
                tokens == listOf("cd") -> {
                    println("$it back to start")
                    current = root
                }
                tokens.contains("cd") -> {
                    current = current.subDirectories[tokens[2]]!!
                }
                tokens.first() == "dir" -> {
                    val child = Directory(tokens[1])
                    child.parent = current
                    current.addDirectory(child)
                }
                else -> { // a file
                    val file = File(tokens[1], Integer.parseInt(tokens[0]))
                    current.addFile(file)
                }
            }
        }
        return root
    }
}

class Directory(val name: String) {
    var parent: Directory? = null
    var subDirectories = mutableMapOf<String, Directory>()
    private var files = mutableMapOf<String, Int>()
    fun addDirectory(d: Directory) {
        subDirectories[d.name] = d
    }
    fun addFile(f: File) {
        files[f.name] = f.size
    }
    fun getSize() : Int {
        return files.toList().foldRight(0) { item, total -> total + item.second } + subDirectories.toList().foldRight(0) { item, total -> total + item.second.getSize() }
    }

    override fun toString(): String {
        return "$name ${files.toList()} ${getSize()}"
    }
}

data class File(val name: String, val size: Int)

class AtomicInt(var value: Int = 0) {
    fun add(i: Int) {
        value += i
    }
    fun set(i: Int) {
        value = i
    }
}