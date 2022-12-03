import years.twentytwo.solutions.FirstSolution

fun main() {
    val allSolutions = mapOf(Pair("22", listOf(FirstSolution(), SecondSolution())))
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
