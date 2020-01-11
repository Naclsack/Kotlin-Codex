
//Top level variable i.e Global Variable
val name: String? = null
var age: Int = 26

//Nullable Strings
var address: String? = null

fun main() {

    //inferred type
    var inferredTypeVar = " Inferred type "

    //When is pretty much a Java switch statement
    when(name){
        null -> println("Name is null")
        else -> println("Name is " + name)
    }

    //Assigning a value to a val via an if expression
    var greeting: String? = null
    val greetingToPrint = if(greeting != null) greeting else "Hi there!"
    println(greetingToPrint)

    //Assigning a value to a val via a when expression
    val nameToPrint = when(name){
        null -> "Aaron"
        else -> name
    }

    //Kotlin doesn't require getters, person.firstName is known as Property Access Syntax
    //Properties can be referenced directly by their name
    val person = Person("Aaron", "Hynes")
    val person2 = Person()
    person.nickName = "Salty"
    println(person.firstName + person.lastName + person.nickName)
    //println(person2.firstName + person2.lastName)

}

//Functions in Kotlin can be declared outside a class, they are referred to as
//"Top level functions"

//If greeting is declared a global variable, creating a new getGreeting method
//will not compile as one is inherently created.
//Functions also support nullable return types and
fun getGreeting(): String?{
    return "Hi from getGreeting method"
}

//Single expression functions are functions with a single expression like this
//Kotlin functions can infer return types
fun getEmail() = "bippityboop@gmail.com"



