package Trees;

public class SegmentTree {

    private class Node{
        private int data;
        private int start, end;
        private Node left, right;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
            this.data = 0;
        }
    }

    private Node root;

    public SegmentTree(int[] arr){
        this.root = buildTree(arr, 0, arr.length - 1);
    }

    private Node buildTree(int[] arr, int start, int end){
        if(start > end) return null;
        Node node = new Node(start, end);
        if(start == end){
            node.data = arr[start];
            return node;
        }
        int mid = start + (end - start) / 2;
        node.left = buildTree(arr, start, mid);
        node.right = buildTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data; // sum operation
        return node;
    }

    public int rangeQuery(int queryStart, int queryEnd){
        return rangeQuery(root, queryStart, queryEnd);
    }

    private int rangeQuery(Node root, int start, int end){
        if(root == null || start > root.end ||end < root.start) return 0;
        if(start <= root.start && end >= root.end) return root.data;
        return rangeQuery(root.left, start, end) + rangeQuery(root.right, start, end);
    }

    public void update(int index, int value){
        update(root, index, value);
    }

    private void update(Node root, int index, int value){
        if(root == null || index < root.start || index > root.end) return;
        if(root.start == root.end){
            root.data = value;
            return;
        }
        update(root.left, index, value);
        update(root.right, index, value);
        root.data = root.left.data + root.right.data; // sum operation
    }

    public void display(){
        display(root, 0);
    }

    private void display(Node node, int level){
        if(node == null) return;
        display(node.right, level + 1);

        if(level != 0){
            for(int i = 1; i < level; i++)
                System.out.print("|\t\t\t\t");
            System.out.println("|------>[" + node.start + "-" + node.end + "] " + node.data);
        } else {
            System.out.println("[" + node.start + "-" + node.end + "] " + node.data);
        }
        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2,-8, 4, 9};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();
        System.out.println();

        System.out.println("Sum of values in range(1, 3): " + segmentTree.rangeQuery(1, 3));
        segmentTree.update(1, 10);
        System.out.println("After updating index 1 to 10:");
        segmentTree.display();
        System.out.println();

        System.out.println("Sum of values in range(1, 3): " + segmentTree.rangeQuery(1, 3));
        System.out.println();
    }

}
