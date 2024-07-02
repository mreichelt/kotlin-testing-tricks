package de.marcreichelt.testingtricks

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.dsl.module
import kotlin.time.Duration.Companion.seconds

class DelayedValueGenerator(
    private val scope: CoroutineScope,
) {

    private val _number = MutableStateFlow(0)
    val number = _number.asStateFlow()

    fun compute() {
        scope.launch {
            delay(1.seconds)
            _number.emit(42)
        }
    }

}

val delayedValueGeneratorModule = module {
    single<DelayedValueGenerator> { DelayedValueGenerator(get()) }
}

@OptIn(DelicateCoroutinesApi::class)
val coroutineModule = module {
    single<CoroutineScope> { GlobalScope /* yolo */ }
}

val modules = delayedValueGeneratorModule + coroutineModule
