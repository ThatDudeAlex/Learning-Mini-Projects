package Trees;
public class BinarySearchTree {
    private Node root = null;

    public Node getRoot() {
        return this.root;
    }

    public void insert(int data) {
        this.root = insertRecursively(this.root, data);
    }
    
    private Node insertRecursively(Node root, int data) {
        // if we reach a null, it means we reached the correct spot in the tree to insert
        if (root == null)
            return new Node(data);

        if (data > root.data)
            root.rightChild = insertRecursively(root.rightChild, data);
        else if (data < root.data)
            root.leftChild = insertRecursively(root.leftChild, data);
        
        // Value already exist in the tree
        return root;
    }

    public boolean search(int data) {
        return searchRecursively(this.root, data);
    }

    private boolean searchRecursively(Node currentNode, int data) {
        if (currentNode == null)
            return false;
        if (currentNode.data == data)
            return true;
        
        if (data > currentNode.data)
            return searchRecursively(currentNode.rightChild, data);
        else
            return searchRecursively(currentNode.leftChild, data);
    }

    
    public void delete(int data) {
        this.root = deleteRecursively(this.root, data);
    }

    private Node deleteRecursively(Node currentNode, int data) {

        if (currentNode == null)
            return null;

        if (data > currentNode.data)
            currentNode.rightChild = deleteRecursively(currentNode.rightChild, data);
        else if (data < currentNode.data)
            currentNode.leftChild = deleteRecursively(currentNode.rightChild, data);
        else {
            // Case 1: Node has no childs (AKA its a leaf node) 
            if (isLeafNode(currentNode)) 
                return null;

            // Case 2: Node has 1 children
            if (!nodeHasTwoChildren(currentNode))
                if (currentNode.leftChild != null)
                    return currentNode.leftChild;
                else
                    return currentNode.rightChild;

            // Case 3: Node has 2 children
            if (nodeHasTwoChildren(currentNode)) {
                currentNode.data = findMinValueInSubtree(currentNode.rightChild, currentNode.rightChild.data);
                currentNode.rightChild = deleteRecursively(currentNode.rightChild, data);
                return currentNode;
            }
        }
        
        return currentNode;
    }

    private boolean isLeafNode(Node currentNode) {
        return (currentNode.leftChild == null && currentNode.rightChild == null);
    }

    private boolean nodeHasTwoChildren(Node currentNode) {
        return (currentNode.leftChild != null && currentNode.rightChild != null);
    }
    
    private int findMinValueInSubtree(Node root, int minValue) {
        if (root == null)
            return minValue;
        if (root.data < minValue)
            minValue = root.data;

        return findMinValueInSubtree(root.leftChild, minValue);
    }

    public class Node {
        public int data;
        public Node rightChild;
        public Node leftChild;

        public Node(int data) {
            this.data = data;
            this.rightChild = null;
            this.leftChild = null;
        }
    }
}