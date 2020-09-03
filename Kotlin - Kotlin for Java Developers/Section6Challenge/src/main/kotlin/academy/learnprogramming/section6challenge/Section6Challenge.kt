package academy.learnprogramming.section6challenge

fun main(args: Array<String>) {

    //1. Print out the numbers 5, 10, 15, 20, ..., 5000 using a range
//    for (num in 5..5000 step 5) {
//        println(num)
//    }

    //2. Print out the numbers -500, -499, -498, ...., 0 using a range
//    for (num in -500..0) {
//        println(num)
//    }

    //3. Using a range print the first 15 numbers in the fibonacci sequence
    var a = 0
    var b = 0
    for (num in 1..15) {
        when(num) {
            1 -> b = 0
            2 -> b = 1
            else -> {
                val mem = a
                a = b
                b += mem
            }
        }
        println(b)
    }

    //4. Maintaining the following loop structure, output 1, 11, 100, 99, 98, 2
    iloop@ for (i in 1..5) {
        println(i)
        if (i == 2) break@iloop
        jloop@ for (j in 11..20) {
            println(j)
            for (k in 100 downTo 90) {
                println(k)
                if (k == 98) break@jloop
            }
        }
    }

    //5. Declare a variable called num (int) and assign it whatever you want
    // Declare a variable called dnum (double) and assignit as follows:
    // if num is > 100, assign dnum -234.567
    // if num is < 100, assign dnum 4444.555
    // if num == 100, assign dnum 0.0
    // do all of the above in one statement/expression
    // Then print the value of dnum - separate statement
    var num: Int = 4

    var dnum: Double = when {
        num > 100 -> -234.567
        num < 100 -> 4444.555
        else -> 0.0
    }
    println(dnum)

}