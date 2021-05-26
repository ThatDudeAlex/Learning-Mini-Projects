package TreeTraversal;

import Helper.TreeUtils;
import Trees.BinarySearchTree.Node;

public class InorderTraversal {
    public static void main(String[] args) {
        System.out.print("\nInorder Traversal with testing tree: ");
        inorderTraversal(TreeUtils.generateTestingTree().getRoot());
        
        System.out.print("\n\nInorder Traversal with random tree:  ");
        inorderTraversal(TreeUtils.generateRandomTree().getRoot());

        System.out.print("\n\n");
    }
    
    // Root, Left, Right
    public static void inorderTraversal(Node curNode) {
        if (curNode == null)
            return;

        inorderTraversal(curNode.leftChild);
        System.out.printf("%d ", curNode.data);
        inorderTraversal(curNode.rightChild);
    }    
}
