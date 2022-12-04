package years.twentyone.solutions

import Solution
import getInputFilePath
import java.io.File

class FirstSolution21 : Solution<Int> {

    override fun solutions(): List<Int> {
        return listOf(part1())
    }

    override fun part1(): Int {
        var prevLine = 0
        var count = -1
        File(getInputFilePath("21/input1.txt")).forEachLine {
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