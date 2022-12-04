package years.twentyone.solutions

import Solution
import getLinesOfFile

class FirstSolution21 : Solution<Int> {

    override fun solutions(): List<Int> {
        return listOf(part1())
    }

    override fun part1(): Int {
        var prevLine = 0
        var count = -1
        getLinesOfFile("21/input1.txt")?.forEach {
            if(Integer.parseInt(it) > prevLine) {
                count += 1
            }
            prevLine = Integer.parseInt(it)
        }
        return count
    }

    override fun part2(): Int {
        return 0
    }


}