package academy.learnprogramming.anotherpackage

import academy.learnprogramming.inheritance.CompanyCommunications as Comm
import academy.learnprogramming.inheritance.topLevel as tp
import academy.learnprogramming.inheritance.Department.*

fun main(args: Array<String>) {
    tp("Hello from another file")
    println(Comm.getCopyrightLine())
    println(IT.getDeptInfo())
    println(SALES.getDeptInfo())
}