package academy.learnprogramming.challenge2;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
        // add your code here
        //Note that this code makes the assumption that the list is already sorted.
        IntegerNode scanner = head;
        if (scanner == null || scanner.getValue() > value) {
            addToFront(value);
        } else {
            while(true) {
                if (scanner.getNext() != null && scanner.getNext().getValue() < value) {
                    scanner = scanner.getNext();
                } else {
                    IntegerNode newNode = new IntegerNode(value);
                    newNode.setNext(scanner.getNext());
                    scanner.setNext(newNode);
                    break;
                }
            }

        }

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
