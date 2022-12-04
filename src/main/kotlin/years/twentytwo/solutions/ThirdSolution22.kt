package years.twentytwo.solutions

import Solution
import getInputFilePath
import java.io.File
import java.nio.charset.Charset

class ThirdSolution22: Solution<Int> {

    private val inputPath = getInputFilePath("22/input3.txt") ?: ""

    override fun solutions(): List<Int> {
        return listOf(part1(), part2())
    }

    override fun part1(): Int {
        var sum = 0
        File(inputPath).forEachLine {
            val compartments = it.chunked((it.length + 1) / 2)
            val charMap = createCharMap()
            compartments[0].forEach {
                charMap[it.getMapIndex()] = 1
            }
            var found = false
            compartments[1].forEach {
                if(charMap[it.getMapIndex()] == 1) {
                    if(!found) sum += it.getPriority()
                    found = true
                }
            }
        }
        return sum
    }

    override fun part2(): Int {
        val allRucksacks = String(File(inputPath).readBytes(), Charset.defaultCharset()).split("\n")
        val groups = allRucksacks.chunked(3)
        var sum = 0
        groups.forEach { it ->
            val charMap = createCharMap()
            it.forEach { it ->
                val foundCharMap = createCharMap()
                it.forEach {
                    if(foundCharMap[it.getMapIndex()] == 0) {
                        charMap[it.getMapIndex()] += 1
                        if(charMap[it.getMapIndex()] == 3) sum += it.getPriority()
                    }
                    foundCharMap[it.getMapIndex()] = 1
                }
            }
        }
        return sum
    }

    private fun createCharMap(): ArrayList<Int> {
        var list = arrayListOf<Int>()
        for (i in 0..26*2) {
            list.add(0)
        }
        return list
    }

    private fun Char.getPriority() : Int {
        val isUppercase = this.isUpperCase()
        return if(isUppercase) this.code - 38 else this.code - 96
    }

    private fun Char.getMapIndex() : Int {
        return this.getPriority() - 1
    }
}