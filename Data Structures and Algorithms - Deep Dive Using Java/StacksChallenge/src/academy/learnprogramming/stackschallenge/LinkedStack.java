package academy.learnprogramming.stackschallenge;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {

    private LinkedList<Character> stack;

    public LinkedStack() {
        stack = new LinkedList<Character>();
    }

    public void push(Character character) {
        stack.push(character);
    }

    public Character pop() {
        return stack.pop();
    }

    public Character peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Character> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}