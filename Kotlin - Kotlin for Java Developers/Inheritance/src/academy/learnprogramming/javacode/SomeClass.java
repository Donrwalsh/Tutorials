package academy.learnprogramming.javacode;

public class SomeClass {

    private static int privateVar = 6;

    public static void main(String[] args) {
        new SomeOtherClass().someOtherMethod();
    }

    public static void accessPrivateVar() {
        System.out.println("I'm accessing privateVar: " + privateVar);
    }

}
