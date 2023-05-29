import kotlin.math.abs

fun main() {
    sayHello()
}

// Unit => void (no retorna datos (pero está por default
private fun sayHello(): Unit {
    newTopic("Argumantos")
    val a = 34
    val b = 12
    println("Suma $a + $b => ${sum(a, b)}")
    newTopic("Infix => Extensiones")
    val forAbs = -12
    println(forAbs.enableAbs(false))
    println("Suma $a + $forAbs => ${sum(a, forAbs)}")
    println("Suma $a + |$forAbs| => ${sum(a, forAbs.enableAbs(true))}")
    newTopic("Sobrecarga en métodos")
    showProduct("Jabón", "13%")
    showProduct("Paltas")
    // Colocar valor al tecer parámetro sin enviar el segundo
    showProduct("Jugos", validity = "14 de mayo")
}

private fun sum(a: Int, b: Int): Int {
    return a + b
}

// Extensiones (infix) => Solo se pasa 1 parámetro
// Valor absoluto => true => valor absoluto, si no, retorna el mismo número
infix fun Int.enableAbs(enable: Boolean) = if (enable) abs(this) else this

// Sobrecarga
fun showProduct(name: String, prom: String = "Sin promoción", validity: String = "Agotar existencias") {
    println("$name => $prom hasta $validity")
}


