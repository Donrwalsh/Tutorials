package academy.learnprogramming.ifexpression

//Big difference in Kotlin is that if statements can return a value
fun main(args: Array<String>) {

    val someCondition = 69 < 22

    //Ternary equivalent in Kotlin:
    val num = if (someCondition) 50 else 592

    //Returning values with an if expression. Value must be last statement in each block.
    //Note that using if as an expression in this way requires the presence of an else block.
    val num2 = if (someCondition) {
        println("something")
        50
    } else {
        println("something else")
        592
    }

    //Printing if statements
    println(if (someCondition) {
        50
    } else {
        592
    })

    //Can use an if expression in a string template:
    println("The result of the if expression is ${if (someCondition) {
        50
    } else {
        592
    }}")
}