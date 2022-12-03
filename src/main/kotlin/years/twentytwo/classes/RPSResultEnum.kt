package years.twentytwo.classes

enum class RPSResultEnum(val result: String, val points: Int) {
    Z("WIN", 6),
    X("LOSE", 0),
    Y("DRAW", 3)
}
