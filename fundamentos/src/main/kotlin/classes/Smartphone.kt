package classes

class Smartphone(number: Int, val isPrivate: Boolean) : Phone(number) {
    // Sobreescribir
    override fun showNumber() {
        if (isPrivate) println("Desconocido $number") else super.showNumber()
    }
}