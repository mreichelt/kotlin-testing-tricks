package de.marcreichelt.testingtricks

import org.koin.dsl.module

val numbersModule = module {
    factory<NumbersGenerator> { NumbersGeneratorImpl() }
}
