package years.twentytwo.classes

import java.util.*

class CrateStack {
    private val crates = Stack<Char>()
    fun addCrate(letter: Char): Char? = crates.push(letter)
    fun moveCrates(amount: Int, destination: CrateStack) {
        for(i in 1..amount) destination.addCrate(crates.pop())
    }
    fun moveCrates9001(amount: Int, destination: CrateStack) {
        var removed = Stack<Char>()
        for(i in 1..amount) removed.push(crates.pop())
        for(i in 1..amount) destination.addCrate(removed.pop())
    }
    fun getTop(): Char? = crates.peek()
    override fun toString(): String {
        return crates.foldRight("") {item, total -> total + item}.reversed()
    }
}