package classes

// Colocar las variables luego del nombre, funciona como un constructor
// Para que una clase se pueda heredar, colocar "open" al inicio
open class Phone(protected val number: Int) {
    fun call() {
        println("LLamando...")
    }

    open fun showNumber() {
        println("Mi número es $number")
    }
}