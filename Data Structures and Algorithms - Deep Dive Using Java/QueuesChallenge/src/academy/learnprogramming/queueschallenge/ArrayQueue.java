package academy.learnprogramming.queueschallenge;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Character[] queue;
    private int front;
    private int back; //represents the next available position

    public ArrayQueue(int capacity) {
        queue = new Character[capacity];
    }

    public void add(Character character) {
        //Resize logic that avoids indexOutOfBounds. Note the issue here that there may be empty unused slots at the
        //front of the array that we are not taking advantage of (unless remove resets these values for us)
        if (back == queue.length) {
            Character[] newArray = new Character[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = character;
        back++;
    }

    public char peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public Character remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Character character = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return character;
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

}
