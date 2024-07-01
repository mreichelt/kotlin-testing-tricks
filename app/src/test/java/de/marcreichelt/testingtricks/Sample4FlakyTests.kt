package de.marcreichelt.testingtricks

import assertk.assertThat
import assertk.assertions.isNotEqualTo
import org.junit.Test
import kotlin.random.Random

class Sample4FlakyTests {
    @Test
    fun `this test fails once every 100 times`() {
        assertThat(Random.nextInt(100)).isNotEqualTo(0)
    }
}

// - show flaky test
// - use repeat to increase chance to see failure
// - rerun from command line: `./gradlew :app:testDebugUnitTest --tests "de.marcreichelt.testingtricks.Sample4FlakyTests.this test fails once every 100 times" --rerun`
// - bonus: use `for i in {1..100}; do echo $i; ./gradlew … || break; done`
