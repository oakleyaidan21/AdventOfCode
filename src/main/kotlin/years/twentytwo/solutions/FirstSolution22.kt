package years.twentytwo.solutions

import Solution
import getLinesOfFile
import years.twentytwo.classes.Elf


class FirstSolution22: Solution<Int> {

    private var elves: List<Elf> = elvesFromFile("22/input1.txt")

    override fun solutions(): List<Int> {
        return listOf(part1(), part2())
    }

    override fun part1(): Int {
        var maxCalories = -1
        elves.forEach {
            val calories = it.totalCalories()
            if(calories > maxCalories) maxCalories = calories
        }
        return maxCalories
    }

    override fun part2(): Int {
        val sortedElves = elves.sortedBy { it.totalCalories() * -1 }
        val topElves = sortedElves.subList(0, 3)
        return topElves.foldRight(0) { item, total -> total + item.totalCalories() }
    }

    private fun elvesFromFile(fileName: String): List<Elf> {
        var elves = mutableListOf<Elf>()
        var currentElfFood = mutableListOf<Int>()
        getLinesOfFile(fileName)?.forEach {
            if(it.trim().isEmpty()) {
                elves.add(Elf(currentElfFood))
                currentElfFood = mutableListOf()
            } else {
                currentElfFood.add(Integer.parseInt(it))
            }
        }
        return elves
    }
}
