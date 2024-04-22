import java.time.LocalDate

fun main(args: Array<String>) {
    // println("Ingresas una fecha con formato <yyyy-mm--dd>")
    // constante
    // val input = LocalDate.parse(readlnOrNull())
    // println("Escribiste $input. Día de la semana ${input.dayOfWeek}") // Monday
    // Arreglos
    var miLista = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(miLista[0])
    miLista[2] = 2000
    // Condicionales
    var x = 12
    if (x is Int) println("Es un entero") else println("No es entero")
    var n = 12
    when (n) {
        in 1..5 -> {
            println("a")
        }

        in 6..10 -> {
            println("b")
        }

        11, 12, 13 -> {
            println("c")
        }

        14 -> {
            println("d")
        }

        is Int -> {
            println("Es un entero")
        }

        !is Int -> {
            println("NO es un entero")
        }

        else -> {
            println("Por defecto")
        }
    }

    // FOR
    val letras = listOf<String>("aa", "bb", "cc", "dd", "ee", "ff", "gg")
    for (letra in letras) {
        println(letra)
    }

    for (index in letras.indices) {
        println(index)
    }

    for (indice in letras.indices) {
        println("${letras[indice]} pos => $indice")
    }

    for (x in 1..50) {
        println(x)
    }

    for (x in 1..50 step 3) {
        println(x)
    }

    // Bajar hasta el 3 (esto baja de 100 a 3 de 1 en 1)
    for (x in 50 downTo 3) {
        println(x)
    }

    for (x in 50 downTo 3 step 2) {
        println(x)
    }

    // WHILE
    var variableWhile = 0;
    while (x < 10) {
        println(x)
        x++
    }
    do {
        println(x)
        x++
    } while (x < 10)

    // FUNCIONES
    fun escribir() {
        println("Holas mundos")
    }
    escribir()
    fun doble(num: Int): Int {
        return num * 2
    }
    println(doble(10))
    fun triple(num: Int) = num * 3
    println(triple(10))
    // Funciones genericas (void => Unit
    fun <T> generic(num: T): Unit {
        println(num)
    }
    generic("holas")
    generic(12)
    // Funciones por extension
    fun String.quitarEspacios(): String {
        println("Quitando espacios")
        var regex = Regex("\\s+")
        return regex.replace(this, " ")
    }
    var variable = "Holas     mundos     "
    println(variable.quitarEspacios())
    // Funciones con parfametros, comas, etc
    fun saludar (vararg nombres: String) {
        for (nombre in nombres) {
            println(nombre)
        }
    }
    saludar("Juam", "Pepe", "Carlos", "María")
}