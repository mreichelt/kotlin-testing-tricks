package de.marcreichelt.testingtricks

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Ignore
import org.junit.Test
import org.koin.core.Koin
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import kotlin.time.Duration.Companion.seconds

class Sample5Coroutines {

    @Test
    fun `multiple test scopes`() = runTest {
        val generator = DelayedValueGenerator(this)
        assertThat(generator.number.value).isEqualTo(0)

        generator.compute()
        delay(1.1.seconds)

        assertThat(generator.number.value).isEqualTo(42)
    }


    @Test
    @Ignore
    fun `multiple TestScope instances with dependency injection`() = runTest {
        val koin = startKoin()
        val generator = koin.get<DelayedValueGenerator>()
        assertThat(generator.number.value).isEqualTo(0)

        generator.compute()
        delay(1.1.seconds)

        assertThat(generator.number.value).isEqualTo(42)
    }
}


fun startKoin(): Koin {
    return koinApplication {
        modules(
            delayedValueGeneratorModule,
            module {
                single<CoroutineScope> { TestScope() } // careful now!
            }
        )
    }.koin
}


// - show regular coroutine test
// - add TestScope() and see test fail
// - show multiple TestScopes in debugger: one is started, one is not
// - can be non-obvious if dependency injection is involved
// - Bonus: use testScope.runTest to have just a single test scope
