package de.marcreichelt.testingtricks

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.isEmpty
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class Sample2Mocking {

    @Test
    fun `without mock`() {
        val numbersGenerator = FakeNumbersGenerator()

        assertThat(numbersGenerator.generateNumbers(0)).isEmpty()
    }

    @Test
    fun `with mock`() {
        val numbersGenerator = mockk<NumbersGenerator>()
        every { numbersGenerator.generateNumbers(any()) } returns emptyList()

        assertThat(numbersGenerator.generateNumbers(0)).isEmpty()
    }

    @Test
    fun `another mock`() {
        val numbersGenerator = mockk<NumbersGenerator>()
        every { numbersGenerator.generateEvenNumbers(any()) } returns emptyList()

        assertThat(numbersGenerator.generateEvenNumbers(0)).isEmpty()
    }

    @Test
    fun `fake with default parameters`() {
        val numbersGenerator = FakeNumbersGeneratorArgs(generateEvenNumbers = { listOf(0, 2, 4) })
        assertThat(numbersGenerator.generateEvenNumbers(3)).containsExactly(0, 2, 4)
    }
}

private class FakeNumbersGenerator : NumbersGenerator {
    override fun generateNumbers(upTo: Int): List<Int> = emptyList()
    override fun generateEvenNumbers(size: Int): List<Int> = emptyList()
}


private class FakeNumbersGeneratorArgs(
    private val generateNumbers: (Int) -> List<Int> = { emptyList() },
    private val generateEvenNumbers: (Int) -> List<Int> = { emptyList() },
) : NumbersGenerator {
    override fun generateNumbers(upTo: Int) = generateNumbers.invoke(upTo)
    override fun generateEvenNumbers(size: Int) = generateEvenNumbers.invoke(size)
}

// - show time difference between mock and fake
// - time accumulates for every module - can be even 1-2 seconds, just for initalizing mocking!
// - runtime exception when forgetting to mock a method
// - complexity of mocking: every new mock in a test creates a new dynamic instance
//   - often a fake with one parameter could be enough! Example: Flow
