package de.marcreichelt.testingtricks

import kotlin.random.Random

data class User(
    val firstName: String,
    val lastName: String,
    val age: Int,
)

private val everGrowingList = mutableListOf<User>()

fun leak() {
    for (i in 0..1000) {
        everGrowingList.add(
            User("Max", "Muller", Random.nextInt(20, 100))
        )
    }
}

fun clear() = everGrowingList.clear()

fun harmlessLookingMethod() = leak()
