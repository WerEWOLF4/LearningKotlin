//Punctul de Intrare este Fun (Nu ia nici un parametru)

//    Valori constante
const val maxApples = 120
fun main(){
/*  Daca instructia este indicată pe un rand
 atunci trebuie de pus " ; "
 */
    println("Kotlin on Metanit.com");println("Hello METANIT.COM")
    println("Kotlin is a fun")

//    Folosim var sau val pentru variabile
    var grade: Int
    grade = 23
    println(grade)

//    Inițializarea cu var poate fi redeclarată
    var apples: Int = 10
    apples = 20
    println(apples)

//    Nu a fost initializată, A fost redeclarată cu val initializarea
//    val age: Int
//    age = 23
//    age = 26

println(maxApples)

//    Tipuri de date 2.3

//   De la -128 Pînă la 127 1 biti
    val a: Byte = -10
//   De la -32 768 Pînă la 32 767 2 biti
    val b: Short = 45
//   De la -2 147 483 648 (-2)^31  Pînă la 2 147 483 647 (2^31 - 1) 4 biti
    val c: Int = -250
//    De la  –9 223 372 036 854 775 808 (-2^63) pînă la 223 372 036 854 775 807 (2^63-1) și ocupă 8 biți
    val d: Long = 30000
    println(a) // -10
    println(b) // 45
    println(c) // -250
    println(d) // 30000

    val e: Byte = 127 //
    println(e)

//    unsigned integer types
    val m: UByte = 10U
    val f: UShort = 45U
    val g: UInt = 250U
    val h: ULong = 30000U
    println(m) // 10
    println(f) // 45
    println(g) // 250
    println(h) // 30000

//    Înscrierea variabilei hexazecimale se începe cu 0x
    val num1 : Int = 0x0A1
    println(num1)

//    Pentru cifrele mari se adauga _ pentru lucru mai usor
    val million = 1_000_000
    val number = 1234_5678_9012_3456
    println(million)    // 1000000
    println(number)     // 1234567890123456

//    Floating point numbers
    val height: Double = 1.78
    val pi: Float = 3.14F
    println(height)      // 1.78
    println(pi)         // 3.14

//    Boolea Type
    val ab: Boolean = true
    val bc: Boolean = false
    println(ab);
    println(bc);

//    Simboluri
    val character: Char = 'A'
    println(character)

    val name: String = "Eugene"

    println(name)
// Pentru mai multe linii au fost create 3
    val text: String = """
                        SALT II was a series of talks between United States
                        and Soviet negotiators from 1972 to 1979.
                        It was a continuation of the SALT I talks.
                    """
    println(text)

//    Concatenația
    val firstName = "Tom"
    val lastName = "Smith"
    val welcome = "Hello, $firstName $lastName"
    println(welcome)    // Hello, Tom Smith

//    Tipizaația statică este variația tipurilor de date transmise unei variabile val este static și var este dinamic
//    Este un tip de date general numi Any, nu este de dorit de folosit
    var name1: Any = "Tom"
    println(name1)   // Tom

//    Operațiile cu cifrele
    var x = 5
    var y = 6
    var z = x + y
    var w = x - y
    var u = x * y
    var i = x / y
    var o = x % y
    println(z)
    println(w)
    println(u)
    println(i)
    println(o)
//    Prefixuri
//   PRE
   print(++x); print(++y); print(++z)
//   POST
     print(x++);

//  Operatiile cu bituri se poate lucra cu diferite tipuri de valori 2x 4x 8x 16x

//    Biturile fac push spre stinga
    println(3 shl 2);
    println(0b11 shl 2);

//    Biturile fac push spre dreapta
    println(12 ushr  2);
    println(0b1100 ushr 2);

//    Operațiile AND este înmulțirea logică a biturilor, OR este comparația fiecarui bit și despărțirea logică, XOR este comparația fiecarui bit și înmulțirea lui

//    and
    println(x and y);

//    or
    println(x or y);

//    xor
    println(x xor  y);

//    "inv" inversia sau negarea
    println(x.inv());

    print("Write your name: ")
    val your_name = readLine()
    print("Write your email: ")
    val your_email = readLine()
    print("Write your address: ")
    val your_address = readLine()

    println("Your name is: $your_name")
    println("Your email is: $your_email")
    println("Your address: $your_address")
}