package Trees;

public class Main {
    public static void main(String[] args) {

        // Creating BST from Unsorted Array
        int[] arr = {5, 3, 7, 2, 4, 6, 8};
        BST bst = new BST(arr);

        System.out.println("Tree");
        bst.display();
        System.out.println();

        bst.delete(3);
        System.out.println("After Deletion of 3");
        bst.display();
        System.out.println();

        System.out.println(bst.contains(4) ? "4 Found" : "4 Not Found");
        System.out.println(bst.contains(3) ? "3 Found" : "3 Not Found");
        System.out.println();

        // Creating Balanced BST from Sorted Array
        int[] arr2 ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BST bst2 = new BST();
        bst2.insertSortedArray(arr2);
        System.out.println("Balanced BST from Sorted Array");
        bst2.display();
        System.out.println();

        System.out.println("Height of bst2: " + bst2.height());
        System.out.println();

        System.out.print("Preorder Traversal: ");
        bst2.preOrder();
        System.out.println();

        // Inorder Traversal always gives sorted order for BST
        System.out.print("Inorder Traversal: ");
        bst2.inOrder();
        System.out.println();

        System.out.print("Postorder Traversal: ");
        bst2.postOrder();
        System.out.println();
        System.out.println();

    }
}
