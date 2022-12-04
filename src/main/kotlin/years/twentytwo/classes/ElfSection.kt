package years.twentytwo.classes


class ElfSection(input: String) {
    private val lower = Integer.parseInt(input.split("-")[0])
    private val upper = Integer.parseInt(input.split("-")[1])

    fun envelops(s: ElfSection) = lower <= s.lower && upper >= s.upper

    fun overlaps(s: ElfSection) = (lower >= s.lower && lower <= s.upper) || (upper >= s.lower && upper <= s.upper)
}