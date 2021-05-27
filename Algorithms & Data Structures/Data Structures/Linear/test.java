package Linear;

public class test {
    public static void main(String[] args) {
        SimpleLinkedList linkedList = new SimpleLinkedList();

        linkedList.insertLast(2);
        linkedList.insertLast(5);
        linkedList.insertLast(8);
        System.out.printf("\nSize: %d \n\n", linkedList.size());
        linkedList.printLinkedList();
        
        linkedList.deleteFirst();
        System.out.printf("\nSize: %d \n\n", linkedList.size());
        linkedList.printLinkedList();
        
        linkedList.insertLast(10);
        System.out.printf("\nSize: %d \n\n", linkedList.size());
        linkedList.printLinkedList();
        
        linkedList.deleteLast();
        System.out.printf("\nSize: %d \n\n", linkedList.size());
        linkedList.printLinkedList();

        linkedList.insertFirst(2);
        System.out.printf("\nSize: %d \n\n", linkedList.size());
        linkedList.printLinkedList();

        linkedList.deleteIndex(-1);
        System.out.printf("\nSize: %d \n\n", linkedList.size());
        linkedList.printLinkedList();
    }
}
