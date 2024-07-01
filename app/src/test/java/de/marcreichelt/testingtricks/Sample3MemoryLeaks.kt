package de.marcreichelt.testingtricks

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Test

class Sample3MemoryLeaks {

    @Test
    fun `simple leak`() {
        harmlessLookingMethod()
    }

    /*
















    */

    private fun printUsedMemory() {
        val runtime = Runtime.getRuntime()
        val used = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024
        println("Used memory: $used MB")
    }

    @Test
    fun `see growing memory of a leak`() {
        repeat(10_000) { iteration ->
            harmlessLookingMethod()

            if (iteration % 1000 == 0) {
                printUsedMemory()
            }
        }
    }

    @Test
    fun `leak by a mock`() {
        // produces a memory leak using mockk
        repeat(100_000) { iteration ->
            mockkStatic(::buildUser)
            val testUser = User("Test", "User", -1)
            every { buildUser() } returns testUser

            if (iteration % 10_000 == 0) {
                // clearAllMocks()
                printUsedMemory()
                System.gc()
            }
            // if (iteration % 1000 == 0) System.gc()
        }
        // Thread.sleep(5.minutes.inWholeMilliseconds)
    }

}

// - demonstrate memory leak: memory grows
// - Trick: run repeatedly to see memory usage growing
// - Trick: add Thread.sleep(5.minutes.inWholeMilliseconds) to get more time to find leak!
// - Trick: add System.gc() to clear memory
// - Use VisualVM to find leak
// - Mocking: can lead to leaks unexpectedly! Could be a mockkObject, mockkStatic, coEvery,
//    leaking argument capture...
