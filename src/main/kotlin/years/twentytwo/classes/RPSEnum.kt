package years.twentytwo.classes

enum class RPSEnum(val move: String, val points: Int, val beats: String, val loses: String) {
    A("Rock", 1, "Z", "Y"),
    B("Paper", 2, "X", "Z"),
    C("Scissors", 3, "Y", "X"),
    X("Rock", 1, "C", "B"),
    Y("Paper", 2, "A", "C"),
    Z("Scissors", 3, "B", "A")
}
