package academy.learnprogramming.accessmodifiers

val MY_CONSTANT = 100

//For top-level items:
//Access Modifier | Kotlin                         | Java
// private        | Visible within the same file   | Can't be used
// protected      | Can't be used                  | Can't be used
// public         | Visible everywhere             | Visible everywhere
// internal       | Visible within the same module | N/A

fun main(args: Array<String>) {

    println(MY_CONSTANT)

    //All classes are public and final by default in Kotlin
    val emp = EmployeeLongWay("John")
    println(emp.firstName)

    val emp2 = EmployeeShorterWay("Jane")
    println(emp2.firstName)

    val emp3 = Employee("Geralt")
    println(emp3.firstName)

    val emp4 = Employee("Joe")
    println(emp4.firstName)
    println(emp4.fullTime)

    val emp5 = Employee("Samantha", false)
    println(emp5.firstName)
    println(emp5.fullTime)

    val emp6 = Employee("Todd", false)
    emp6.fullTime = true //Public properties in Kotlin, you get getters/setters for free
    println(emp6.firstName)
    println(emp6.fullTime)

    println(Demo().dummy)

    //Setting a class attribute as private means you cannot modify it from outside the class.
    //These ~~~.firstName calls are hitting getters/setters behind the scenes.

    val car = Car("Blue", "Toyota", 2015)
    println(car) //Car(color=blue, model=Toyota, year=2015) by default
    val car2 = Car("Blue", "Toyota", 2015)
    println(car == car2) //true. equals method comes for free in data class
    val car3 = car.copy()
    println(car3) //copy method for free too
    val car4 = car.copy(year = 2016) // Copy everything as is from car, but set the year to 2016
}

//Data classes come with some helpful default functions
data class Car(val color: String, val model: String, val year: Int) {

}

class CustomSettersGettersEmployee(val firstName: String, fullTime: Boolean = true) {

    var fullTime = fullTime
    get() {
        //This is silly
        println("Running the custom get")
        //This is called the 'backing field'
        return field
    }
    set(value) {
        println("Running the custom set")
        field = value
    }
}

//Totally fine to not have a primary constructor.
class Demo {
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}

class BetterEmployee(val firstName: String, var fullTime: Boolean = true) {

}

//Constructor signature doubling as property declaration.
//Can omit the constructor keyword entirely unless you want to make the constructor something other than public
class Employee(val firstName: String) {

    var fullTime: Boolean = true

    //Secondary constructors do not declare properties for us
    constructor(firstName: String, fullTime: Boolean): this(firstName) {
        this.fullTime = fullTime
    }

}

class EmployeeShorterWay constructor(firstName: String) {

    val firstName: String = firstName
}

//Kotlin has a notion of 'primary constructor'
class EmployeeLongWay constructor(firstName: String) {

    val firstName: String

    //Initializer block runs when an instance is created. Runs in conjunction with the primary constructor
    init {
        this.firstName = firstName
    }
}

