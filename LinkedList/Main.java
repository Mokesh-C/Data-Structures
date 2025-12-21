package LinkedList;

public class Main {
    public static void main(String[] args) {
        //Singly Linked List Operations
        System.out.println("Singly Linked List Operations:");
        LinkedList l1 = new LinkedList();
        l1.insertFirst(10);
        l1.insertFirst(5);
        l1.insertLast(15);
        l1.insertLast(25);
        l1.insertAtIndex(20, 1);
        System.out.println(l1);

        l1.deleteFirst();
        l1.deleteLast();
        l1.deleteAtIndex(1);
        System.out.println(l1);

        l1.insertLast(55);
        l1.insertLast(85);
        l1.insertLast(95);
        System.out.println(l1);
        l1 = LinkedList.swapPairs(l1);
        System.out.println(l1);

        //Doubly Linked List Operations
        System.out.println("\nDoubly Linked List Operations:");
        DoublyLinkedList dl1 = new DoublyLinkedList();
        dl1.insertFirst(10);
        dl1.insertFirst(5);
        dl1.insertLast(15);
        dl1.insertLast(25);
        dl1.insertAtIndex(20, 1);
        dl1.display();

        dl1.deleteFirst();
        dl1.deleteLast();
        dl1.deleteAtIndex(1);
        dl1.display();
        dl1.displayReverse();

        //Circular Linked List Operations
        System.out.println("\nCircular Linked List Operations:");
        CircularLinkedList cl1 = new CircularLinkedList();
        cl1.insertFirst(10);
        cl1.insertFirst(5);
        cl1.insertFirst(45);
        cl1.insertLast(15);
        cl1.insertLast(25);
        cl1.insertAtIndex(20, 2);
        cl1.display();

        cl1.deleteFirst();
        cl1.deleteLast();
        cl1.deleteAtIndex(2);
        cl1.display();
    }
}
