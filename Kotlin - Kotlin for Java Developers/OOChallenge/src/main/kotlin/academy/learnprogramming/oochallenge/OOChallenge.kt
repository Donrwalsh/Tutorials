package academy.learnprogramming.oochallenge

import academy.learnprogramming.javacode.MountainBike

fun main(args: Array<String>) {
    //6.Make an instance of each bike, and then call the printDescription function for each instance
    val bicycle = KotlinBicycle(10, 20, 5)
    val mountainBike = KotlinMountainBike(3, 10, 20, 5)
    val roadBike = KotlinRoadBike(12, 10, 20, 5)
    bicycle.printDescription()
    mountainBike.printDescription()
    roadBike.printDescription()

    //7. Then make a new instance of each bike without passing the gear value
    val bicycle2 = KotlinBicycle(10, 20)
    val mountainBike2 = KotlinMountainBike(3, 10, 20)
    val roadBike2 = KotlinRoadBike(12, 10, 20)
    bicycle2.printDescription()
    mountainBike2.printDescription()
    roadBike2.printDescription()

    val mountainBikeWithColor = KotlinMountainBike( "Blue", 3, 10, 20)

    //9. Then print the list of colors here
    KotlinMountainBike.availableColors.forEach { println(it)}
}

//1. Convert the Bicycle.java class to a Kotlin class
//Set this to open as part of 2.
//7. Make the gear parameter optional with a default value of 10 (no need to use nullable values here)
open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    //4. Add the printDescription method to the KotlinBicycle class in a Kotlin-esque manner
    //Set this to open as part of 5.
    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence travelling at a speed of $speed.")
    }
}

//2. Convert the MountainBike.java class to a Kotlin class
class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10) : KotlinBicycle(cadence, speed, gear) {

    //8. Add a secondary constructor that accepts a "Color" parameter which all it does is print out the color param
    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10): this(seatHeight, cadence, speed, gear) {
        println(color)
    }

    //5. Add the associated printDescription method here
    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches.")
    }

    //9. Make a companion object. List<String> called availableColors.
    //Initialize the list to "blue", "red", "white", "black", "green", and "brown"
    companion object {
        val availableColors = listOf("blue", "red", "white", "black", "green", "brown")
    }
}

//3. Convert the RoadBike.java class to a Kotlin class
class KotlinRoadBike (val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 10) : KotlinBicycle(cadence, speed, gear) {

    //5. Add the associated printDescription method here
    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth MM.")
    }
}