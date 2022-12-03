import years.twentytwo.classes.RPSEnum
import years.twentytwo.classes.RPSResultEnum
import years.twentytwo.classes.RPSResultEnum.*
import java.io.File

class SecondSolution: Solution<List<Int>> {

    private val inputPath = getInputFilePath("input2.txt") ?: ""

    override fun solve(): List<Int> {
       return listOf(part1(), part2())
    }

    private fun part1(): Int {
        var total = 0
        File(inputPath).forEachLine {
            val moves = it.split(" ")
            val theirMove = RPSEnum.valueOf(moves[0])
            val yourMove = RPSEnum.valueOf(moves[1])
            val gamePoints = yourMove.points + if(yourMove.move == theirMove.move) 0 else if(theirMove.name == yourMove.beats) 6 else 0
            total += gamePoints
        }
        return total
    }

    private fun part2(): Int {
        var total = 0
        File(inputPath).forEachLine {
            val moves = it.split(" ")
            val theirMove = RPSEnum.valueOf(moves[0])
            val outcome = RPSResultEnum.valueOf(moves[1])
            val moveScore = when(outcome) {
                X -> RPSEnum.valueOf(theirMove.beats).points
                Y -> theirMove.points
                Z -> RPSEnum.valueOf(theirMove.loses).points
            }
            total += outcome.points + moveScore
        }
        return total
    }

}
