package academy.learnprogramming.trycatch

fun main(args: Array<String>) {

    println(getNumber("22.5"))

    //Can use the elvis operator to throw an exception
    println(getNumberOrNull("22.5") ?: throw IllegalArgumentException("Number isn't an Int"))

    notImplementedYet("string")
}

//try-catch can behave like an expression, just like if and when
fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        0
    } finally { //The finally block is not involved in the evaluation of a value for a try catch expression
        println("I'm in the finally block")
    }
}

fun getNumberOrNull(str: String): Int? {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        null
    } finally { //The finally block is not involved in the evaluation of a value for a try catch expression
        println("I'm in the finally block")
    }
}

//Can specify that this method will never return anything, because it will always throw an Exception.
fun notImplementedYet(something: String): Nothing {
    throw IllegalArgumentException("Implement me!")
}