package academy.learnprogramming.loops

//Kotlin doesn't have the traditional Java for loop, it uses instead something called 'ranges'
fun main(args: Array<String>) {
    val range = 1..5 //inclusive. so this is 1, 2, 3, 4, 5
    for (i in range) {
        println(i)
    }

    //Any type that is comparable can be used in a range.
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ" //Cannot loop over a stringRange. Does not have an iterator method (innumerable)

    val str = "Hello"
    for (c in str) {
        println(c)
    } //The String class, however, has an iterator.

    //Use the in operator to determine if a value is in a range. All these are true:
    println(3 in range)
    println('q' in charRange)
    println("CCC" in stringRange)
    println("CCCCCC" in stringRange)

    println("ZZZZZZ" in stringRange) //false

    val backwardRange = 5.downTo(1) //can't use 5..1
    val stepRange = 3..15
    val stepThree = stepRange.step(3) //3, 6, 9, 12, 15
    val reversedRange = stepThree.reversed() //15, 12, 9, 6, 3
    for (n in reversedRange) {
        println(n)
    }

    for (num in 1..20 step 4) {
        println(num) //1, 5, 9, 13, 17
    }

    for (i in 20 downTo 15) {
        println(i) //20, 19, 18, 17, 16, 15
    }

    for (i in 20 downTo 10 step 5) {
        println(i) //20, 15, 10
    }

    for (i in 1 until 10) {
        println(i) //1, 2, 3, 4, 5, 6, 7, 8, 9
    }

    val seasons = arrayOf("spring", "summer", "winter", "fall")
    for (season in seasons) {
        println(season)
    }
    for (index in seasons.indices) {
        println("${seasons[index]} is season number $index")
    }
    seasons.forEach { println(it) }
    seasons.forEachIndexed { index, value -> println("$value is season number $index")}

    //Examples of the !in (not in) operator. These are true
    val notASeason = "whatever" !in seasons
    val notInRange = 32 !in 1..10
    val notInString = 'e' !in "Potato"

    for (i in 1..3) {
        println("i = $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
            for (k in 5..10) { //suppose we want to stop looping through k and j when k = 7
                println("k = $k")
                if (k==7) {
                    break@jloop; //This breaks both the j and k loop. Syntax works with continue as well
                }
            }
        }
    }

}