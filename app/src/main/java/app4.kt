import base.*
import java.time.DayOfWeek

//Inheritance
open class Person: Human {
    override var name: String = "Undefined"

    // Se poate de re-determinat getter si setter
    open val fullInfo: String
        get() = "Person $name - $age"

    open var age: Int? = null
        set(value) {
            if (value in 1..109) field = value
        }

    // Constructor with parameters
    constructor(_name: String, _age: Int?) : super(_name) {
        name = _name
        if (_age != null && _age > 0 && _age < 110) age = _age
    }

    // Secondary constructor
    constructor(_name: String) : this(_name, null)

    // Initialization block
//    init {
//        println("Person class initialized with name = $name and age = ${age ?: "Undefined"}")
//    }

    // Member functions
    open fun sayHello() {
        println("Hello, my name is $name")
    }

    private fun go(location: String) {
        println("$name goes to $location")
    }

    open fun personToString(): String {
        return "Name: $name  Age: ${age ?: "Undefined"}"
    }

//    init{
//        counter++
//    }
//
//    companion object  {
//        var counter  = 0
//        fun printCounter() = println(counter)
//    }

}

open class Work : Person {
    var workName: String
    var workHours: Int

    constructor(_workName: String, _workHours: Int) : super("Undefined", null) {
        this.workName = _workName
        this.workHours = _workHours
    }

    fun workDetails(): String {
        return "Work Name: $workName  Work Hours: $workHours"
    }

    override fun sayHello() {
        println("Hello, I work as a $workName")
    }
}

// Override parameters
open class Hobby(name: String) : Person(name) {
    // Override getter and setter
    override val fullInfo: String
        get() {
            println("Call getter")
            return "Employee $name - $age"
        }

    override var age: Int? = 18
        set(value) {
            println("Call setter")
            if (value in 18..109) field = value
        }

    // Constructor with parameters
    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }

    // Functia finala nu poate fi redeterimnata
    final override fun sayHello() {
        super.personToString()
        println("Hello, my name is $name")
    }
}

class Automobil(val marca: String, val viteza: Int)

val adaugaTrei: (Int) -> Int = { it + 3 }
val afiseazaMesaj: (Int) -> Unit = { an -> println("Bun venit în anul $an") }

fun calculeazaTaxa(taxa: Double, salariuMediu: Int? = null) {
    val salariu = salariuMediu ?: 5000
    if (salariuMediu == null) {
        println("Nu e salariu mediu pe țară, adică 5000 lei")
    }
    val taxaCalculata = salariu * taxa
    println("Taxa calculată pentru un salariu de $salariu lei este $taxaCalculata lei")
}

// Abstract Class si
abstract class Human(open val name: String) {
    fun hello() {
        println("My name is $name")
    }
}

// Exemplul de folosire a claselor abstracte

// абстрактный класс фигуры
abstract class Figure {
    // абстрактный метод для получения периметра
    abstract fun perimeter(): Float

    // абстрактный метод для получения площади
    abstract fun area(): Float
}
// производный класс прямоугольника
class Rectangle(val width: Float, val height: Float) : Figure()
{
    // переопределение получения периметра
    override fun perimeter(): Float{
        return width * 2 + height * 2;
    }
    // переопрелеление получения площади
    override fun area(): Float{
        return width * height;
    }
}

// Interface si Polimorfism
interface Movable{
    var speed: Int
    fun move()
    val model: String
    val number: String
    fun stop (){
        println("Ne oprim....")
    }
}
// класс машины
class Car(override val model: String, override var number: String) : Movable{
    override var speed = 60
    override fun move(){
        println("Mergem cu masina")
    }
}
// класс самолета
class Aircraft(override val model: String, override var number: String) : Movable{
    override var speed = 600
    override fun move(){
        println("Mergem cu avionul")
    }
    override  fun stop() = println("Aterizam...")
}

// Alt exemplu de Polimorfism cu Interface invocata altfel
fun work(worker:Worker) = worker.work()
fun study(student:Student) = student.study()

interface Worker{
    fun work()
}
interface Student{
    fun study()
}
class WorkingStudent(val name:String) : Worker, Student{
    override fun work() = println("$name lucreaza")
    override fun study() = println("$name invata")
}

//Romboid Polymorfism
interface  VideoPlayable {
    fun play() = println("Play video")
}
interface AudioPlayable {
    fun play() = println("Play audio")
}

class MediaPlayer : VideoPlayable, AudioPlayable {
    // Функцию play обязательно надо переопределить
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play() // вызываем VideoPlayable.play()
        super<AudioPlayable>.play() // вызываем AudioPlayable.play()
    }
}

