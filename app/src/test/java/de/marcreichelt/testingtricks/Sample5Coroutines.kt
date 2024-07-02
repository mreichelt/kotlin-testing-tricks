package de.marcreichelt.testingtricks

import kotlinx.coroutines.test.runTest
import org.junit.Test

class Sample5Coroutines {
    @Test
    fun `multiple test scopes`() = runTest {
    }
}

// - show regular coroutine test
// - show multiple TestScopes in debugger
