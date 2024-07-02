package de.marcreichelt.testingtricks

// this code is fine, no leak
fun buildUser(): User {
    return User("Firstname", "Lastname", 40)
}
