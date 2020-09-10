package academy.learnprogramming.queueschallenge;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        boolean isPalindrome = true;
        LinkedStack stack = new LinkedStack();
        ArrayQueue arrayQueue = new ArrayQueue(10);
        String modifiedString = string.replaceAll("[^a-zA-Z]", "");
        modifiedString = modifiedString.toLowerCase();

        for (int i = 0; i < modifiedString.length(); i++) {
            stack.push(modifiedString.charAt(i));
            arrayQueue.add(modifiedString.charAt(i));
        }

        while (arrayQueue.size() != 0) {
            if (stack.pop() != arrayQueue.remove()) {
                isPalindrome = false;
            }
        }

        return isPalindrome;
    }
}
