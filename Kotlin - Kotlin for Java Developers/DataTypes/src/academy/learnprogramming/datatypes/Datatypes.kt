package academy.learnprogramming.datatypes

import academy.learnprogramming.javacode.DummyClass
import java.math.BigDecimal

fun main(args: Array<String>) {
    // === Primitives ===
    val myInt = 10 //Ints are default data type for integers
    println(myInt is Int) //true
    var myLong = 22L //L character makes this a long
    println(myLong is Long) //true

    //Kotlin does not widen integers, i.e. cannot assign an int to a long without handling the conversion
    myLong = myInt.toLong()

    val myByte: Byte = 111
    var myShort: Short
    myShort = myByte.toShort()

    var myDouble = 65.984 //Doubles are default data type for non-integer numbers
    println(myDouble is Double) //true

    val myFloat = 838.8492f //f character makes this a float
    println(myFloat is Float) //true

    val char = 'b' //this will default to char data type.
    //Cannot use integer declaration for chars like in Java. Must do something like this instead:
    val myCharInt = 65
    println(myCharInt.toChar()) //A

    val myBoolean = true //Nothing surprising with Booleans

    //Since there are no primitives in Kotlin, what if a Java class expects a boolean parameter?
    val vacationTime = false
    val onVacation = DummyClass().isVacationTime(vacationTime)
    println(onVacation) //"I'm Working"
    //This works because Kotlin compiles down to primitive data types. Super cool.

    val anything: Any
    //Any as discussed before is the superclass of all classes in Kotlin.
    //Kotlin uses the 'Unit' class in the place of void. There is no way to return nothing in Kotlin.
    //There is also the 'Nothing' class which is a subclass of any class.

    // === Arrays ===
    //Note that arrays are actually collections
    val names = arrayOf("John", "Jane", "Jill", "Joe")

    val longs1 = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf<Long>(1, 2, 3, 4)
    val longs3 = arrayOf(1, 2, 3, 4) //Note how this makes an array of Ints

    println(longs1 is Array<Long>) //true
    println(longs2 is Array<Long>) //true
    println(longs3 is Array<Int>) // true

    val evenNumbers = Array(16) { i -> i * 2} //Lambda expression
    for (number in evenNumbers) {
        println(number) //Even numbers from 0 to 30
    }

    val lotsOfNumbers = Array(100000) {i -> i + 1} //Integers from 1 to 100,000

    val allZeroes = Array(100) { 0 } //100 zeroes

    var someArray: Array<Int> //Needs explicit type since we are not initializing values here
    someArray = arrayOf(1, 2, 3, 4)
    someArray = Array(6) {i -> (i + 1) * 10 }

    val mixedArray = arrayOf("hello", 22, BigDecimal(10.5), 'a')
    for (element in mixedArray) {
        println(element) //works just fine
    }
    println(mixedArray is Array<Any>) //true

    val myIntArray = arrayOf(3, 9, 434, 2, 33)
    //DummyClass.printNumbers(myIntArray)
    //This gives a type mismatch because printNumbers expects a primitive array of ints.

    val worksMyIntArray = intArrayOf(3, 9, 434, 2, 33)
    DummyClass.printNumbers(worksMyIntArray) //This works just fine, note the intArrayOf change.

    //This fails. We cannot specify the size without values
    //var someOtherArray = Array<Int>(5)

    var someOtherArray = IntArray(5) //this works. Gets initialized with the primitive type's default value

    //There is apparently an empty array function that creates an array that you cannot add any values to. . .odd

    DummyClass.printNumbers(evenNumbers.toIntArray()) //Can convert on the fly if needed.

    val convertedIntArray: Array<Int> = someOtherArray.toTypedArray() //Other direction conversion works as well

}