fun printStrings(vararg strings: String) {
    for (str in strings)
        println(str)
}

fun sum(vararg numbers: Int){
    var result=0
    for(n in numbers)
        result += n
    println("Sum numerelor este egala cu $result")
}

fun printUserGroup(group: String, vararg users: String, count:Int) {
    println("Group: $group")
    println("Count: $count")
    for (user in users)
        println(user)
}

fun changeNumbers(vararg numbers: Int, koef: Int){
    for(number in numbers)
        println(number * koef)
}

fun sum_second(x:Int, y:Int): Int{

    return x + y
}

fun checkAge(age: Int){
    if(age < 0 || age > 110){
        println("Invalid age")
        return
    }
    println("Age is valid")
}

//Top level functions "main"
fun main(){

//   fun denumirea_functiei (parametrii) : tipul_de date care se intoarce{
//       Indeplinirea functieii
//    }

//    O functie simpla printeaza doar hello si trebuie chemata
    hello()
    hello()
    hello()

//    Valorile paramtrilor tot primesc tipul sau
    showMessage("Hello Kotlin")
    showMessage("Privet Kotlin")
    showMessage("Salut Kotlin")

//    Primul caz cu valori adaugate obligatoriu
    displayUser("Tom", 23)
    displayUser("Alice", 19)
    displayUser("Kate", 25)

//Al doilea caz cu valori determinate dar pot fi adaugate proprii valori
    displayUserInclude("Tom", 23, "Manager")
    displayUserInclude("Alice", 21)
    displayUserInclude("Kate")

//    Pentru parametrii neobilgatorii sunt valori implicite dar daca o valoarea fost transmisa cu variabila, toate valorile se transmit cu variabila

    displayUserInclude("Tom", position="Manager", age=28)
    displayUserInclude(age=21, name="Alice")
    displayUserInclude("Kate", position="Middle Developer")

//    Schimbarea parametrilor

//    fun double(n: Int){
//        n = n * 2   // !Ошибка - значение параметра нельзя изменить
//        println("Значение в функции double: $n")
//    }
    var nums = intArrayOf(4, 5, 6)
    double(nums)
    println("Functia main are valori: ${nums[0]}")


//    Functia poate primi mai multi parametrii de aceiasii valoare

    printStrings("Tom", "Bob", "Sam")
    printStrings("Kotlin", "JavaScript", "Java", "C#", "C++")

// Alt exemplu cu functia poate primi mai multe valori de același tip

    sum(1, 2, 3, 4, 5)
    sum(1, 2, 3, 4, 5, 6, 7, 8, 9)

//    Vararg de obicei este la sfărsit dar daca totusi sun parametrii dupa se transmit doar cu valori supranumite

    printUserGroup("KT-091", "Tom", "Bob", "Alice", count=3)

//    Spread Operator*

    val nums1 = intArrayOf(1, 2, 3, 4)
    changeNumbers(*nums1, koef=2)

//    Functia poate returna o valoare folosind return

    val a_second = sum_second(4, 3)
    val b_second = sum_second(5, 6)
    val c_second = sum_second(6, 9)
    println("a=$a_second  b=$b_second  c=$c_second")

//    Functia Tip Unit este analogic functieii void

//    Exemplu 1
fun hello_unit(){
    println("Hello")
}

//    Exemplu 2
fun hello_unit_second() : Unit{
    println("Hello")
}
//    Formal putem si oferi rezultatul unei valori dar practic nu are sens
    val d = hello()
    val e = hello()

//    Putem folosi si return la functia Unit daca este necesar

    checkAge(-10)
    checkAge(10)


//    Functia de o singura linie
//    fun имя_функции (параметры_функции) = тело_функции

    fun square(x: Int) = x * x

    val a = square(5)   // 25
    val b = square(6)   // 36
    println("a=$a  b=$b")

//    Functii Locale care pot fi introduse in alte functii exemplul precedent este local dar trebuie sa fie in afara functieii main
fun compareAge(age1: Int, age2: Int){

    fun ageIsValid(age: Int): Boolean{
        return age > 0 && age < 111
    }
    if( !ageIsValid(age1) || !ageIsValid(age2)) {
        println("Invalid age")
        return
    }

    when {
        age1 == age2 -> println("age1 == age2")
        age1 > age2 -> println("age1 > age2")
        age1 < age2 -> println("age1 < age2")
    }
}

    compareAge(20, 23)
    compareAge(-3, 20)
    compareAge(34, 134)
    compareAge(15, 8)


//    Function Overloading inseamna aceeasi functii doar ca parmetrii au tipuri de date iesire diferit si tipul parametrilor este diferit
fun sum_overloading(a: Int, b: Int) : Int{
    return a + b
}
    fun sum_overloading(a: Double, b: Double) : Double{
        return a + b
    }
    fun sum_overloading(a: Int, b: Int, c: Int) : Int{
        return a + b + c
    }
    fun sum_overloading(a: Int, b: Double) : Double{
        return a + b
    }
    fun sum_overloading(a: Double, b: Int) : Double{
        return a + b
    }

//   Fiecare valoare introdusa este diferita

    val a_overloading = sum_overloading(1, 2)
    val b_overloading = sum_overloading(1.5, 2.5)
    val c_overloading = sum_overloading(1, 2, 3)
    val d_overloading = sum_overloading(2, 1.5)
    val e_overloading = sum_overloading(1.5, 2)

//    Tipul Functii se determina astfel
//    (типы_параметров) -> возвращаемый_тип
//    Exemplu 1 fun hello(){
//
//    println("Hello Kotlin")
//}  () -> Unit

//    Exemplu 2
//fun sum(a: Int, b: Int): Int{
//    return a + b
//} //  (Int, Int) -> Int

//    Functia variabila
//    Exemplu 1
    val message: () -> Unit //tipul funtiie pe care o reprezinta variabila
    message = ::hello //:: operator root pentru a transmite variabila
    message(); // Dupa merge chemarea Functieii

//    Functie variabila
//    Exemplu 2
    var operation: (Int, Int) -> Int = ::sum_overloading // val ca variabila nu poate fi schimbata
    val result = operation(3, 5)
    println(result) // 8

//    Putem dinamic schimba functia care o primeste principal sa fie aceeasi tip de parametrii si date de iesire
    fun sum(a: Int, b: Int): Int{
        return a + b
    }

    fun subtract(a: Int, b: Int): Int{
        return a - b
    }

    fun multiply(a: Int, b: Int): Int{
        return a * b
    }

    fun empty (a: Int, b: Int): Int{
        return 0
    }

    operation = ::subtract
    val result2 = operation(14, 5)
    println(result2) // 9

//    Functia ca parametru a functieii
      fun displayMessage(mes: () -> Unit){ //Transmitereea in functie a variabilie care reprezinta o functie de tip Unit
          mes() //Chemarea functieii ca variabila
      }
    fun morning(){
        println("Good Morning")
    }
    fun evening(){
        println("Good Evening")
    }

//    Adresarea la functieii ca parametru a functieii
      displayMessage(::morning)
      displayMessage(::evening)

//    Functii care i-au parametrii pe lingă functia de parmetrii

    fun action (n1: Int, n2: Int, op: (Int, Int)-> Int){
        val result = op(n1, n2)
        println(result)
    }

    action(5, 3, ::sum);
    action(6, 8, ::multiply);
    action(5, 3, ::subtract);


//   Intoarcerea functieii la functieii cu functii de parmaetrii

    fun selectAction(key: Int): (Int, Int) -> Int{
    // determinarea rezultatului intors
    when(key){
        1 -> return ::sum
        2 -> return ::subtract
        3 -> return ::multiply
        else -> return ::empty
    }
}

    val action1 = selectAction(1)
    println(action1(8,5))    // 13

    val action2 = selectAction(2)
    println(action2(8,5))    // 3


//    Functii Anonime
//    Nu au nume aceste functii si sunt de de tip Unit adica void
//    Si au numai o expresie
    val message_anonim = fun()=println("Hello")
    message()

    val sum_anonim = fun(x: Int, y: Int): Int = x + y
    val result_anonim = sum_anonim(5, 4)
    println(result_anonim)


//    Functia Anonima  ca argument al functieii

    fun doOperation(x: Int, y: Int, op: (Int, Int) ->Int){

        val result = op(x, y)
        println(result)
    }

    doOperation(9,5, fun(x: Int, y: Int): Int = x + y )     // 14
    doOperation(9,5, fun(x: Int, y: Int): Int = x - y)      // 4

    val action_anonimus = fun(x: Int, y: Int): Int = x * y
    doOperation(9, 5, action_anonimus)       // 45

//    Intoarcerea functiie anonime din functia anonima


    fun selectActionanonimus(key: Int): (Int, Int) -> Int{
        // determinarea rezultatului primit
        when(key){
            1 -> return fun(x: Int, y: Int): Int = x + y
            2 -> return fun(x: Int, y: Int): Int = x - y
            3 -> return fun(x: Int, y: Int): Int = x * y
            else -> return fun(x: Int, y: Int): Int = 0
        }
    }

    val action1_anonymus = selectAction(1)
    val result1_anonymus = action1(4, 5)
    println(result1_anonymus)        // 9

    val action2_anonymus = selectAction(3)
    val result2_anonymus = action2(4, 5)
    println(result2_anonymus);      // 20


// Expresia Lambda indeplinesc aceeasi functie ca si functiile obisnuite si pot fi oferite variabilelor
//    Lambda se pune in paranteze si trebuie separta cu ;
    {println("hello")}
    val hello = { println("Hello Kotlin")};
    hello()
    hello()

    val hello_lambda: ()->Unit = {println("Hello Kotlin")}

//    Functia lambda poate fi chemata cu paranteze rotunde ()

    {println("Hello Kotlin")}();

    {println("Hello Kotlin")}();
    {println("Kotlin on Metanit.com")}()


//   Transmiterea variabilelor lambda
    val printer = {message: String -> println(message)}
    printer("Hello")
    printer("Good Bye")

    val sum_2 = {x:Int, y:Int -> println(x + y)}
    sum_2(2, 3)   // 5
    sum_2(4, 5)   // 9

//    Dupa ce lambda este declarata astfel poate fi transmis
    val sum_condition = {x:Int, y:Int ->
        val result = x + y
        println("$x + $y = $result")
    }

//    Intoarcerea rezulta Unit sau a unei functii obisunuite

//    Exemplu 1 Unit
    val hello_unit = { println("Hello")}
    val h = hello_unit()

//    Exemplu 2 Rezultat fix

    val sum = {x:Int, y:Int -> x + y}

    val y = sum(2, 3)   // 5
    val w = sum(4, 5)   // 9
    println("y=$y  w=$w")

//    Lambda ca exprimare argumentului in functie
    val sum_arg = {x:Int, y:Int -> x + y }
    doOperation(3, 4, sum_arg)                          // 7
    doOperation(3, 4, {a:Int, b: Int -> a * b}) // 12

//    Daca este indicat ce tip de date de iesire si parametrii sunt noi putem scrie in lambda expresie
    val sum_lambda: (Int, Int) -> Int = {x, y -> x + y }
    doOperation(3, 4, {a, b -> a * b})

//    Trailing Lambda
fun doOperationtrailing(x: Int, y: Int, op: (Int, Int) ->Int){

    val result = op(x, y)
    println(result)
}
    doOperationtrailing(3, 4, {a, b -> a * b}) // 12

//    Intoarcerea lambda expresiei din  functie simplia


    val action_select = selectActionKey(1)
    val result1_select = action_select(4, 5)
    println(result1_select)        // 9

    val action2_select = selectActionKey(3)
    val result2_select = action2_select(4, 5)
    println(result2_select)        // 20

    val action3_select = selectActionKey(9)
    val result3_select = action3_select(4, 5)
    println(result3_select)        // 0
}
fun selectActionKey(key: Int): (Int, Int) -> Int {
    // определение возвращаемого результата
    when (key) {
        1 -> return { x, y -> x + y }
        2 -> return { x, y -> x - y }
        3 -> return { x, y -> x * y }
        else -> return { x, y -> 0 }
    }

// Parametrii nefolositi

//    else -> return {x, y -> 0 }
//    else -> return {_, _ -> 0 }


// Closuer Замыкание este obiectul funcțieii, care tine in cont semantica mediului in care activeaza chiar daca se indeplineste nu in mediul sau
// 1. Functia din afara
// 2. Parametrii si Variabile (semantica)
// 3. Functia inscrisa

//    fun outer(): () -> Unit { // Functia din afara
//        var n   // semantica
//        fun inner () { // Functia inscrisa
//            // Ce se va intampla cu variabila n
//    }
//    return ::inner // intoarcem functia inscrisa
//}

//    Exemplu 1

    val fn = outer() //intoarce functia inner
    fn() // 6
    fn() // 7
    fn() // 8

//    Putem prescurta closure function cu ajutorul functieii anonime
    fun outer_anonimus(): () -> Unit {
        var n = 5
       return {
           n++
           println(n)
       }
    }
    var fn_anonimus = outer_anonimus()
    fn_anonimus() //6
    fn_anonimus() //7

//    Al doilea exemplu cu closure
    fun multiply_closure(n:Int): (Int)->Int{

        return {m:Int-> n * m}
    }

    val func_c = multiply_closure(5)
    val result9 = func_c(6) // 30
    println(result9)

//    Putem chema si altfel functia closure

    val result10 = multiply_closure(5)(6) // 30
    println(result10)       // 30

}

fun outer(): ()->Unit{       // внешняя функция
    var n = 5         // некоторая переменная - лексическое окружение функции inner
    fun inner(){     // вложенная функция
        // действия с переменной n
        n++
        println(n)
    }
    return ::inner
}

// Functia de obiceii este chemata in afara functiie main
fun hello() {
    println("Hello")
}
//    Functia poate primi valori pentru parametrii argumentului
fun showMessage(message: String){
    println(message)
}
fun displayUser(name: String, age: Int){
    println("Name: $name   Age: $age")
}

fun displayUserInclude(name: String, age: Int = 18, position: String="unemployed"){
    println("Name: $name   Age: $age  Position: $position")
}
fun double(numbers: IntArray){
    numbers[0] = numbers[0] * 2
    println("Valorile functieii double: ${numbers[0]}")
}