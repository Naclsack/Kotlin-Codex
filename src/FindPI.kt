const val PI = 3.14159265359
val PI_ARRAY = arrayOf(1,4,1,5,9,2,6,5,3,5,9)

fun main() {

    funWithPI()

}

fun funWithPI() {

    println("What function do you wish to do?")
    println("1. Find the Nth number of PI.")
    println("2. Find the first occurrence of a number.")
    var funcToDo = readLine()
    if (funcToDo != null) {
        determineFunc(funcToDo.toInt())
    }
}

fun determineFunc(funcToUse: Int) {

    when(funcToUse){
        1 -> findNthInPI(findDigit())
        2 -> findNumberInPI(findDigit())
    }

}

fun findNumberInPI(findDigit: Int?) {

    var number = PI_ARRAY.indexOf(findDigit)
    number += 1
    println("The first occurrence of $findDigit in PI is in position $number")
}

fun findNthInPI(digitToFind: Int?) {

    try {
        if (digitToFind != null) {
            println("The $digitToFind th of PI is: " + PI_ARRAY[digitToFind - 1])
        }else{
            println("Enter a valid number please!")
            findDigit()
        }
    }catch(e: ArrayIndexOutOfBoundsException){
        println("Please pick a smaller number!")
        findDigit()
    }

}

fun findDigit(): Int? {

    println("Please enter a number.")
    var digit = readLine()
    return digit?.toInt()
}
