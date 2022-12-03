package years.twentytwo.classes

data class Elf(val foods: List<Int>) {
    fun totalCalories() = foods.foldRight(0) { food, total -> food + total }
}
