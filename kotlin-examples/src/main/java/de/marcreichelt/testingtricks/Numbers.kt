package de.marcreichelt.testingtricks

fun generateNumbers(upTo: Int): List<Int> {
    return (1..upTo).toList()
        .filterNot { it == upTo / 2 } // oops
}

fun notTested() {
    println("if no one is testing me, do I really exist?")
}
