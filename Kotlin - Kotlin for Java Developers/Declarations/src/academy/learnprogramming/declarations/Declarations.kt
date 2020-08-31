package academy.learnprogramming.declarations

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {
    val number = 25
    val numberTypeNoValue: Int
    val thisFormIsGenerallyNotUsed: Int = 25
    val unlessWeNeedToSpecifyType: Short = 25

    numberTypeNoValue = 10
    //Error because it is an immutable val:
    //numberTypeNoValue = 20

    var mutableNumber: Int

    mutableNumber = 10
    mutableNumber = 20
    //val is preferred over var when possible.

    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"
    //Note that the immutable employee1 has attributes that are mutable. Neat.

    val employee2: Employee
    val number2 = 100

    if (number < number2) {
        employee2 = Employee("Jane Smith", 400)
    } else {
        employee2 = Employee("Mike Watson", 150)
    }

    //number = "hello"
    //Can't do this. number has already been declared as an Int (even though it is inferred)

    //StringBuilder is an alias for Java.Lang.StringBuilder. Kotlin does not have its own StringBuilder class.

    val employees: EmployeeSet
    //Note the typealias declaration at the top of this file

    val names = arrayListOf("John", "Jane", "Mary")
    println(names[1])
    //Reference collection element via square brackets.

    //Note that Kotlin has its own String class, it does not use Java.lang.String class.

    //Kotlin does not distinguish between checked and unchecked exceptions.

    //Ternaries do not exist in Kotlin. :( Also gone are the original for loop, the static and new keywords

    val employeeOne = Employee("Mary", 1)
    val employeeTwo = Employee("John", 2)
    val employeeThree = Employee("John", 2)

    println(employeeOne == employeeTwo) //false
    println(employeeTwo == employeeThree) //true
    println(employeeOne.equals(employeeTwo)) //false
    println(employeeTwo.equals(employeeThree)) //true
    //In kotlin the .equals operate checks for structural equality not referential equality, unlike Java. Use ==.

    val employeeFour = employeeTwo
    println(employeeFour === employeeTwo) //true
    println(employeeTwo === employeeThree) //false
    //=== performs referential equality.

    val something: Any = employeeFour
    if (something is Employee) {
        val castedEmployee = something as Employee
        println(castedEmployee.name)
        //That being said, no cast is needed here. Kotlin does smart casting after an is check.
        //Because of this smart casting, you cannot take the something variable and assign a non-Employee value.
    }

    println(employee1)

    val change = 4.22
    println("To show the value of change, we use \$change") //example of escaping the string template

    val numerator = 10.99
    val denominator = 20.00
    println("The value of $numerator divided by $denominator is ${numerator / denominator}") //expression substitution

    println("The employee's id is ${employee1.id}") //referencing out-of-class attributes requires an expression

    //Raw strings:
    val filePath = """c:\somedir\somedir2""" //no need to escape chars in the string.
    val nurseryRhyme = """Humpty Dumpty sat on the wall
        |Humpty Dumpty had a great fall
        |All the king's horses and all the king's men
        |Couldn't put Humpty together again
    """.trimMargin() //Spacing+trimMargin() gets added automatically, neat.
    println(nurseryRhyme)

    val eggName = "Humpty"
    val nurseryRhymeWithSubstitution = """$eggName Dumpty sat on the wall
        |$eggName Dumpty had a great fall
        |All the king's horses and all the king's men
        |Couldn't put $eggName together again
    """.trimMargin()

    //Tools > Kotlin > Kotlin REPL. console where you can spot-check code
}

class Employee(var name: String, val id: Int) {

    override fun equals(obj: Any?): Boolean {
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }

        return false
    }

    //easily made by right-clicking -> Generate toString() method.
    override fun toString(): String {
        return "Employee(name=$name, id=$id)" //$name is known as a string template
    }


}