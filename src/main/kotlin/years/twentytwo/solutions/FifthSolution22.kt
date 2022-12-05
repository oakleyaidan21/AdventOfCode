package years.twentytwo.solutions

import Solution
import getLinesOfFile
import years.twentytwo.classes.CrateMove
import years.twentytwo.classes.CrateStack

class FifthSolution22 : Solution<String> {

    private val inputPath = "22/input5.txt"

    override fun solutions(): List<String> {
        return listOf(part1(), part2())
    }

    override fun part1(): String {
        val lines = getLinesOfFile(inputPath) ?: listOf()
        val stacks = createStacksFromInput(lines)
        lines.subList(10, lines.size).forEach {
            val move = CrateMove(it)
            val fromStack = stacks[move.from - 1]
            val destStack = stacks[move.dest - 1]
            fromStack.moveCrates(move.amount, destStack)
        }
        var result = ""
        stacks.forEach { result += it.getTop() }
        return result
    }

    override fun part2(): String {
        val lines = getLinesOfFile(inputPath) ?: listOf()
        val stacks = createStacksFromInput(lines)
        lines.subList(10, lines.size).forEach {
            val move = CrateMove(it)
            val fromStack = stacks[move.from - 1]
            val destStack = stacks[move.dest - 1]
            fromStack.moveCrates9001(move.amount, destStack)
        }
        var result = ""
        stacks.forEach { result += it.getTop() }
        return result
    }
}

fun createStacksFromInput(lines: List<String>): List<CrateStack> {
    val stacks = mutableListOf<CrateStack>()
    for(i in 0 until 9) stacks.add(CrateStack())
    for(i in 0 until 9) {
        val letters = lines[9 - i - 1].chunked(4)
        letters.forEachIndexed { index, item ->
            if(item.contains("[")) stacks[index].addCrate(item[1])
        }
    }
    return stacks
}