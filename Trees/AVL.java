package Trees;

public class AVL {

    private class Node{
        private int data;
        private Node left, right;
        private int height;

        public Node(int data){
            this.data = data;
            this.height = 0;
        }
    }

    private Node root;

    public AVL(){
        this.root = null;
    }

    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node == null) return -1;
        return node.height;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) return new Node(data);

        if(data < node.data){
            node.left = insert(node.left, data);
        } else if(data > node.data){
            node.right = insert(node.right, data);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private Node balance(Node node){
        int balanceFactor = height(node.left) - height(node.right);

        // Left heavy
        if(balanceFactor > 1){
            if(height(node.left.left) < height(node.left.right)){
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        // Right heavy
        if(balanceFactor < -1){
            if(height(node.right.right) < height(node.right.left)){
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateLeft(Node node){
        Node newRoot = node.right;
        node.right =newRoot.left;
        newRoot.left = node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }

    private Node rotateRight(Node node){
        Node newRoot = node.left;
        node.left =newRoot.right;
        newRoot.right = node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }

    public void display(){
        display(root, 0);
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node node, int data){
        if(node == null) return null;

        if(data < node.data){
            node.left = delete(node.left, data);
        } else if(data > node.data){
            node.right = delete(node.right, data);
        } else {
            // Node with one child or no child
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.data = minValue(node.right);
            // Delete the inorder successor
            node.right = delete(node.right, node.data);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private int minValue(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node.data;
    }

    public boolean contains(int data){
        return search(root, data);
    }

    private boolean search(Node node, int data){
        if(node == null) return false;
        if(data < node.data) return search(node.left, data);
        else if(data > node.data) return search(node.right, data);
        return true;
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

}
