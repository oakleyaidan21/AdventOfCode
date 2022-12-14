import years.twentyone.solutions.FirstSolution21
import years.twentytwo.solutions.*

fun main() {
    val allSolutions = mapOf(
        Pair("22", listOf(
            FirstSolution22(),
            SecondSolution22(),
            ThirdSolution22(),
            FourthSolution22(),
            FifthSolution22(),
            SixthSolution22(),
            SeventhSolution22(),
            EighthSolution22()
        )),
        Pair("21", listOf(FirstSolution21()))
    )
    while(true) {
        print("Year (enter nothing for latest solution): ")
        val year = readln()
        if(year.isEmpty()) {
            println("Solution: ${allSolutions["22"]?.last()?.solutions()}")
            continue
        }
        val selectedSolutions = allSolutions.getOrDefault(year, listOf())
        if(selectedSolutions.isEmpty()) {
            println("No matching year found.")
        } else {
            for (i in 1..selectedSolutions.size) {
                println("Problem $i")
            }
            println("Select a problem:")
            val problem = Integer.parseInt(readln())
            println("Solutions: ${selectedSolutions[problem - 1].solutions()}")
        }
    }
}
