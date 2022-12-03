package years.twentytwo.solutions

import Solution
import getInputFilePath
import years.twentytwo.classes.Elf
import java.io.File


class FirstSolution: Solution<List<Int>> {

    private var elves: List<Elf> = elvesFromFile(getInputFilePath("input1.txt") ?: "")

    override fun solve(): List<Int> {
        return listOf(part1(), part2())
    }

    private fun part1(): Int {
        var maxCalories = -1
        elves.forEach {
            val calories = it.totalCalories()
            if(calories > maxCalories) maxCalories = calories
        }
        return maxCalories
    }

    private fun part2(): Int {
        val sortedElves = elves.sortedBy { it.totalCalories() * -1 }
        val topElves = sortedElves.subList(0, 3)
        return topElves.foldRight(0) { item, total -> total + item.totalCalories() }
    }

    private fun elvesFromFile(fileName: String): List<Elf> {
        var elves = mutableListOf<Elf>()
        var currentElfFood = mutableListOf<Int>()
        File(fileName).forEachLine {
            if(it.trim().isEmpty()) {
                elves.add(Elf(currentElfFood))
                currentElfFood = mutableListOf<Int>()
            } else {
                currentElfFood.add(Integer.parseInt(it))
            }
        }
        return elves
    }
}
