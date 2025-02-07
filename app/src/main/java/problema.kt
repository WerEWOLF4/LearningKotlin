fun main() {

    fun age() {
        val age = readln().toInt()

        when {
            age % 100 in 11..14 -> println("$age let")
            age % 10 == 1 -> println("$age god")
            age % 10 in 2..4 -> println("$age goda")
            else -> println("$age let")
        }
    }
    age()

    outerloop@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 3) continue@outerloop;
            println("Hello" + i + "" + j)
        }
    }

    fun primeNumber(): Boolean {
        val nr = readln().toInt()

        if (nr < 2) return false // Prime numbers începe cu 2
        for (i in 2 until nr) {  // Pînă la nr
            if (nr % i == 0) return false
        }
        return true
    }
    
    println(primeNumber())

}