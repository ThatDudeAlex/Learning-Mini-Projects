package Linear;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int listSize;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.listSize = 0;
    }

    // Inserts at the end of the linked list & return the head node
    public Node insertLast(int data) {
        Node newTailNode = new Node(data);
        newTailNode.prevNode = this.tail;

        if (this.tail != null)
            this.tail.nextNode = newTailNode;

        if (this.tail == null)
            this.head = newTailNode;

        this.tail = newTailNode;

        incrementListSize();
        return newTailNode;
    }

    // Inserts new node at the beginning of the linked list & returns the new head
    public Node insertFirst(int data) {
        Node newHeadNode = new Node(data);

        // new node points to the current head
        newHeadNode.nextNode = this.head;

        if (this.head != null)
            this.head.prevNode = newHeadNode;

        if (this.head == null)
            this.tail = newHeadNode;

        this.head = newHeadNode;

        incrementListSize();
        return newHeadNode;
    }


    // deletes the first node in the list
    public Node deleteHead() {
        if (this.head == null)
            return null;

        Node prevHead = this.head;
        this.head = this.head.nextNode;

        // disconnects the first node from the list
        this.head.prevNode = null;
        prevHead.nextNode = null;

        decrementListSize();
        return prevHead;
    }

    // deletes the last node in the list
    public Node deleteTail() {
        if (this.tail == null)
            return null;
        
        Node prevTail = this.tail;

        // disconnects last node from the list
        this.tail = prevTail.prevNode;
        this.tail.nextNode = null;
        prevTail.prevNode = null;

        decrementListSize();
        return prevTail;
    }

    // deletes the node in the specified index 
    public Node deleteIndex(int index) {
        if (isEmpty() || isOutOfBoundsIndex(index))
            return null;
        if (index == 0) 
            return deleteHead();
        if (index == size() - 1)
            return deleteTail();

        int midPoint = (size() - 1) / 2;
            return (index <= midPoint) ? startFromHeadToDeleteNode(index) : startFromTailToDeleteNode(index);
    }

    private Node startFromHeadToDeleteNode(int index) {
        Node curNode = this.head;
        Node nodeToRemove;

        for (int i = 0; i < index - 1; i++)
            curNode = curNode.nextNode;

        nodeToRemove = curNode.nextNode;

        curNode.nextNode = nodeToRemove.nextNode;
        nodeToRemove.nextNode.prevNode = curNode;

        nodeToRemove.nextNode = null;
        nodeToRemove.prevNode = null;

        decrementListSize();
        return nodeToRemove;
    }

    private Node startFromTailToDeleteNode(int index) {
        Node curNode = this.tail;
        Node nodeToRemove;

        for (int i = size() - 1; i > index + 1; i--)
            curNode = curNode.prevNode;

        nodeToRemove = curNode.prevNode;

        curNode.prevNode = nodeToRemove.prevNode;
        nodeToRemove.prevNode.nextNode = curNode;

        nodeToRemove.nextNode = null;
        nodeToRemove.prevNode = null;

        decrementListSize();
        return nodeToRemove;
    }

    public int size() {
        return this.listSize;
    }
    public int incrementListSize() {
        return this.listSize++;
    }
    public int decrementListSize() {
        return this.listSize--;
    }

    public boolean isEmpty() {
        return (size() == 0) ? true : false;
    }

    private boolean isOutOfBoundsIndex(int index) {
        return (index < 0 || index >= size()) ? true : false;
    }

    // Prints the complete linked list
    public void printLinkedList() {
        Node curHead = this.head;
        
        while (curHead != null) {
            System.out.printf("%d -> ", curHead.data);
            curHead = curHead.nextNode;
        }
        System.out.print("null\n\n");
    }


    public class Node {
        public int data;
        public Node nextNode;
        public Node prevNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }
    
}
