fun main(args: Array<String>) {
    newTopic("Variables y constantes")
    // Constantes
    val myConstant1 = 4
    // println(myConstant1)
    // Variables
    var myVar: String = "Pepe"
    println("Mi constante $myConstant1 y mi variable $myVar")
    // Variables nulos (ninguna variable o constantes son null) Para decir que es null, colocar ?
    var objNull: String? = null
    // Varialbes que aceptan cualquier valor
    var anyVar: Any?
    anyVar = 4
    println("Mi valor $anyVar")
    anyVar = "holas"
    println("Mi valor $anyVar")
}

fun newTopic(topic: String) {
    print("\n========================= $topic =========================\n")
}