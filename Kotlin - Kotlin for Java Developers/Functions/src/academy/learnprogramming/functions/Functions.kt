package academy.learnprogramming.functions

//Default return type is Unit (this does not need to be specified)
//Surprisingly, this form works:
//fun main(args: Array<String>) =
//    println(labelMultiply(3, 4, "The result is:"))
fun main(args: Array<String>) {
    println(labelMultiply(3, 4, "The result is:"))
    println(labelMultiplyWithDefaultLabel(3, 4))

    //Can supply parameters out of order (called "Named Arguments"):
    println(labelMultiply(label = "here's the result:", operand2 = 3, operand1 = 4))

    var emp = Employee("Jane")
    println(emp.upperCaseFirstName())

    val car1 = Car("Blue", "Toyota", 2015)
    val car2 = Car("Red", "Ford", 2016)
    val car3 = Car("Grey", "Ford", 2017)

    printColors(car1, car2, car3)
    printColorsAgain(car1, car2, car3, str = "Color")

    val manyCars = arrayOf(car1, car2, car3)
    //printColors(manyCars) <- type mismatch error
    printColors(*manyCars) //This is just fine. The spread operator is unpacking the array to then use it as a parameter

    val moreCars = arrayOf(car2, car3)
    val car4 = car2.copy()
    val lotsOfCars = arrayOf(*manyCars, *moreCars, car4) //Another use of the spread operator
    printColors(*lotsOfCars)

    println(Utils().upperFirstAndLast("this is all in lowercase"))
    //Using the extension function
    val s = "this is all in lowercase"
    println(s.upperFirstAndLast())
}

//arbitrary number of function arguments
fun printColors(vararg cars: Car) {
    for (car in cars) {
        println(car.color)
    }
}

//Have to use named arguments because vararg is not the last param. If it were, we could get away with just ordering them the same.
fun printColorsAgain(vararg cars: Car, str: String) {
    for (car in cars) {
        println(car.color)
    }
}

//Note, no inference on function parameters. Must include the type.
fun labelMultiplyWithDefaultLabel (operand1: Int, operand2: Int,
                                   label: String = "The answer is:"): String {
    return ("$label ${ operand1 * operand2}")
}

fun labelMultiply(operand1: Int, operand2: Int, label: String): String {
    return ("$label ${ operand1 * operand2}")
}

//^ Block body,  v Expression body.

//Return type is inferred
fun labelMultiplySimpler(operand1: Int, operand2: Int, label: String) =
    "$label ${ operand1 * operand2}"

class Employee(val firstName: String) {

    fun upperCaseFirstName() = firstName.toUpperCase()

}

data class Car(val color: String, val model: String, val year: Int) {

}

//Extension function. Associate this function with the String class, and no longer need String as a parameter.
//This is all an illusion, String is still being passed as a parameter.
fun String.upperFirstAndLast() : String {
    val upperFirst = this.substring(0, 1).toUpperCase() + this.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}
//Even further, you can just remove the 'this' keyword:
fun String.upperFirstAndLastBetter() : String {
    val upperFirst = substring(0, 1).toUpperCase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

//inline function. For an inline function, the function body wil be directly generated into the byte code wherever the
//function is called rather than having a function call. keyword goes before the 'fun' keyword:
inline fun labelMultiplyWithDefaultLabelNew (operand1: Int, operand2: Int,
                                   label: String = "The answer is:"): String {
    return ("$label ${ operand1 * operand2}")
}