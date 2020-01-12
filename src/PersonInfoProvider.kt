interface PersonInfoProvider{

    //Variables can be declared in an interface but initialising them will cause a compilation error
    val providerInfo: String

    //Functions can be defined and implemented through interfaces in Kotlin
    //The printInfo function in the BasicInfoProvider class is using this function
    fun printInfo(person: Person){
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider{
    fun getSessionId(): String
}

//Abstract classes cannot be instantiated
//Kotlin classes support multiple interfaces
//the "open" keyword makes this class inheritable
open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider{
    override val providerInfo: String
        get() = "BasicInfoProvider"

    //Variables must be declared "open" to be inherited
    //Protected makes it so that the prefix can't be accessed via property access.
    protected open val sessionIdPrefix = "Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }

}

fun main(){

    val provider = FancyInfoProvider()

    //provider2 is an object expression used to create an anonymous inner class
    //much like an onClickListener in android dev.
    val provider2 = object : PersonInfoProvider{
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "1"
    }


    provider2.printInfo(Person())
    provider2.getSessionId()
    checkTypes(provider)


}

//This function checks if infoProvider is an instance of sessionInfoProvider
fun checkTypes(infoProvider: PersonInfoProvider){
    if(infoProvider !is SessionInfoProvider){
        println("is not a session info provider")
    }else{
        println("is a session info provider")
        //The "as" keyword is used to cast types
        (infoProvider as SessionInfoProvider).getSessionId()
        infoProvider.getSessionId() //This is a smart cast
    }
}