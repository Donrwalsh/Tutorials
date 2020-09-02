package academy.learnprogramming.inheritance

import java.time.Year

fun main(args: Array<String>) {
    println(CompanyCommunications.getTagLine()) //singleton is created the first time it is used, here.
    println(CompanyCommunications.getCopyrightLine())

    println(SomeClass2.Companion.accessPrivateVar()) //Could remove "Companion" and be equivalent

    val someClassOne = SomeClass3.justAssign("This is the string as is")
    val someClassTwo = SomeClass3.upperOrLowerCase("This isn't the string as is", false)
    println(someClassOne.someString)
    println(someClassTwo.someString)

    //Anonymous object example. Note that the instance created here is not a singleton. It is used and then discarded.
    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int) =
            "This is from mustImplement: ${num * 100}"
    })

    //Unlike Java, the object expression can access variables outside the code block even when they are not final
    var thisIsMutable = 45
    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int): String {
            thisIsMutable++
            return "This is from mustImplement: ${num * 100}"
        }
    })
    println(thisIsMutable)

    println(Department.ACCOUNTING.getDeptInfo())
}

//Note the 'enum class' difference
enum class Department(val fullName: String, val numEmployees: Int) {
    HR("Human Resources", 5),
    IT("Information Technology", 10),
    ACCOUNTING("Accounting", 3),
    SALES("Sales", 20); //*gasp*

    fun getDeptInfo() = "The $fullName department has $numEmployees employees"
}

fun topLevel(str: String) = println("Top level functoin: $str")

//Singletons in Kotlin use the 'object' keyword for allowing one and only one instance of a class.
//Object declares and creates an object at the same time. no constructors allowed or needed
object CompanyCommunications {

    val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."

}

//This is not equivalent to the java version of SomeClass due to the lack of static keyword in Kotlin
class SomeClass {
    private val privateVar = 6

    fun accessPrivateVar() {
        println("I'm accessing privateVar: $privateVar")
    }
}

class SomeClass2 {
    //Consider everything inside the companion object as static. We can call contained functions without needing an
    //instance of this class (see above) Can also name companion objects
    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"
    }
}

//Using companion to implement the Factory pattern. No constructor is available from outside the class, you have to call
//either justAssign or upperOrLowerCase within the companion object.
class SomeClass3 private constructor(val someString: String) {

    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"

        fun justAssign(str: String) = SomeClass3(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean) : SomeClass3 {
            if (lowerCase) {
                return SomeClass3(str.toLowerCase())
            } else {
                return SomeClass3(str.toUpperCase())
            }
        }
    }
}

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from watsSomeInterface ${si.mustImplement(22)}")
}