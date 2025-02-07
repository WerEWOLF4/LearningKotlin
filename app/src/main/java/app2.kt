fun main(){

//    Expresii condiționale
    var a = 10
    if(a == 10) {
        println("a egal 10")
    }
    else if(a == 9){
        println("a egal 9")
    }
    else if(a == 8){
        println("a egal 8")
    }
    else{
        println("variabila este nedeterminată")
    }

//    Expresii condiționale nu trebuie ne apărat să fie în paranteze

//    Exemplu
    val b = 20
    val c = if (a > b) a else b

    println(c)  // 20

//    Al doilea exemplu
    val d = if (a > b) 1 else if (a < b) -1 else 0

    println(d)  // 0

//    Construcția when este exemplară cu construcția switch

//    Primul exemplu
    val isEnabled = true
    when(isEnabled){
        false -> println("isEnabled off")
        true -> println("isEnabled on")
    }

//    Al doilea exemplu
    val e = 30
    when(e){
        10 -> println("a = 10")
        20 -> println("a = 20")
        else -> println("valoare nedeterminată")
    }

//    Poți înscrie mai multe condiții în "when" care o să fie executabile pentru when

    when(a){
        10 -> {
            println("a = 10")
            a *= 2
        }
        20 -> {
            println("a = 20")
            a *= 5
        }
        else -> { println("valoare nedeterminată")}
    }
    println(a)

//    Compararea cu cîteva elemente
    when(a) {
        10, 20 -> println("a = 10 sau a = 20")
        else -> println("valoare nedeterminată")
    }
//        Compararea cu cîteva elemente în diapazon folosind "in"


            val result = when(a) {
            in 10..19 -> "a in diapazon cu 10 pînă 19"
            in 20..29 -> "a in diapazon cu 20 pînă 29"
            !in 10..20 -> "a in diapazon cu  10 pînă 20"
            else -> "valoare nedeterminată"
        }

        println(result)

//    when și rezolvarea dinamică a condițiilor

        when(a){
            b - c -> println("a = b - c")
            b + 5 -> println("a = b + 5")
            else -> println("valoare nedeterminată")
        }

//    Pe lîngă aceasta when poate primi valori dinamice

    when(a + b){
        10 -> println("a + b = 10")
        20 -> println("a + b = 20")
        30 -> println("a + b = 30")
        else -> println("Undefined")
    }

//    Putem determina valoarea disponibilă într-un bloc when
    when(val c = a + b){
        10 -> println("a + b = 10")
        20 -> println("a + b = 20")
        else -> println("c = $c")
    }

//    Construcția "when" este analogică lui if/else

    when{
        (b > 10) -> println("b mai mare 10")
        (a > 10) -> println("a mai mare 10")
        else -> println("a sau b mai mic sau egal 10")
    }

//    Întoarcerea valorilor

//    Exemplu 1
    val day = 2
    var dayOfweek = when (day) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        else -> "Unknown"
    }
    println(dayOfweek)

//    Exemplu 2
    val sum = 1000

    val rate = when(sum){
        in 100..999 -> 10
        in 1000..9999 -> 15
        else -> 20
    }
    println(rate)

//    Ciclul for
    for (n in 1..9){
        println("${n * n} \t")
    }

//    Tablou bidimensional for

    for(i in 1..9){
        for(j in 1..9){
            print("${i * j} \t")
        }
        println()
    }

//    Ciclul while
    var i = 10
    while(i > 0){
        println(i*i)
        i--;
    }

//    Ciclul do...while

    do{
        println(i*i)
        i--;
    }
    while(i > 0)

//    Operatorul continue si break
    for(n in 1..8){
        if(n == 5) continue;
        println(n * n)
    }

    for(n in 1..5){
        if(n == 5) break;
        println(n * n)
    }

//    Operatorul break
    for(i in 1..3){
        for(j in 1..3){
            if(j == 3) break;
            println("Hello")
        }
    }

//    Ca să iesi dintr-un ciclu folosim outerloop@ se va printa 3 Hello

    outerloop@ for(i in 1..3){
        for(j in 1..3){
            if(j == 3) break@outerloop;
            println("Hello")
        }
    }

//    Calcularea aria unui dreptunghi laturile caruia a si b sunt date de la tastatura.
    fun dreptunghi(){
        var a = readln().toDouble();
        var b = readln().toDouble();
        var c = (a * b);
        println("Aria dreptunghiului este $c");
    }
   dreptunghi();

//    Variabila v determina numarul de ani. Afisati calificativul “tinar” daca v<=18, “mediu” daca v<=50,”in virsta” daca v>50
    fun virsta() {
        var ani = readln().toInt();

        when (ani) {
            in 0..17 -> println("tinar")
            18 -> println("mediu")
            in 18..50 -> println("medie")
            else -> println("în vărstă")
        }
    }
    virsta();

