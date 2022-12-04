package years.twentytwo.solutions

import Solution
import getLinesOfFile
import years.twentytwo.classes.ElfSection

class FourthSolution22 : Solution<Int> {

    private val inputPath = "22/input4.txt"

    override fun solutions(): List<Int> {
        return listOf(part1(), part2())
    }

    override fun part1(): Int {
        var count = 0
        getLinesOfFile(inputPath)?.forEach {
            val elfSections = it.split(",")
            val r1 = ElfSection(elfSections[0])
            val r2 = ElfSection(elfSections[1])
            if(r1.envelops(r2) || r2.envelops(r1)) count += 1
        }
        return count
    }

    override fun part2(): Int {
        var count = 0
        getLinesOfFile(inputPath)?.forEach {
            val elfSections = it.split(",")
            val r1 = ElfSection(elfSections[0])
            val r2 = ElfSection(elfSections[1])
            if(r1.overlaps(r2) || r2.overlaps(r1)) count += 1
        }
        return count
    }

}