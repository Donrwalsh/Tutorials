package academy.learnprogramming.stackschallenge;

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
        String modifiedString = string.replaceAll("[^a-zA-Z]", "");
        modifiedString = modifiedString.toLowerCase();

        for (int i = 0; i < modifiedString.length() /2; i++) {
            stack.push(modifiedString.charAt(i));
        }
        int midPoint = modifiedString.length() % 2; //If there is a midpoint character, we can skip it entirely.
        for (int j = midPoint + (modifiedString.length() / 2); j < modifiedString.length(); j++ ) {
            if (stack.pop() != modifiedString.charAt(j)) {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }
}
