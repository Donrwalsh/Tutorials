package academy.learnprogramming.inheritance

fun main(args: Array<String>) {
    val laserPrinter = LaserPrinter("Brother 1234", 15)
    laserPrinter.printModel()

    SomethingElse("whatever")
}

//Recall that all classes in Kotlin are public and final by default
//Use "open" to make this class available for extension. abstract makes 'open' redundant
abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this printer is $modelName")
    abstract fun bestSellingPrice(): Double

}

//Constructor signatures need not match
open class LaserPrinter(modelName: String, ppm: Int): Printer(modelName) {

    //Note that override also means open. Subclasses can continue to override an override function. prevent this by
    //using the 'final' keyword
    final override fun printModel() = println("The model name of this laser printer is $modelName")
    override fun bestSellingPrice(): Double = 129.99

}

class SpecialLaserPrinter(modelName: String) : LaserPrinter(modelName, 15) {

    //cannot do this because of the use of final above
    //override fun printModel() = println("this is my way of doing it")
}

//Note that you cannot delegate to a secondary constructor for a class that has a primary constructor
//The following only works because class Something has no primary constructor. Adding one breaks everything
open class Something {

    val someProperty: String

    constructor(someParameter: String) {
        someProperty = someParameter
        println("I'm in the parent's constructor")
    }
}

class SomethingElse: Something {

    constructor(someOtherParameter: String): super(someOtherParameter) {
        println("I'm in the child's constructor")
    }
}

//data classes cannot be open. They are closed tight, they cannot be abstract or inner classes.
//They can extend other classes. Restrictions on data classes have been relaxed before, perhaps more relaxation to come.
data class DataClass(val number: Int) {

}

interface MyInterface {

    val number: Int //This is fine, but you cannot use a property initializer to make this concrete
    val number2: Int
        get() = 45 //This is how to do the concrete implementation. Can't use 'field' here, there is no backing field

    fun MyFunction(str: String) : String

}

interface MySubInterface: MyInterface {

    fun mySubFunction(num: Int): String
}

class SomethingElseElse: MySubInterface {

    override val number: Int = 25

    override fun MyFunction(str: String): String {
        return "This is MyFunction"
    }

    override fun mySubFunction(num: Int): String {
        return "This is MySubFunction"
    }
}