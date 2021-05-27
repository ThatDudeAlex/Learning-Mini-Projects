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
        Node curHead = head;

        if (curHead == null) {
            this.head = new Node(data);
            this.listSize++;
            return this.head;
        }

        while (curHead.nextNode != null)
            curHead = curHead.nextNode;
        curHead.nextNode = new Node(data);

        this.listSize++;
        return this.head;
    }

    // Inserts new node at the beginning of the linked list & returns the new head
    public Node insertFirst(int data) {
        Node prevHead = this.head;
        this.head = new Node(data);
        this.head.nextNode = prevHead;

        this.listSize++;
        return this.head;
    }




    // deletes the first node in the list
    public Node deleteFirst() {
        if (this.head == null)
            return null;

        Node prevHead = this.head;
        this.head = this.head.nextNode;
        prevHead.nextNode = null;

        this.listSize--;
        return prevHead;
    }

    // deletes the last node in the list
    public Node deleteLast() {
        Node curHead = this.head;
        Node prevHead = null;

        if (curHead == null)
            return null;

        if (curHead.nextNode == null) {
            prevHead = curHead;
            this.head = null;
            return prevHead;
        }

        while (curHead.nextNode != null) {
            prevHead = curHead;
            curHead = curHead.nextNode;
        }

        prevHead.nextNode = null;

        this.listSize--;
        return curHead;
    }

    // deletes the node in the specified index 
    public boolean deleteIndex(int index) {
        Node curHead = this.head;
        Node prevHead = null;

        if ((this.listSize == 0) || index < 0 || index >= this.listSize)
            return false;

        if (index == 0) {
            prevHead = this.head;
            this.head = this.head.nextNode;
            prevHead.nextNode = null;

            this.listSize--;
            return true;
        }

        for (int i = 0; i < index; i++) {
            prevHead = curHead;
            curHead = curHead.nextNode;
        }

        this.listSize--;
        prevHead.nextNode = curHead.nextNode;
        curHead.nextNode = null;

        return true;
    }

    public int size() {
        return this.listSize;
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
