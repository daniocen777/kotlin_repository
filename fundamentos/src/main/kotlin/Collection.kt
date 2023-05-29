import classes.Group
import classes.User

fun main() {
    newTopic("Colecciones de solo lectura")
    // val fruitList = listOf<String>("Manzana", "Plátano", "Uva")
    val fruitList = listOf("Manzana", "Plátano", "Uva", "Papaya")
    println(fruitList.get(fruitList.indices.random()))
    println("El index de Uva es ${fruitList.indexOf("Uva")}")
    newTopic("Colecciones Mutable => Modificaciones en tiepo de ejecución")
    val myUser = User(1, "Danicode", "Ochoa", Group.FAMILY.ordinal)
    val bro = myUser.copy(id = 2, name = "Ivan")
    val friend = myUser.copy(id = 3, name = "Carmen", group = Group.FRIEND.ordinal)
    val userList = mutableListOf(myUser, bro)
    println(userList)
    userList.add(friend)
    println(userList)
    newTopic("Map o diccionarios")
    val userMap = mutableMapOf<Int, User>()
    userMap.put(myUser.id.toInt(), myUser)
    println(userMap)
    userMap.put(friend.id.toInt(), friend)
    println(userMap)

}