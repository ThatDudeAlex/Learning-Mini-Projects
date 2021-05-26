package Sorting;

import static Helper.ListUtils.*;

// ===================   IN PROGRESS STILL   ===================
// =================== NOT FULLY WORKING YET ===================

public class QuickSort {
    public static void main(String[] args) {
        int[] list = generateUnsortedList();

        printHeaders("Before QuickSort");
        printList(list);

        printHeaders("After QuickSort");
        performQuickSort(list, 0, list.length - 1);
        printList(list);

        
        if (isSorted(list))
            printHeaders("HOORAY!");
        else
            printHeaders("Fail :(");
    }


    /* 
        QuickSort
    */
    private static void performQuickSort(int[] list, int low, int high) {
        int midPoint    = (high + low) / 2;
        int leftIndex   = low;
        int rightIndex  = high - 1;

        if (low == high)
            return;
        if (list.length == 1 || list.length == 0 || list == null)
            return;

        // System.out.printf("\nlow: %d | high: %d | mid: %d | leftIdx: %d | rightIdx: %d\n", low, high, midPoint, leftIndex, rightIndex);

        // swaps the midpoint all the way to end of the list or sublist
        swap(list, midPoint, high);

        // System.out.printf("\nlow: %d | high: %d | mid: %d | leftIdx: %d | rightIdx: %d\n", low, high, midPoint, leftIndex, rightIndex);

        while (leftIndex <= rightIndex){
            System.out.printf("\nlow: %d | high: %d | mid: %d | leftIdx: %d | rightIdx: %d\n", low, high, midPoint, leftIndex, rightIndex);
            if (!(list[leftIndex] >= list[high]))
                leftIndex++;
            else if ((list[leftIndex] >= list[high]) && !(list[rightIndex] <= list[high]))
                rightIndex--;
            else if ((list[leftIndex] >= list[high]) && (list[rightIndex] <= list[high]))
                swap(list, leftIndex++, rightIndex--);
            System.out.printf("\nlow: %d | high: %d | mid: %d | leftIdx: %d | rightIdx: %d\n", low, high, midPoint, leftIndex, rightIndex);
            printList(list);
        }

        swap(list, leftIndex, high);
        performQuickSort(list, low, leftIndex);
        performQuickSort(list, leftIndex + 1, high);
    }

}
