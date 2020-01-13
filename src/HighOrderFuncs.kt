//Higher order functions are functions that return other functions or take in functions as parameters.
//the parameter "predicate" is actually a function that takes in a string argument and returns a boolean
fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?){
    list.forEach {
        //A parameter of a function type can be called as it is a regular function
        if(predicate?.invoke(it) == true){
            println(it)
        }

    }
}

val predicate:(String) -> Boolean = {
    it.startsWith("k")
}

fun getPrintPredicate(): (String) -> Boolean{
    return {it.startsWith("K")}
}

fun main(){
    val list = listOf("Java", "Kotlin", "C#")
    val list2 = listOf("Java", "Kotlin", "C#", null, null)

    printFilteredStrings(list, predicate)

    printFilteredStrings(list, getPrintPredicate())

    //The {} is a function being sent in to the printFilteredList function as a parameter
    printFilteredStrings(list, {it.startsWith("K")})
    //This lambda will evaluate as true if any of the items in the list start with "K"

    //Alternately, according to lambda syntax, if the last parameter of a function is a function,
    //it can be specified as a lambda outside the (), It looks like the forEach function because forEach is also
    //a higher order function
    printFilteredStrings(list){
        it.startsWith("K")
    }


    list2
        .filterNotNull()
        .associate { it to it.length }
        .forEach{
            println("${it.value}, ${it.key}")
        }

}