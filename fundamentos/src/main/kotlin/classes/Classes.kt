package classes

import newTopic

fun main() {
    newTopic("Clases")
    val phone: Phone = Phone(988988899)
    phone.call()
    phone.showNumber()
    newTopic("Herencia")
    val smartphone = Smartphone(888776787, true)
    smartphone.call()
    smartphone.showNumber()
    newTopic("Data Classes")
    val myUser = User(1, "Danicode", "Ochoa", Group.FAMILY.ordinal)
    val bro = myUser.copy(id = 2, name = "Ivan")
    println(myUser)
    println(bro)
    newTopic("Funciones de alcance => Múltiples acciones en una solo línea")
    with(smartphone) {
        // No es necesario colocar nombre del objeto para llamar a sus variables y métodos
        println("¿Es privado? $isPrivate")
    }
    // Configurar un objeto
    bro.apply {
        group = Group.WORK.ordinal
        name = "Lolas"
        lastname = "Patiño"
    }
    println(bro)
}