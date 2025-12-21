package LinkedList;

public class DoublyLinkedList {

    private static class Node{
        private int data;
        private Node next;
        private Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node (int data , Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        if(head == null){
            tail = newNode;
        } else{
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    public void insertLast(int data){
        Node newNode = new Node (data);
        if(head == null){
            insertFirst(data);
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertAtIndex(int data , int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if(index == 0){
            insertFirst(data);
            return;
        }
        if(index == size){
            insertLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        temp = newNode.next;
        temp.prev = newNode;
        size++;
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if(head == null){
            tail = null;
        } else{
            head.prev = null;
        }
        size--;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        tail = tail.prev;
        if(tail == null){
            head = null;
        } else{
            tail.next = null;
        }
        size--;
    }

    public void deleteAtIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == size - 1){
            deleteLast();
            return;
        }

        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;

    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayReverse(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}
