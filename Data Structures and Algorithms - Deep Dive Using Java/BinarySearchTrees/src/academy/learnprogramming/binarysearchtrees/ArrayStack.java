package academy.learnprogramming.binarysearchtrees;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {

    private TreeNode[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new TreeNode[capacity];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public TreeNode peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top-1];
    }

    public TreeNode pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        TreeNode value = stack[--top];
        stack[top] = null;
        return value;
    }

    // O(n) due to the possibility (worst-case) that we need to resize the stack
    public void push(TreeNode node) {
        if (top == stack.length) {
            // need to resize the backing array
            TreeNode[] newArray = new TreeNode[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = node;
    }

    public int size() {
        return top;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "stack=" + Arrays.toString(stack) +
                ", top=" + top +
                '}';
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
