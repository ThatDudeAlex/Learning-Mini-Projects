import static Helper.ListUtils.*;
import static Helper.UnsortedListGenerator.*;

public class SelectionSort {

    public static void main(String[] args) {
        int[] list = generateUnsortedList();

        printHeaders("Before Selection Sort");
        printList(list);

        printHeaders("After Selection Sort");
        printList(performSelectionSort(list));

        
        if (isSorted(list))
            printHeaders("HOORAY!");
        else
            printHeaders("Fail :(");
    }


    /* 
        Selection Sort

        Time Complexity
        ---------------------
        Worst   : O(n^2)

        Average : O(n^2)
        
        Best    : O(n^2)
    */
    private static int[] performSelectionSort(int[] list) {
        int smallestNumberIndex;

        for (int i = 0; i < list.length; i++){
            smallestNumberIndex = i;

            for (int j = i + 1; j < list.length; j++) 
                if (list[j] < list[smallestNumberIndex]) 
                    smallestNumberIndex = j;
            swap(list, i, smallestNumberIndex);
        } 
                    
        return list;        
    }
}
