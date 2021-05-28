package TreeTraversal.Trees;

import static Helper.TreeUtils.*;

import static TreeTraversal.LevelOrderTraversal.levelOrderTraversal;
import Trees.BinarySearchTree;
import Trees.BinarySearchTree.Node;


public class InvertBinaryTree {
    public static void main(String[] args) {
        System.out.printf("\nBinary tree before inverting: ");
        BinarySearchTree tree1 = generateTestingTree();
        printBinaryTree(tree1);
        
        System.out.printf("\nBinary tree after inverting:  ");
        invertTree(tree1.getRoot());
        printBinaryTree(tree1);
        
        System.out.println("\n");
    }

    // Do Postorder Traversal while swaping childnodes 
    private static void invertTree(Node root) {
        if (root == null)
            return;
        
        invertTree(root.leftChild);
        invertTree(root.rightChild);
        swapChildNodes(root);
    }

    private static void swapChildNodes(Node root) {
        Node tmp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tmp;
    }


    private static void printBinaryTree(BinarySearchTree tree) {
        levelOrderTraversal(tree.getRoot());
    }

}
