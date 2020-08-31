package academy.learnprogramming.challenge1

fun main(args: Array<String>) {

    // Declare two immutable String variables named hello1 and hello2. Assign "Hello" to both variables.
    val hello1 = "Hello"
    val hello2: String = "Hello"

    // Using one line of code, test whether hello1 and hello2 are referentially equal and print the result.
    println(hello1 === hello2) //true
    //So what's happening here is that there is only one string literal "Hello" which means that these two Strings are
    //actually referentially equal. The JVM sees that "Hello" already exists, so sees both variables as the same.

    // Do the same thing as above, but test for structural equality.
    println(hello1 == hello2)

    // Declare a mutable variable of type Int and assign it the value of 2988
    var number = 2988
    //note this defaults to Int

    // Declare an immutable variable of type Any and assign it the string "The Any type is the root of the Kotlin class
    // hierarchy". Then, using a smart cast, print out the uppercased string.
    val thisGuy: Any = "The Any type is the root of the Kotlin class hierarchy"
    if (thisGuy is String) {
        println(thisGuy.toUpperCase())
    }

    // Using one line of code, print out the following. Make sure your code is nicely indented:
    //    1
    //   11
    //  111
    // 1111
    println("    1\n   11\n  111\n 1111") //This was the 'verbose' way. Instructor answered with:
    println("""    1
              |   11
              |  111
              | 1111""".trimMargin())

    // Extra challenge, use 1 as the trim character
    println("""1    ${1}
               1   ${11}
               1  ${111}
               1 ${1111}""".trimMargin("1"))


}