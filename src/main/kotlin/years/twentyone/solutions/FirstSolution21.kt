package years.twentyone.solutions

import Solution
import getInputFilePath
import java.io.File

class FirstSolution21 : Solution<List<Int>> {

    override fun solve(): List<Int> {
        return listOf(part1())
    }

    private fun part1(): Int {
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


}