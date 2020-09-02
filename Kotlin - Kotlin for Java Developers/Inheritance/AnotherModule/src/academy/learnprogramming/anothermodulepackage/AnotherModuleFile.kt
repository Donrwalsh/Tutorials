package academy.learnprogramming.anothermodulepackage

import academy.learnprogramming.inheritance.topLevel

//This is a new module that wants to access the 'topLevel()' method, but cannot by default until we add the containing
//module as a dependency.
//Rightclick on module > Open Module Settings > Dependencies > Add dependency (in this case, 'Inheritance')
fun main(args: Array<String>) {
    topLevel("Hello from another module")
    //I am desynced from the instructors structure somehow, I don't have this extension function:
    //println("a string to work with".upperFirstAndLast())
}