package academy.learnprogramming.nullreferences

fun main(args: Array<String>) {
    //This produces an error
    //val str: String = null;

    val str: String? = null //safety operator makes our variable nullable
    //use autocomplete to see that many functions are unusable such as .toUpperCase()
    if (str != null) {
        str.toUpperCase()
    }//This works, but there is a better way

    str?.toUpperCase() //Shorthand for the above null-check
    println("What happens when we do this: ${str?.toUpperCase()}") //This evaluates to "null"

    //Effectively, this is shorthand for:
    if (str == null) {
        null
    } else {
        str.toUpperCase()
    }

    //Can replace large null checks with the following syntax:
    val countryCode: String? = bankBranch?.address?.country?.countryCode

    //Use of the elvis operator to fall-back to a default value in the case of null:
    var str2 = str ?: "This is the default value"

    //shorthand for:
    if (str == null) {
        str2 = "This is the default value"
    } else {
        str2 = str
    }

    //Default to "US" if anything along the chain evaluates to null
    val countryCode2 = bankBranch?.address?.country?.countryCode ?: "US"

    val something: Any = arrayOf(1, 2, 3, 4)
    val str3 = something as? String //Safe-cast operator, default to null if cast cannot be performed
    println(str3) //null
    //Note that once you use the safe-cast operator, str3 is now of type String?

    var newStr : String? = "This isn't null"
    val str4 = newStr!!.toUpperCase() //This is the non-null assertion. Used when we are absolutely sure it isn't null
    //Note that this is how you get NullPointer Exceptions in Kotlin. Shorthand for:

    if (newStr == null) {
        throw exception
    } else {
        newStr.toUpperCase()
    }
    //Throws kotlin.KotlinNullPointerException. Traces to where we made the assertion, not when we try to reference it

    val str5: String? = "This isn't null"
    printText(str5) //Won't work. This function expects a non-nullable String

    str5?.let { printText(it) } //=If str5 isn't null, let this function call go ahead. bracketed is lambda expression

    val str6 : String? = null
    val anotherStr = "This isn't nullable"
    println(str6 == anotherStr) //false. Though, note that == is a safe operator by default.

    val nullableInts = arrayOfNulls<Int?>(5) //? can be removed from this declaration
    for (i in nullableInts) {
        println(i) //prints 5 nulls
    }
    nullableInts[3].toString() //This is allowed, toString() can be used on Any?
}

fun printText(text: String) {
    println(text)
}