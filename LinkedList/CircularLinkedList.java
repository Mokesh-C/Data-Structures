package LinkedList;

public class CircularLinkedList {
    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node (int data , Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertFirst(int data){
        Node newNode  = new Node(data);
        newNode.next = head;
        if(head == null){
            tail = newNode;
            tail.next = tail;
        } else{
            tail.next = newNode;
        }
        head = newNode;
        size++;
    }

    public void insertLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            insertFirst(data);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
        size++;
    }

    public void insertAtIndex(int data, int index){
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
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        Node newNode = new Node(data, temp.next);
        temp.next = newNode;
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
            tail.next = head;
        }
        size--;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
        size--;

    }

    public void deleteAtIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
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
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void display(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }while (temp != head);
        System.out.println("(head)");
    }

}
