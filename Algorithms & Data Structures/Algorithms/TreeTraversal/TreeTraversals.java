import Trees.BinarySearchTree;
import Trees.BinarySearchTree.Node;

public class TreeTraversals {
    
    public static BinarySearchTree generateTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(3);
        bst.insert(8);
        bst.insert(1);
        bst.insert(5);
        bst.insert(7);
        bst.insert(9);

        return bst;
    }

    // Root, Left, Right
    public static void preorderTraversal(Node curNode) {
        if (curNode == null)
            return;

        System.out.printf("%d ", curNode.data);
        preorderTraversal(curNode.leftChild);
        preorderTraversal(curNode.rightChild);
    }
    
    
    // Left, Root, Right
    public static void inorderTraversal(Node curNode) {
        if (curNode == null)
            return;

        inorderTraversal(curNode.leftChild);
        System.out.printf("%d ", curNode.data);
        inorderTraversal(curNode.rightChild);
    }
    

    // Left, Right, Root
    public static void postorderTraversal(Node curNode) {
        if (curNode == null)
        return;

        postorderTraversal(curNode.leftChild);
        postorderTraversal(curNode.rightChild);
        System.out.printf("%d ", curNode.data);
    }


    public static void main(String[] args) {
        BinarySearchTree bst = generateTree();

        System.out.print("\nPreoder Traversal: ");
        preorderTraversal(bst.getRoot());
        
        System.out.print("\n\nInoder Traversal:  ");
        inorderTraversal(bst.getRoot());
        
        System.out.print("\n\nPostoder Traversal: ");
        postorderTraversal(bst.getRoot());

        System.out.print("\n\n");
    }
}
