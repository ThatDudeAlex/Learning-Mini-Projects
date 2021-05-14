import static Helper.ListUtils.*;
import static Helper.UnsortedListGenerator.*;

public class BubbleSort {

    public static void main(String[] args) {
        int[] list = generateUnsortedList(30, 1000);

        printHeaders("Before Bubble Sort");
        printList(list);

        printHeaders("After Bubble Sort");
        printList(performBubbleSort(list));
    }

    
    /* 
        Bubble Sort works by slowly moving bigger numbers down the list, eventually every number will  
        end in their correct spot. Not a very efficient sorting algorithm.

        Worst Case runtime: O(n^2)
        Best Case runtime:  O(n)
    */
    private static int[] performBubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) 
            for (int j = 0; j < list.length; j++)
                if ((j + 1) < list.length && list[j] > list[j + 1])
                    swap(list, j, j + 1);
                    
        return list;        
    }
}
