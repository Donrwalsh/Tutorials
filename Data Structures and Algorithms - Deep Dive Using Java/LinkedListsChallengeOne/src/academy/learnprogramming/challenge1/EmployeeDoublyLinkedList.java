package academy.learnprogramming.challenge1;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        if (head == null) {
            tail = node;
        }
        else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (tail == null) {
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
        // return true if you were able to successfully add the employee
        // into the list before the existing employee. Return false
        // if the existing employee doesn't exist in the list

        // add your code here
        EmployeeNode scanner = head;
        while (scanner != null && scanner.getEmployee() != existingEmployee) {
            scanner = scanner.getNext();
        }
        if (scanner != null) {
            EmployeeNode scannerPrevious = scanner.getPrevious();
            EmployeeNode newNode = new EmployeeNode(newEmployee, scannerPrevious, scanner);
            if (scannerPrevious != null) {
                scannerPrevious.setNext(newNode);
            }
            scanner.setPrevious(newNode);
            if (scanner == head) {
                head = newNode;
            }
        }
        return scanner != null;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        }
        else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        }
        else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
