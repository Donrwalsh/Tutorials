package academy.learnprogramming.jdklinkedlists;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        list.add(billEnd);

        list.removeFirst();

        Iterator iter = list.iterator();
        System.out.print("Head -> ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print("<=>");
        }
        System.out.println("null");
    }
}
