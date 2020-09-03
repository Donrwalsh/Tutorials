package academy.learnprogramming.whenpkg

import java.math.BigDecimal

enum class Season {
    SPRING, SUMMER, FALL, WINTER
}

fun main(args: Array<String>) {

    val timeOfYear = Season.WINTER
    val str = when (timeOfYear) {
        Season.SPRING -> "Flowers are blooming"
        Season.SUMMER -> "It's hot!"
        Season.FALL -> "It's getting cooler"
        Season.WINTER -> "I need a coat"
    } //Despite returning a value, we do not need an else statement. This is because we are being exhaustive of the enum
    println(str)

    val num = 200

    //Note the lack of break statements. We can't have intentional fall-through in these statements. One branch only.
    when (num) {
        100, 600 -> println("100") //Do this for either 100 or 600
        in 200..299 -> println("200") //Do this for any value in the range
        300 -> println("300")
        else -> println("Doesn't match anything")
    }

    val y = 10

    //Use expressions:
    when (num) {
        y + 80 -> println(90)
        y + 90 -> println(100)
    }

    //Remember smart-casting?

    val obj: Any = "I'm a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45

    val something: Any = obj2

    when (something) {
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
        is Int -> println("${something - 22}")
    }

    //Just like the if expression, we can do this:
    val z = when (something) {
        is String -> {
            println(something.toUpperCase())
            1
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            2
        }
        is Int -> {
            println("${something - 22}")
            3
        }
        else -> {
            println("I have no idea what type this is")
            -1
        }
    }
    println(z)

    val num2 = -50

    //IDE suggests cascade if should be replaced with when
    if (num < num2) {
        println("num is less than num2")
    } else if (num > num2) {
        println("num is greater than num2")
    } else {
        println("num is equal to num2")
    }

    //This is equivalent to the above. Awesome.
    when {
        num < num2 -> println("num is less than num2")
        num > num2 -> println("num is greater than num2")
        else -> println("num is equal to num2")
    }
}