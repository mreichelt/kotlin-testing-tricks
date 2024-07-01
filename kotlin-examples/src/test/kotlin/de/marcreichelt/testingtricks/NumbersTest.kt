package de.marcreichelt.testingtricks

import assertk.assertThat
import assertk.assertions.hasSize
import org.junit.Test

class NumbersTest {

    @Test
    fun generateCorrectSizeOfNumbers() {
        val numbers = generateNumbers(1000)
        assertThat(numbers).hasSize(1000)
    }

    @Test
    fun test() {
        // code
    }

    @Test
    fun slowTest() {
        Thread.sleep(1000)
    }

}