//    Convertiti lungimea l din cm in m.
    fun metrii(a:Int = 100, b:Int = 50, c: Int = 1000){
        println(a * 100);
        println(b * 100);
        println(c * 100);
    }
    metrii();

    fun nota(){
        val notaPrimita = readln().toInt();

        if(notaPrimita === 1 && notaPrimita >= 4) {
            println("nesatisfacator")
        } else if (notaPrimita > 4 && notaPrimita <= 8){
            println("satisfacator")
        } else if (notaPrimita > 8 && notaPrimita <= 10){
            println("excelent")
        }

    }
    nota();

//    Diapazonul poate sa nu reprezinte cifre dar si litere
    val range = 1..5
    val range_first = "a".."d";

//    Cu downTo se poate construi o funcție în ordine descrescătoare
    val range1 =  1..5      // 1 2 3 4 5
    val range2 =  5 downTo 1    // 5 4 3 2 1

//    Inca o functie specială este step care oferă posibilitate de da o ordine a pasilor
    val range3 = 1..10 step 2           // 1 3 5 7 9
    val range4 = 10 downTo 1 step 3     // 10 7 4 1

//    Inca o functie ste untill ea ne oferă posibilitatea să nu includem granița de sus
    val range5 = 1 until 9          // 1 2 3 4 5 6 7 8
    val range6 = 1 until 9 step 2   // 1 3 5 7

//    Despre "in" întoarce true dacă este în diapazon și false dacă nu este,  "!in"  întoarce true dacă nu este în diapzon

    val range7 = 1..5

    var isInRange = 5 in range7
    println(isInRange)      // true

    isInRange = 86 in range7
    println(isInRange)      // false

    var isNotInRange = 6 !in range7
    println(isNotInRange)   // true

    isNotInRange = 3 !in range7
    println(isNotInRange)   // false

//    Cu ajutorul ciclurilor se poate de ales diapazonul
    val range8 = 5 downTo 1
    for(c in range1) print(c)   // 54321
    println()

    val range9 = 'a'..'d'
    for(c in range2) print(c)   // abcd
    println()

    for(c in 1..9) print(c)     // 123456789
    println()

    for(c in 1 until 9) print(c)    // 12345678
    println()

    for(c in 1..9 step 2) print(c)  // 13579

//    Array cu cifre intregi
    val numbers: Array<Int>

//    Cu ajutorul functieii arrayOf() se poate de oferit o mulțime de numere
    val numbers_off: Array<Int> = arrayOf(1, 2, 3, 4, 5)

//    Se poate de folosit tipizatia si de oferit deodată o multime
    val numbers_on = arrayOf(1, 2, 3, 4, 5)

//  Se transmite un Array gol de elemente cu metoda arraysOfNulls().
    val numbers_null = arrayOfNulls<Int>(3)  // [null, null, null]

// Se poate de creat un Array cu valori prestabilitie
    val numbers_of = Array(3, {5}) // [5, 5, 5]

//    Dar sunt si declaratii mai complexe
    var p = 1;
    val numbers_arr1 = Array(3, { p++ * 2}) // [2, 4, 6]

//    Indexul elementul poate fi obținut din paranteze patrate si de fiecare data incepe cu 0
    val numbers_index = arrayOf(1, 2, 3, 4, 5)
    val n = numbers_index[1]  // получаем второй элемент  n=2
    println(n)
    numbers_index[2] = 7      // переустанавливаем третий элемент
    println("numbers[2] = ${numbers_index[2]}") // numbers[2] = 7

//    Cu ajutorul lui size putem afla marimea acestui Array
    val numbers_full  = arrayOf(1, 2, 3, 4, 5);
    println(numbers_full.size)   // 5

    val people = arrayOf("Tom", "Bob", "Sam")
    println(people.size)   // 3

//    Cu ajutorul ciclului for putem afla si organiza operatii logice cu masivul
    val numbers_in = arrayOf(1, 2, 3, 4, 5)
    for(number in numbers_in){
        print("$number \t")
    }

//    Astfel putem rasfoi si in celelate tipuri de masivuri
    val people_of = arrayOf("Tom", "Sam", "Bob")
    for(person in people_of){
        print("$person \t")
    }

//    Verificam daca elementul este in masiv cu ajutorul lui in
    val numbers_is = arrayOf(1, 2, 3, 4, 5)

    println(4 in numbers_is)       // true
    println(2 !in numbers_is)      // false

//    Sunt diferite tipuri de Array adica massivuri
    val numbers_int: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val doubles: DoubleArray = doubleArrayOf(2.4, 4.5, 1.2)

//    Intializarea acestora
    val numbers_arr2 = IntArray(3, {5})
    val doubles_arr = DoubleArray(3, {1.5})


}