//Data Class poate printa datele parametrilor
data class PersonData(val name: String, val age: Int){
    override fun toString(): String {
        return "Name: $name  Age: $age"
    }
}

//Enums class Day ce reprezinta zilele saptamanii
enum class Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Enums class poate sa aiba de asemenea constructor si pot fi initializate dupa constructor

enum class DaysOfTheWeek(val value: Int) {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

    fun getDuration(day: DaysOfTheWeek): Int {
        return value - day.value;
    }
}

//Classe Anonime si Realizatia Interfacelui cu ajutorul lui Enum
enum class DayTime{
    DAY{
        override val startHour = 6
        override val endHour = 21
        override fun printName(){
            println("Zi")
        }
    },
    NIGHT{
        override val startHour = 22
        override val endHour = 5
        override fun printName(){
            println("Noapte")
        }
    };
    abstract fun printName()
    abstract val startHour: Int
    abstract val endHour: Int
}

// Delegation looks like Inheritance

interface Messenger{
    fun send(message: String)
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessenger(val programName: String) : Messenger{
    override fun send(message: String) = println("Send message: `$message`")
    override fun sendTextMessage() = println("Send text message")
    override fun sendVideoMessage() = println("Send video message")
}
interface PhotoDevice{
    fun takePhoto()
}
class PhotoCamera: PhotoDevice{
    override fun takePhoto() = println("Take a photo")
}
class SmartPhone(val name: String, m: Messenger, p: PhotoDevice)
    : Messenger by  m, PhotoDevice by p

class SendSmartphoneMessage(val name: String, m: Messenger) : Messenger by  m{
    override fun sendTextMessage() = println("Send sms")
}

object person{
    val name = "Tom"
    var age = 37
    fun sayHello(){
        println("Hi, my name is $name")
    }
}


fun main() {
    // Exemplul 1
    val bob: Person = Person("Bob", 25)
    println(bob.name)       // Bob
    println(bob.age)        // 25

    // Exemplul 2
    val tom = Person("Tom", 18)
    println(tom.name)       // Tom
    println(tom.age)        // 18
    tom.sayHello()
    println(tom.personToString())

    // Exemplul cu constructorii
    val robin = Person("Robin", 39)
    println(robin.name)
    println(robin.age)
    val alex = Person("Alex", 45)
    println(alex.name)
    println(alex.age)

    // Exemplul de mostenire
    val programmer = Work("Programmer", 6)
    programmer.name = "Andy"
    programmer.age = 23

    val databaseAdministrator = Work("Database Administrator", 4)
    databaseAdministrator.name = "Valerian"
    databaseAdministrator.age = 30

    println("Name: ${programmer.name} Age: ${programmer.age} Work: ${programmer.workName} Hours: ${programmer.workHours}")
    println("Name: ${databaseAdministrator.name} Age: ${databaseAdministrator.age} Work: ${databaseAdministrator.workName} Hours: ${databaseAdministrator.workHours}")

    // Override parameters
    val hobby = Hobby("Swimming", 18)
    println("Daniel has hobby ${hobby.name} and age ${hobby.age}")

    // Override getter and setter
    val firstPerson = Person("Tom")
    println(hobby.fullInfo)
    firstPerson.age = 16
    println(firstPerson.fullInfo)
    val secondPerson = Person("Andrew")
    secondPerson.age = 20
    println(secondPerson.fullInfo)

    // Override object methods
    firstPerson.sayHello()
    secondPerson.sayHello()

    // Exemplul cu Automobil
    val automobil1 = Automobil("Toyota", 180)
    val automobil2 = Automobil("Ferrari", 210)
    println("Automobil 1: Marca - ${automobil1.marca}, Viteza - ${automobil1.viteza} km/h")
    println("Automobil 2: Marca - ${automobil2.marca}, Viteza - ${automobil2.viteza} km/h")
    if (automobil1.viteza > automobil2.viteza) {
        println("${automobil1.marca} este mai rapid cu viteza de ${automobil1.viteza} km/h")
    } else if (automobil1.viteza < automobil2.viteza) {
        println("${automobil2.marca} este mai rapid cu viteza de ${automobil2.viteza} km/h")
    } else {
        println("Ambele automobile au aceeași viteză de ${automobil1.viteza} km/h")
    }

    // Exemplul de lambda functions
    val numar = 5
    val rezultat = adaugaTrei(numar)
    println("Rezultatul adăugării lui 3 la $numar este $rezultat")

    val anulCurent = 2025
    afiseazaMesaj(anulCurent)

    calculeazaTaxa(0.2, 6000)
    calculeazaTaxa(0.2)

    // Abstract Class Human
//    val alice: Human = Human("Alice") // Abstract class cannot be instantiated
      val kate : Human = Person("Kate")
      val slim:  Human = Person("Slim Shady")
      kate.hello()
      slim.hello()

//    Polimorfism si Interfata
    val car1 = Car ("Toyota","239483DG" )
    val aircraft = Aircraft("ZX27", "2")
    car1.move()
    aircraft.move()

    car1.move()  // Едем на машине
    car1.stop()  // Останавливаемся...

    aircraft.move() // Летим на самолете
    aircraft.stop() // Приземляемся...

//    Interfata si parametrii

    car1.move()
    aircraft.move()

//    Interfata
    val andre = WorkingStudent("Andre")
    work(andre)   // Tom lucreaza
    study(andre)  // Tom invata

//    Instalarea parametrilor prin constructor
    println(car1.model)    // Toyota
    println(car1.number)   // 223123DG

    println(aircraft.model)
    println(aircraft.number)

//    Romboid polimorfism
    val player = MediaPlayer()
    player.play()

//    Data Class
    val alice: PersonData = PersonData("Alice", 24)
    println(alice.toString())

//    Data class decompozitia
    val (username, userage) = alice
    println("Name: $username  Age: $userage") // Name: Alice  Age: 24

//    Day Enums printeaza rezultatele

    val day: Day = Day.FRIDAY
    println(day)            // FRIDAY
    println(Day.MONDAY)     // MONDAY

// Initialiatia Enum plus obtinerea parametrilor

    val dayofWeek: DaysOfTheWeek = DaysOfTheWeek.FRIDAY
    println(dayofWeek.value)        // 5
    println(DaysOfTheWeek.MONDAY.value) // 1

//    Enum printarea functieii
    val day1: DaysOfTheWeek = DaysOfTheWeek.FRIDAY
    val day2: DaysOfTheWeek = DaysOfTheWeek.MONDAY
    println(day1.getDuration(day2))        // 4

//  Name and Ordinal || Values and value
    println(day1.name); //FRIDAY
    println(day1.ordinal) // 4

//  Values and valueOf

    for(day in Day.values())
        println(day)

    println(Day.valueOf("FRIDAY"))

// Functii Anonime si realizatia interfaceului
    DayTime.DAY.printName()     // Zi
    DayTime.NIGHT.printName()   // Noapte

    println("Day from ${DayTime.DAY.startHour} to ${DayTime.DAY.endHour}")


    println(operate(5, 6, Operation.ADD))         // 11
    println(operate(5, 6, Operation.SUBTRACT))   // -1
    println(operate(5, 6, Operation.MULTIPLY))   // 30

//    Delegation of Function

    val telegram = InstantMessenger("Telegram")
    val photoCamera = PhotoCamera()
    val pixel = SmartPhone("Pixel 5", telegram, photoCamera)
    pixel.send("Hello Kotlin")
    pixel.takePhoto()

//    Function cind redetermina nu deleaga sarcina
    val telegram2 = InstantMessenger("Telegram")
    val pixel2 = SendSmartphoneMessage("Pixel 5", telegram2)
    pixel2.sendTextMessage()
    pixel2.sendVideoMessage()

//    Delegarea parametrilor
//    println(pixel.programName)  // Telegram

//    Objects printline
//    println("Name: ${person.name}  Age: ${person.age}")
//    person.sayHello()

//    Inheritance anonymus objects

//    val teddy = object : Person("Teddy"){
//
//        val company = "JetBrains"
//        override fun sayHello(){
//            println("Hi, my name is $name. I work in $company")
//        }
//    }
//
//    teddy.sayHello()
//
////    Anonymus objects as an argument to a functio
//    hello(
//        object : Person("Sam"){
//            val company = "JetBrains"
//            override fun sayHello(){
//                println("Hi, my name is $name. I work in $company")
//            }
//        })
//
////    Anonymus ojsects as an result to a function
//    val palm = createPerson("Palm", "JetBrains")
//    tom.sayHello()
//
//    println(palm.name)
//    println(palm.company)

//  Plus counter for companion in intialization
//   println(Person.counter)

}


// Pastrarea Starilor cu ajutorul lui Enum
enum class Operation{

    ADD, SUBTRACT, MULTIPLY
}
fun operate(n1: Int, n2: Int, op: Operation): Int{

    when(op){
        Operation.ADD -> return n1 + n2
        Operation.SUBTRACT -> return n1 - n2
        Operation.MULTIPLY -> return n1 *n2
    }
}

////Anonymus objects as argument to a function
//fun hello(person: Person){
//    person.sayHello()
//}
//
////    Anonymus ojsects as an result to a function
//private fun createPerson(_name: String, _company: String) = object{
//    val name = _name
//    val company = _company
//    fun sayHello() = println("Hi, my name is $name. I work in $company")
//}
