package academy.learnprogramming.arraylists;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Some basic tinkering with the ArrayList class.

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.get(1));

        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee("John", "Adams", 4568));

        employeeList.add(3, new Employee("John", "Doe", 4567));

        employeeList.forEach(employee -> System.out.println(employee));

        //Get the backing array:
        Object[] employeeArray = employeeList.toArray();

        //Get the backing array as an array of Employees:
        Employee[] actualEmployeeArray = employeeList.toArray(new Employee[employeeList.size()]);

        //Requires the 'equals' method to be implemented for Employee class, otherwise we're checking instance equality.
        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22)));

        //This also requires 'equals', which makes sense.
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));

        //Note that this can be computationally expensive because of the backing array data structure.
        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));


    }
}
