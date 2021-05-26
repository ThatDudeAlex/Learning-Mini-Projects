package Helper;

import java.util.Random;

import Trees.BinarySearchTree;

public class TreeUtils {

    private static final Random randomNumberGenerator = new Random();

    // Returns of prefifined tree, to help test traversal/search algorithms
    public static BinarySearchTree generateTestingTree() {
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

    // Returns a binaryTree of 7 random nodes
    public static BinarySearchTree generateRandomTree() {
        return buildRandomTree(7);
    }    

    // Returns a binaryTree of N random nodes
    public static BinarySearchTree generateRandomTree(int numberOfNodes) {
        return buildRandomTree(numberOfNodes);
    }
    
    private static BinarySearchTree buildRandomTree(int numberOfNodes) {
        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < numberOfNodes; i++)
            bst.insert(randomNumberGenerator.nextInt(101));
        return bst;
    }
}
