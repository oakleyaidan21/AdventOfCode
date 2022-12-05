package years.twentytwo.classes

class CrateMove(input: String) {
    var amount = 0
    var from = 0
    var dest = 0
    init {
        val tokens = input.split(" ")
        amount = Integer.parseInt(tokens[1])
        from = Integer.parseInt(tokens[3])
        dest = Integer.parseInt(tokens[5])
    }

    override fun toString(): String {
        return "move $amount from $from to $dest"
    }
}