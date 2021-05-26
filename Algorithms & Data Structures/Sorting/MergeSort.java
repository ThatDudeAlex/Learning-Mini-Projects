package Sorting;

import static Helper.ListUtils.*;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] list = generateUnsortedList();

        printHeaders("Before Merge Sort");
        printList(list);

        printHeaders("After Merge Sort");
        performMergeSort(list, 0, list.length - 1);
        printList(list);

        if (isSorted(list))
            printHeaders("HOORAY!");
        else
            printHeaders("Fail :(");
    }


    /* 
        Merge Sort

        Time Complexity
        ---------------------
        Worst   : O(n log n)

        Average : O(n log n)
        
        Best    : O(n log n)
    */
    private static void performMergeSort(int[] list, int low, int high) {
        int mid = (low + high) / 2;

        if (low >= high)
            return;
        
        performMergeSort(list, low, mid);
        performMergeSort(list, mid + 1, high);  

        merge(list, low, high, mid);
    }

    private static void merge(int[] list, int low, int high, int mid) {
        int currentIdxOfArray1 = low;
        int currentIdxOfArray2 = mid + 1; 
        int currentIdxOfAux    = 0;
        int[] auxiliaryArray = new int[(high - low) + 1];

        // Uses the auxiliaryArray to sort & merge both arrays into it
        while (numbersRemainInArray1(currentIdxOfArray1, mid) || numbersRemainInArray2(currentIdxOfArray2, high)) {
            if (!numbersRemainInArray1(currentIdxOfArray1, mid))
                auxiliaryArray[currentIdxOfAux++] = list[currentIdxOfArray2++];

            else if (!numbersRemainInArray2(currentIdxOfArray2, high))
                auxiliaryArray[currentIdxOfAux++] = list[currentIdxOfArray1++];

            else if (list[currentIdxOfArray1] < list[currentIdxOfArray2])
                auxiliaryArray[currentIdxOfAux++] = list[currentIdxOfArray1++];

            else 
                auxiliaryArray[currentIdxOfAux++] = list[currentIdxOfArray2++];
        }

        // copies the sorted content of the auxiliaryArray into the original list 
        for (int i = low, j = 0; i <= high; i++)
            list[i] = auxiliaryArray[j++];
    }

    private static boolean numbersRemainInArray1(int indexOfArray1, int mid) {
        return indexOfArray1 <= mid;
    }   

    private static boolean numbersRemainInArray2(int indexOfArray2, int high) {
        return indexOfArray2 <= high;
    }
}
