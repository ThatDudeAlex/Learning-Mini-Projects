package Linear;

public class SimpleLinkedList {
    private Node head;
    private int listSize;

    public SimpleLinkedList() {
        this.head = null;
        this.listSize = 0;
    }

    // Inserts at the end of the linked list & return the head node
    public Node insertLast(int data) {
        Node curHead = this.head;

        if (curHead == null) {
            this.head = new Node(data);
            incrementListSize();;
            return this.head;
        }

        while (curHead.nextNode != null)
            curHead = curHead.nextNode;
        curHead.nextNode = new Node(data);

        incrementListSize();;
        return this.head;
    }

    // Inserts new node at the beginning of the linked list & returns the new head
    public Node insertFirst(int data) {
        Node newNode = new Node(data);;
        newNode.nextNode = this.head;
        this.head = newNode;

        incrementListSize();;
        return newNode;
    }

    // deletes the first node in the list
    public Node deleteHead() {
        if (this.head == null)
            return null;

        Node prevHead = this.head;
        this.head = this.head.nextNode;
        prevHead.nextNode = null;

        decrementListSize();;
        return prevHead;
    }

    // deletes the last node in the list
    public Node deleteTail() {
        Node curNode = this.head;
        Node prevNode = null;

        if (curNode == null)
            return null;
        if (curNode.nextNode == null)
            return deleteHead();

        while (curNode.nextNode != null) {
            prevNode = curNode;
            curNode = curNode.nextNode;
        }

        prevNode.nextNode = null;

        decrementListSize();;
        return curNode;
    }

    // deletes the node in the specified index 
    public Node deleteIndex(int index) {
        Node curNode = this.head;
        Node prevNode = null;

        if (isEmpty() || isOutOfBoundsIndex(index))
            return null;

        if (index == 0)
            deleteHead();
        if (index == size() - 1)
            return deleteTail();

        for (int i = 0; i < index; i++) {
            prevNode = curNode;
            curNode = curNode.nextNode;
        }

        decrementListSize();;
        prevNode.nextNode = curNode.nextNode;
        curNode.nextNode = null;

        return curNode;
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

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}
