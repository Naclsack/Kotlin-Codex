//Kotlin classes are closed by default and can't be inherited from.
class FancyInfoProvider : BasicInfoProvider(){
    override val providerInfo: String
        get() = "Fancy info provider"

    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy Info")
    }
}