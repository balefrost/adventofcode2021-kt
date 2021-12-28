package org.balefrost.aoc2021

object Day02 : AbstractDay() {
    data class Command(val dir: String, val offset: Int)

    val input by lazy {
        val r = """(\w+) (\d+)""".toRegex()
        inputFileLines.map { line ->
            val m = r.matchEntire(line)!!
            Command(m.groupValues[1], m.groupValues[2].toInt())
        }
    }

    override fun part1(): Any {
        var x = 0
        var depth = 0
        for ((dir, off) in input) {
            when (dir) {
                "forward" -> x += off
                "up" -> depth -= off
                "down" -> depth += off
            }
        }
        return x * depth
    }

    override fun part2(): Any {
        var x = 0
        var depth = 0
        var aim = 0
        for ((dir, off) in input) {
            when (dir) {
                "forward" -> {
                    x += off
                    depth += aim *off
                }
                "up" -> aim -= off
                "down" -> aim += off
            }
        }
        return x * depth
    }

    @JvmStatic
    fun main(args: Array<String>) {
        main()
    }
}
