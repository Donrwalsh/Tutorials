package academy.learnprogramming.hashtable;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        SimpleHashtable ht = new SimpleHashtable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith); //Causes a collision since 5 character last name has been occupied.

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));

        LessSimpleHashtable ht2 = new LessSimpleHashtable();
        ht2.put("Jones", janeJones);
        ht2.put("Doe", johnDoe);
        ht2.put("Wilson", mikeWilson);
        ht2.put("Smith", marySmith); //No longer causes a collision due to LessSimpleHashTable's Linear Probing.

        ht2.printHashtable();

        System.out.println("Retrieve key Smith: " + ht2.get("Smith"));

        ht2.remove("Wilson");
        ht2.remove("Jones");
        ht2.printHashtable();
    }
}
