package academy.learnprogramming.hashtableschallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        HashMap<Integer, Employee> map = new HashMap<>();
        List<Employee> removeEmployees = new ArrayList<Employee>();
        employees.forEach(e -> {
            if (map.put(e.getId(), e) != null) {
                removeEmployees.add(e);
            }
        });
        removeEmployees.forEach(e -> employees.remove(e));


        employees.forEach(e -> System.out.println(e));



//        int[] nums = new int[10];
//        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
//        for (int i = 0; i < numsToAdd.length; i++) {
//            nums[hash(numsToAdd[i])] = numsToAdd[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}
