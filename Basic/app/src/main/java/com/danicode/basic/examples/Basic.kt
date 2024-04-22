package com.danicode.basic

fun main() {
    getMonth(3);
    getSemester(7)
    result(4)
    // Valores nulos
    var name: String? = null
    name = "Lola"
    println(name)
    // Listas
    var readOnlyList: List<String> = listOf(
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo"
    )
    // "it" es necesario (iterador)
    val filter = readOnlyList.filter { it.contains("a") }
    val filter2 = readOnlyList.filter { item -> item.contains("l") }
    println(filter)
    println(filter2)
}

fun result(value: Any) {
    when (value) {
        is Int -> println(value + value)
        is String -> println("String $value")
        is Boolean -> if (value) println("Verdadero")
    }
}

fun getSemester(month: Int) {
    when (month) {
        in 1..6 -> print("Primer semestre")
        in 7..12 -> println("Segundo semestre")
        !in 1..12 -> println("Inválido")
    }
}

fun getMonth(month: Int) {
    when (month) {
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> println("Marzo")
        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Junio")
        7 -> println("Julio")
        8 -> println("Agosto")
        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        else -> println("Inválido")
    }
}