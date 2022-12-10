package years.twentytwo.solutions

import Solution
import getLinesOfFile

class SixthSolution22 : Solution<Int> {
    private val inputPath = "22/input6.txt"
    override fun solutions(): List<Int> {
        return listOf(part1(), part2())
    }
    override fun part1(): Int {
        val packet = getLinesOfFile(inputPath)?.get(0)
        return findStartOfMessageIndex(packet ?: "", 4)
    }

    override fun part2(): Int {
        val packet = getLinesOfFile(inputPath)?.get(0)
        return findStartOfMessageIndex(packet ?: "", 14)
    }

    private fun findStartOfMessageIndex(packet: String, soeLength: Int): Int {
        var charactersRead = soeLength - 1
        for(i in soeLength - 1..packet.length) {
            charactersRead++
            val set = mutableSetOf<Char>()
            for(j in 0 until soeLength) set.add(packet[i - j])
            if (set.size == soeLength) break
        }
        return charactersRead
    }
}