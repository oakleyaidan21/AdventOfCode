import years.twentytwo.solutions.FirstSolution22
import years.twentyone.solutions.FirstSolution21

fun main() {
    val allSolutions = mapOf(
        Pair("22", listOf(FirstSolution22(), SecondSolution22())),
        Pair("21", listOf(FirstSolution21()))
    )
    while(true) {
        print("Year: ")
        val year = readln()
        val selectedSolutions = allSolutions.getOrDefault(year, listOf())
        if(selectedSolutions.isEmpty()) {
            println("No matching year found.")
        } else {
            for (i in 1..selectedSolutions.size) {
                println("Problem $i")
            }
            println("Select a problem:")
            val problem = Integer.parseInt(readln())
            println("Solution: ${selectedSolutions[problem - 1].solve()}")
        }
    }
}
