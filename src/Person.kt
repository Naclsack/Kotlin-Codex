//This is the primary constructor, as part of the class definition
class Person(val firstName: String = "Peter", val lastName: String = "Parker"){

    var nickName: String? = null


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