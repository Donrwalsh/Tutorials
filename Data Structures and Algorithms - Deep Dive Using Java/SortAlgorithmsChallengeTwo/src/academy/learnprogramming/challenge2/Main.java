package academy.learnprogramming.challenge2;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        insertionSort(intArray, 1);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void insertionSort(int[] input, int unsortedIndex) {
        if (unsortedIndex == input.length) {
            return;
        }
        int newElement = input[unsortedIndex];

        int i;

        for (i = unsortedIndex; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

        insertionSort(input, unsortedIndex+1);
    }
}
