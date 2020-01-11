



fun main() {

    //Kotlin collections are inherently immutable, they cannot be changed once they have been initialised
    //a collection can be made mutable by adding "mutable" to the convenience function, e.g mutableMapOf

    //arrayOf is known as a "Convenience function"
    //arrayOf can infer the type of array by the data entered
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic books")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings[2])

    //A list version of the convenience function
    val interestingList = listOf("Kotlin", "Programming", "Comic books")
    interestingList.forEach{item ->
        println(item)
    }

    //Creates a simple map using the mapOf convenience function
    val interestingMap = mutableMapOf(1 to "a", 2 to "b", 3 to "3")
    interestingMap[4] = "d"
    //(key, value) are the parameters the forEach function takes in and then prints with $key and $value
    //E.g 1 and "a", 2 and "b"
    interestingMap.forEach{ (key, value) -> println("$key -> $value")}

    //The convenience syntax of a for loop in kotlin is "in"
    for(item in interestingThings){
        println(item)
    }

    //This is a lambda syntax, if a function's only parameter is another function
    //then the () may be omitted from forEach()
    interestingThings.forEach { item ->
        println("$item from forEach") //"$" Turns the string into a template
        //"it" can be used to iterate through the array but it is not very readable
    }

    //The forEachIndexed returns an index of the item
    interestingThings.forEachIndexed { index, item ->
        println("$item is at $index")
    }

    sayHello("Hello", "Kotlin", "Programming", "Books")

    //Adding the * in front of the array makes if a spread function, this is how you pass an existing collection
    //as a vararg parameter
    sayHello(itemsToGreet = *interestingThings, greeting = "Hello from the spread function" )

}

//Kotlin supports String templates, that you can use instead of concating strings
//vararg tells the compiler we're taking a variable number of String arguments after the "greeting" parameter
//so it dynamically turns the arguments entered into an array of Strings which can still be iterated through
fun sayHello(greeting:String, vararg itemsToGreet: String){
    itemsToGreet.forEach{itemToGreet ->
        println("$greeting $itemToGreet")
    }
}