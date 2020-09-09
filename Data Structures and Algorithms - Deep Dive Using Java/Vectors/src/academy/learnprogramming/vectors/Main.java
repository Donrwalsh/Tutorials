package academy.learnprogramming.vectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        //Better to use the interface in the declaration for easy switching of the implementation
        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

    }
}
