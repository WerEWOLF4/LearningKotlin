
val addThree: (Int) -> Int = { x -> x + 3 }

val printMessage: () -> Unit = { println("Bun venit in 2025") }

class Employee(private val salary: Double, private val taxRate: Double) {
    fun calculateNetSalary(): Double {
        val tax = salary * taxRate / 100
        return salary - tax
    }
}

fun main () {

    println(addThree(5))
    printMessage()

    val employee = Employee(5000.0, 30.0)
    println(employee.calculateNetSalary())


}


