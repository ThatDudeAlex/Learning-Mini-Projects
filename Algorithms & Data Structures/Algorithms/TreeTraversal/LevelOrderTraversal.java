package TreeTraversal;

import java.util.LinkedList;

import Helper.TreeUtils;
import Trees.BinarySearchTree.Node;

// This class implemets level order traversal of a binary tree
public class LevelOrderTraversal {
    public static void main(String[] args) {
        System.out.print("\nLevel Order Traversal with testing tree: ");
        levelOrderTraversal(TreeUtils.generateTestingTree().getRoot());
        
        System.out.print("\n\nLevel Order Traversal with random tree:  ");
        levelOrderTraversal(TreeUtils.generateRandomTree().getRoot());

        System.out.print("\n\n");
    }

    private static void levelOrderTraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        levelOrderTraversal(root, queue);
    }

    private static void levelOrderTraversal(Node curNode, LinkedList<Node> queue) {
        if (curNode == null)
            return;

        printNodeValue(curNode);
        enqueueNodeChildrens(curNode, queue);
    
        while (!queue.isEmpty()) 
            levelOrderTraversal(queue.removeFirst(), queue);
    }

    private static void printNodeValue(Node curNode) {
        System.out.printf("%d ", curNode.data);
    } 

    private static LinkedList<Node> enqueueNodeChildrens(Node curNode, LinkedList<Node> queue) {
        if (curNode.leftChild != null)
            queue.add(curNode.leftChild);
        if (curNode.rightChild != null)
            queue.add(curNode.rightChild);
        
        return queue;
    }
}
