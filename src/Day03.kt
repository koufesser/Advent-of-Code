fun main() {
    fun getRepeatingChar(a : String, b : String): Set<Int> {
        val c = b.chars().toArray()
        val set = a.chars().toArray().intersect(c.asIterable().toSet())
        assert(set.size == 1) { "oof" }
        return set
    }

    fun getCharCode(a : Char): Int {
        if (a.isLowerCase())
            return a.code - 'a'.code + 1
        if (a.isUpperCase())
            return a.code - 'A'.code + 27
        else
            throw Exception("Not existing Char")
    }

    fun part1(input: List<String>): Int {
        return input.map {
            getRepeatingChar(
                it.subSequence(0, it.length / 2).toString(),
                it.subSequence(it.length / 2, it.length).toString()
            )
        }.sumOf { getCharCode(it.first().toChar()) }
    }

    fun findCommonInThree(a : String, b: String, c: String): Int {
        val set = getRepeatingChar(a, b).intersect(c.chars().toArray().asIterable().toSet())
        assert(set.size == 1)
        return set.first()
    }

    fun part2(input: List<String>): Int {
        var count = 0
        var
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
//    check(part2(testInput) == 12)
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}