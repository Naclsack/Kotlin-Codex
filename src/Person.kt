//This is the primary constructor, as part of the class definition
//Classes are public by default
//Internal means that the class is public within the module
//Private classes are only available within the file its implemented
//These access modifiers work on variables
//A protected property or variable is only visible within it's class or sub-classes
class Person(val firstName: String = "Peter", val lastName: String = "Parker"){

    var nickName: String? = null
        set(value) {
            field = value
            println("The new nickname is $value")
        }
        get() {
            println("The returned value is $field")
            return field
        }

    //The Elvis operator "?:" checks to see if value on the left is null, if it isn't, return that, if it isn't,
    //the value on the right is returned, it is a more concise way of using if/else statements
    fun printInfo(){
        val nickNameToPrint = nickName ?:"No Nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }


    //The init function is a function that will run every time an instance of this class is run
    //Multiple init blocks can be used, they will run in order that they are written
    init{
        println("init 1")
    }

    constructor(): this("Peter", "Parker"){
        println("Secondary Constructor")
    }

    init{
        println("init 2")
    }
}