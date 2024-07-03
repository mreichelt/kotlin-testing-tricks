package de.marcreichelt.testingtricks

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.hasSize
import assertk.assertions.isEmpty
import org.junit.Test

class Sample1NumbersTest {

    @Test
    fun generateCorrectSizeOfNumbers() {
        val numbers = generateNumbers(1000)
        assertThat(numbers).hasSize(1000)
    }


    @Test
    fun generateNumbers() {
        val numbersGenerator = NumbersGeneratorImpl()
        assertThat(numbersGenerator.generateNumbers(0)).isEmpty()
        assertThat(numbersGenerator.generateNumbers(3)).containsExactly(1, 2, 3)
    }


    @Test
    fun generateEvenNumbers() {
        val numbersGenerator = NumbersGeneratorImpl()
        assertThat(numbersGenerator.generateEvenNumbers(0)).isEmpty()
        assertThat(numbersGenerator.generateEvenNumbers(3)).containsExactly(0, 2, 4)
        assertThat(numbersGenerator.generateEvenNumbers(5)).containsExactly(0, 2, 4, 6, 8)
    }

    @Test
    fun slowTest() {
        Thread.sleep(1000)
    }

}

// - Kotlin: `we can use whitespace in tests`
// - Rerun last test: Ctrl + R
// - Run currently selected test(s): Ctrl + Shift + R
// - Scroll to Stacktrace

// - Generate new test: Cmd + N

// - Rerun failed tests
// - Select only a few tests to run in test list
// - Rerun Automatically 🤯

// - Run with code coverage
