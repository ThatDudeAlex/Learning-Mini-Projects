package Sorting;

import static Helper.ListUtils.*;

public class BucketSort {
 
    public static void main(String[] args) {
        int UPPER_BOUND = 100;
        int[] list = generateUnsortedList(20, UPPER_BOUND);

        printHeaders("Before Bucket Sort");
        printList(list);

        printHeaders("After Bucket Sort");
        printList(performBucketSort(list, UPPER_BOUND));

        
        if (isSorted(list))
            printHeaders("HOORAY!");
        else
            printHeaders("Fail :(");
    }


    /* 
        Bucket Sort

        Note: The runtime of counting sort is O(MAX{n,m}), where n is the number of elements to be sorted, and
        m is the length of the buckets array. We can also express this runtime as O(n + m), because whichever
        term ends up being larger will wash out the other term.

        Time Complexity
        ---------------------
        Worst   : O(n^2)

        Average : O(n + m)
        
        Best    : O(n + m)
    */
    private static int[] performBucketSort(int[] list, int maxNumberInRange) {
        int[] buckets = new int[maxNumberInRange + 1];
        int listIndexToFill = 0;

        for (int i = 0; i < list.length; i++)
            buckets[list[i]]++;
        
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                buckets[i]--;
                list[listIndexToFill++] = i;
            }
        }
        return list;
    }
}
