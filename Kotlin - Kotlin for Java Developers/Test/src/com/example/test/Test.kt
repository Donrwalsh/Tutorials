package com.example.test

fun main(args: Array<String>) {
    //These invocations are all identical
    area(10, 20)
    area(width = 10, height = 20)
    area(height = 20, width = 10)
}

fun area(width: Int, height: Int) {
    println("width = $width and height = $height")
}