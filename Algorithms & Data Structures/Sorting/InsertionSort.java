import static Helper.ListUtils.*;
import static Helper.UnsortedListGenerator.*;

public class InsertionSort {

    public static void main(String[] args) {
        int[] list = generateUnsortedList(30, 1000);

        printHeaders("Before Insertion Sort");
        printList(list);

        printHeaders("After Insertion Sort");
        printList(performInsertionSort(list));
    }


    /* 
        Insertion Sort

        Worst Case runtime: O(n^2)
        Best Case runtime:  O(n)
    */
    private static int[] performInsertionSort(int[] unsortedList) {
        for (int i = 1; i < unsortedList.length; i++) 
            for (int j = i; j >= 1; j--) 
                if (unsortedList[j - 1] > unsortedList[j]) 
                    swap(unsortedList, j, j - 1);
        return unsortedList;
    }
}
