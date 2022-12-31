import java.util.TreeMap

fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        var sum = 0
        input.forEach {
            if (it.isEmpty())
                count = 0
            else {
                count += it.toInt()
                if (count > sum)
                    sum = count
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var count = 0
        val modificated = input.map {
            if (it.isEmpty())
                count++
            Pair(it, count)
        }.filter { it.first.isNotEmpty()}.map {Pair(it.first.toInt(), it.second)}.groupBy ({ it.second }, {it.first}).values.map { it.sum() }.sortedDescending().subList(0, 3).sum()
        return modificated
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
