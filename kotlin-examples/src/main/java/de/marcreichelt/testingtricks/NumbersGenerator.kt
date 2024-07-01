package de.marcreichelt.testingtricks

interface NumbersGenerator {
    fun generateNumbers(upTo: Int): List<Int>
    fun generateEvenNumbers(size: Int): List<Int>
}

class NumbersGeneratorImpl : NumbersGenerator {
    override fun generateNumbers(upTo: Int): List<Int> =
        (1..upTo).toList()

    override fun generateEvenNumbers(size: Int): List<Int> =
        (0..(size - 1) * 2 step 2).toList()
}
