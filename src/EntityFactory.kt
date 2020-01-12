import java.util.*

interface IdProvider{
    fun getId(): String
}

//Enum classes can be used to represent different Entity Types
enum class EntityType{
    EASY, MEDIUM, HARD

    fun getFormattedName()= name.toLowerCase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType) : Entity{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.getFormattedName() //type.getFormattedName returns the name of the class i.e "EASY" but to lower case
            EntityType.MEDIUM -> "Medium"
            EntityType.HARD -> "Hard"
        }
        return Entity(id, name)
    }
}

sealed class Entity(){

    object Help{
        val name = "Help"
    }

    data class Easy(val id: String, val name:String):Entity()
    data class Medium(val id: String, val name:String):Entity()
    data class Hard(val id: String, val name:String, val multiplier: Float):Entity()
}

/*class Entity(val id: String, val name: String){

    //Companion Object can implement interfaces
    companion object Factory: IdProvider{

        override fun getId(): String {
            return "123"
        }

        fun create() = Entity("id", "Aaron")
    }

    override fun toString(): String {
        return "id:$id name:$name"
    }

}*/



fun main(){
    //This will not compile if the constructor is private, this can be solved by companion objects
    val easyEntity = EntityFactory.create(EntityType.EASY)
    println(easyEntity)

    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)

}