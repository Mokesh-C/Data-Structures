package LinkedList;

public class LinkedList {
    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public Node(int data , Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int data){
        Node newNode = new Node(data);
        if(tail == null){
            insertFirst(data);
            return;
        }
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
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteFirst(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
    }

    public void deleteLast(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        if(head == tail){
            deleteFirst();
            return;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
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
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        Node temp = head;
        while(temp != null){
            str.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        str.append("null");
        return str.toString();
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public  static LinkedList swapPairs (LinkedList list){
        Node dummy = new Node(0);
        dummy.next = list.head;
        Node current = dummy;

        while(current.next != null && current.next.next != null){
            Node first = current.next;
            Node second = current.next.next;

            first.next = second.next;
            second.next = first;
            current.next = second;

            current = first;
        }
        list.head = dummy.next;
        return list;
    }

}
