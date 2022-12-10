package years.twentytwo.solutions

import Solution
import getLinesOfFile
import kotlin.math.abs

class EighthSolution22 : Solution<Int> {

    private val inputPath = "22/input8.txt"

    override fun solutions(): List<Int> {
        return listOf(part1(), part2())
    }

    override fun part1(): Int {
        val grid = getGridFromFile()
        var visibleTreeCount = 0
        grid.forEachIndexed { indexR, row ->
            row.forEachIndexed { indexC, _ ->
                visibleTreeCount += if(treeVisible(indexR, indexC, grid)) 1 else 0
            }
        }
        return visibleTreeCount
    }

    override fun part2(): Int {
        val grid = getGridFromFile()
        var highestScore = Integer.MIN_VALUE
        grid.forEachIndexed { indexR, row ->
            row.forEachIndexed { indexC, _ ->
                if(!(indexR == 0 || indexR == grid.size - 1 || indexC == 0 || indexC == row.size - 1)) {
                } else {
                    val score = getVisibilityScore(indexR, indexC, grid)
                    if(score > highestScore) highestScore = score
                }

            }
        }
        return highestScore
    }

    private fun treeVisible(r: Int, c: Int, grid: Array<Array<Int>>): Boolean {
        return visibleDown(r, c, grid).visible || visibleUp(r, c, grid).visible ||  visibleLeft(r, c, grid).visible || visibleRight(r, c, grid).visible
    }

    private fun getVisibilityScore(r: Int, c: Int, grid: Array<Array<Int>>) =
        visibleDown(r, c, grid).score * visibleUp(r, c, grid).score * visibleLeft(r, c, grid).score * visibleRight(r, c, grid).score


    private fun visibleLeft(r: Int, c: Int, grid: Array<Array<Int>>) : Visibility {
        val point = grid[r][c]
        for(i in 1 .. c) {
            if(grid[r][c - i] >= point) return Visibility(false, i)
        }
        return Visibility(true, c)
    }

    private fun visibleRight(r: Int, c: Int, grid: Array<Array<Int>>) : Visibility {
        val point = grid[r][c]
        for(i in 1 until grid.size - c) {
            if(grid[r][i + c] >= point) return Visibility(false, i)
        }
        return Visibility(true, grid.size - c)
    }

    private fun visibleUp(r: Int, c: Int, grid: Array<Array<Int>>) : Visibility {
        val point = grid[r][c]
        for(i in 1 .. r) {
            if(grid[r - i][c] >= point) return Visibility(false, i)
        }
        return Visibility(true, r)
    }

    private fun visibleDown(r: Int, c: Int, grid: Array<Array<Int>>) : Visibility {
        val point = grid[r][c]
        for(i in 1 until grid[0].size - r) {
            if(grid[i + r][c] >= point) return Visibility(false, i)
        }
        return Visibility(true, grid[0].size - r)
    }

    private fun getGridFromFile(): Array<Array<Int>> {
        val lines = getLinesOfFile(inputPath) ?: listOf()
        val grid = Array(lines.size) { Array(lines[0].length) { 0 } }
        lines.forEachIndexed { i, iti ->
            iti.forEachIndexed { j, itj ->
                grid[i][j] = itj.digitToInt()
            }
        }
        return grid
    }
}

data class Visibility(val visible: Boolean, val score: Int)