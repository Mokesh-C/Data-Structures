package Trees;

public class BST {
    private class Node{
        private int data;
        private Node left, right;
        private int height;

        public Node(int data){
            this.data = data;
        }
    }
    private Node root;

    public BST(){
        this.root = null;
    }
    public BST(int[] arr){
        for(int data : arr){
            insert(data);
        }
    }

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null) return 0;
        return node.height;
    }

    public void insert(int data){
        root = insert(root, data);
    }

    public Node insert(Node node, int data){
        if(node == null) return new Node(data);

        if(data < node.data){
            node.left = insert(node.left, data);
        } else if(data > node.data){
            node.right = insert(node.right, data);
        }
        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

    public boolean search(int data){
        return search(root, data);
    }

    private boolean search(Node node, int data){
        if(node == null) return false;
        if(data == node.data) return true;
        return data < node.data ? search(node.left, data) : search(node.right, data);
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node node, int data) {
        if(node == null) return null;

        if(data < node.data){
            node.left = delete(node.left, data);
        } else if(data > node.data){
            node.right = delete(node.right, data);
        } else{
            // Node with only one child or no child
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.data = minValue(node.right);
            // Delete the inorder successor
            node.right = delete(node.right, node.data);
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }
    private int minValue(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public void display(){
        display(root, 0);
    }

    private void display(Node node, int level){
        if(node == null) return;
        display(node.right, level + 1);

        if(level != 0){
            for(int i = 1; i < level; i++)
                System.out.print("|\t\t");
            System.out.println("|------>" + node.data);
        } else {
            System.out.println(node.data);
        }
        display(node.left, level + 1);
    }

    // Traversals
    public void preOrder(){
        preOrder(root);
    }

    // Pre-order traversal: Root -> Left -> Right
    private void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    // In-order traversal: Left -> Root -> Right
    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    // Post-order traversal: Left -> Right -> Root
    private void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void insertSortedArray(int[] arr){
        root = insertSortedArray(arr, 0, arr.length - 1);
    }

    // Insert elements from a sorted array to create a balanced BST
    private Node insertSortedArray(int[] arr, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        Node node = new Node(arr[mid]);
        node.left = insertSortedArray(arr, start, mid - 1);
        node.right = insertSortedArray(arr, mid + 1, end);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

}
