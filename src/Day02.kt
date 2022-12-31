import java.util.TreeMap


fun main() {

    val enemyMoveToNumber = mapOf(
        'A' to 0,
        'B' to 1,
        'C' to 2
    )

    val myMoveToNumber = mapOf(
        'X' to 0,
        'Y' to 1,
        'Z' to 2
    )

    val resultToNumber = mapOf(
        'X' to 0,
        'Y' to 3,
        'Z' to 6
    )

    val resultToChange = mapOf(
        'X' to -1,
        'Y' to 0,
        'Z' to 1
    )

    fun countStatePartOne(enemyMove: Int, myMove: Int): Int {
        var result = 0
        result = if (enemyMove == myMove) 3
        else if (enemyMove == (myMove + 1) % 3)
            0
        else if (myMove == (enemyMove + 1) % 3)
            6
        else {
            throw Exception("wrong countState")
        }
        return result + myMove + 1
    }

    fun countStatePartTwo(enemyMove: Int, result: Char): Int {
        var myMove = (enemyMove + resultToChange[result]!! ) % 3
        if (myMove < 0)
            myMove += 3
        return resultToNumber[result]!! + myMove + 1
    }

    fun part1(input: List<String>): Int {
        return input.map {
            val moves = it.split(' ')
            countStatePartOne(enemyMoveToNumber[moves[0][0]]!!, myMoveToNumber[moves[1][0]]!!)
        }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.map {
            val moves = it.split(' ')
            countStatePartTwo(enemyMoveToNumber[moves[0][0]]!!, moves[1][0])
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}