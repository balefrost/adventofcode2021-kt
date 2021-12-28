package org.balefrost.aoc2021

abstract class AbstractDay {
    abstract fun part1(): Any?
    abstract fun part2(): Any?

    fun main() {
        println(part1())
        println(part2())
    }

    val inputFileContent: String by lazy {
        val inputFileName = this::class.java.name.replace('.', '/').lowercase() + ".txt"
        val resourceUrl = this::class.java.classLoader.getResource(inputFileName)
        checkNotNull(resourceUrl) { "resource $inputFileName was not found"}
        resourceUrl.readText()
    }

    val inputFileLines: List<String> by lazy {
        inputFileContent.lines().filterNot { it.isBlank() }
    }

    fun String.linesWithoutTrailingBlanks(): Sequence<String> {
        return this
            .lineSequence()
            .windowed(2, 1, true)
            .filter { lines -> lines.size > 1 || lines[0].isNotBlank() }
            .map { lines -> lines[0] }
    }
}