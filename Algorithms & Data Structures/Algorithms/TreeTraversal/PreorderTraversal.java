package TreeTraversal;

import Helper.TreeUtils;
import Trees.BinarySearchTree.Node;;

public class PreorderTraversal {
    public static void main(String[] args) {
        System.out.print("\nPreorder Traversal with testing tree: ");
        preorderTraversal(TreeUtils.generateTestingTree().getRoot());
        
        System.out.print("\n\nPreorder Traversal with random tree:  ");
        preorderTraversal(TreeUtils.generateRandomTree().getRoot());

        System.out.print("\n\n");
    }
    
    // Root, Left, Right
    public static void preorderTraversal(Node curNode) {
        if (curNode == null)
            return;

        System.out.printf("%d ", curNode.data);
        preorderTraversal(curNode.leftChild);
        preorderTraversal(curNode.rightChild);
    }
}
