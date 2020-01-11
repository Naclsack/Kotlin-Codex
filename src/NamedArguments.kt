//Default parameters let functions not have to pass in every argument, the default parameters here are
//greeting: String = "Hello" greeting being the parameter, String its type and "Hello" its default value
fun greetPerson(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting $name")

fun main(){

    //Here we are explicitly assigning "hi" to greeting and "Aaron" to name
    //This way the parameters can be entered in different orders
    //Once one parameter is entered as a named parameter, then all the parameters passed must be named
    greetPerson(greeting = "hi", name = "Aaron")
    greetPerson(name = "Aaron")
    greetPerson()

}