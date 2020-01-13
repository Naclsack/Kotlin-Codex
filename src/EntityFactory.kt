import java.util.*

interface IdProvider{
    fun getId(): String
}

//Enum classes can be used to represent different Entity Types
enum class EntityType{
    EASY, MEDIUM, HARD, HELP;

    fun getFormattedName()= name.toLowerCase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType) : Entity{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.getFormattedName() //type.getFormattedName returns the name of the class i.e "EASY" but to lower case
            EntityType.MEDIUM -> "Medium"
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when(type){
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name)
            EntityType.HELP -> Entity.Help
        }
    }
}

sealed class Entity(){

    object Help : Entity(){
        val name = "Help"
    }

    data class Easy(val id: String, val name:String):Entity(){}
    data class Medium(val id: String, val name:String):Entity()
    data class Hard(val id: String, val name:String):Entity()
}

//Extension methods and properties are useful for adding properties and methods to existing classes

//This is an extension method
fun Entity.Medium.printInfo(){
    println("Medium class $id")
}
//Extension property
val Entity.Medium.info: String
    get() = "some info"

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
    val entity:Entity = EntityFactory.create(EntityType.EASY)
    val msg = when (entity){
        //Help is an object reference and doesn't need an "is"
        Entity.Help -> "Help Class"
        is Entity.Easy -> "Easy Class"
        is Entity.Medium -> "Medium Class"
        is Entity.Hard -> "Hard Class"
    }

    println(msg)

    //They are not equal because they are assigned a random ID at instantiation via the random ID function
    val entity1 = Entity.Medium("id", "name")
    val entity2 = EntityFactory.create(EntityType.MEDIUM)
    //copy() can be used to make copies of objects with different attribute values
    //i.e. copy(name = "Aaron") will make a copy of the object with a new name
    val entity3 = entity1.copy()

    // "===" is a referential comparison, it check if objects are the exact same object, or just share the same data
    if(entity1 === entity3){
        println("They are equal")
    }else{
        println("They are not equal")
    }

    Entity.Medium("Id", "name").printInfo()
    if(entity1 is Entity.Medium){
        entity1.printInfo()
        entity1.info
    }


}

