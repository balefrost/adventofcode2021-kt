package org.balefrost.aoc2021

object Day01 : AbstractDay() {
    val input by lazy { inputFileLines.map { it.toInt() }}

    override fun part1(): Any {
        return input.windowed(2).count { (a, b) -> b > a }
    }

    override fun part2(): Any {
        return input.windowed(3).map { (a, b, c) -> a + b + c }.windowed(2).count { (a, b) -> b > a }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        main()
    }
}
