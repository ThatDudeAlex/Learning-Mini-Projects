package TreeTraversal;

import Helper.TreeUtils;
import Trees.BinarySearchTree.Node;

public class PostorderTraversal {
    public static void main(String[] args) {
        System.out.print("\nPostorder Traversal with testing tree: ");
        postorderTraversal(TreeUtils.generateTestingTree().getRoot());
        
        System.out.print("\n\nPostorder Traversal with random tree:  ");
        postorderTraversal(TreeUtils.generateRandomTree().getRoot());

        System.out.print("\n\n");
    }
    
    // Root, Left, Right
    public static void postorderTraversal(Node curNode) {
        if (curNode == null)
            return;

        postorderTraversal(curNode.leftChild);
        postorderTraversal(curNode.rightChild);
        System.out.printf("%-4d ", curNode.data);
    }
}
