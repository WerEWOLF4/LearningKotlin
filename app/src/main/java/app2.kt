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

}

