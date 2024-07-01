package de.marcreichelt.testingtricks

import org.junit.Test

class Sample3MemoryLeak {

    @Test
    fun simpleLeak() {
        harmlessLookingMethod()
    }

    /*
















    */

    @Test
    fun trackMemoryUsage() {
        repeat(10_000) { iteration ->
            harmlessLookingMethod()

            if (iteration % 1000 == 0) {
                printRuntimeMemoryUsed()
            }
        }
    }

}

fun printRuntimeMemoryUsed() {
    val runtime = Runtime.getRuntime()
    val used = (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024
    println("Used memory: $used MB")
}

// - demonstrate memory leak: memory grows
// - Trick: run repeatedly to see memory usage growing
// - Trick: add Thread.sleep(5.minutes.inWholeMilliseconds) to get more time to find leak!
// - Trick: add System.gc()
// - Use VisualVM to find leak
// - Mocking: can lead to leaks unexpectedly! Could be a mockkObject, mockkStatic, coEvery,
//    leaking argument capture...
