fun main() {
    newTopic("Bucles")
    showPerson("Pepe", "mario", "lola")
    showPerson("Keka", "Pedro", "Lolas", "Memo", "Rafa", "Fernanda")
}

fun showPerson(p1: String, p2: String, p3: String) {
    println(p1)
    println(p2)
    println(p3)
}

// Arreglo => usar reservada vararg
fun showPerson(vararg persons: String) {
    // println(persons[0])
    // println(persons[1])
    newTopic("For")
    for (person in persons) println(person)
    newTopic("While")
    var index = 0
    while (index < persons.size) {
        println(persons[index])
        index++
    }
    newTopic("When => Switch")
    // index = (0..persons.size - 1).random() // rango
    index = (persons.indices).random() // rango
    println("Index => $index")
    when (persons[index]) {
        "Memo" -> println("Es Momo")
        "Rafa" -> {
            println("Es Rafa")
            println("Holas")
        }

        else -> println(persons[index])
    }
}
