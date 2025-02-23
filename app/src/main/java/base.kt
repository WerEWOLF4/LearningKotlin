package base

// Encapsulation

private val privateVal = 3
internal val internalVal = 4
val publicVal = 5

private fun privateFun() = println("privateFn")
fun internalFun() = println("internalFn")
fun publicFun() = println("publicFn")

private class PrivateClass(val name: String)
internal class InternalClass(val name:String)
class PublicClass(val name:String)

fun printData(){
    // внутри модуля доступны приватные идентификаторы
    val privateClass= PrivateClass("Tom")
    println(privateVal)
    privateFun()

    // внутри модуля доступны internal-идентификаторы
    val internalClass= InternalClass("Tom")
    println(internalVal)
    internalFun()

    // внутри модуля доступны public-идентификаторы
    val publicClass= PublicClass("Tom")
    println(publicVal)
    publicFun()
}