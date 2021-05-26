package Sorting;

import static Helper.ListUtils.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        int[] list = generateUnsortedList();

        printHeaders("Before Radix Sort");
        printList(list);

        printHeaders("After Radix Sort");
        printList(performRadixSort(list));

        
        if (isSorted(list))
            printHeaders("HOORAY!");
        else
            printHeaders("Fail :(");
    }

    /* 
        Radix Sort

        Note: The runtime of radix sort is O(n∙k), where n is the number of elements to be sorted, and k is the
        number of digits in the maximum of all those element. If we call that max element m, then k ≈ log<sub10>m.
        Thus, we can write radix sort's runtime more precisely as O(n log m).

        Time Complexity
        ---------------------
        Worst   : O(nk) = O(n log m)

        Average : O(nk) = O(n log m)
        
        Best    : O(nk) = O(n log m)
    */
    private static int[] performRadixSort(int[] list) {
        List<LinkedList<Integer>> radixBuckets = createRadixBuckets();
        int largestNumberInList = getLargestNumberInList(list);

        for (int power = 1; (largestNumberInList / power) > 0; power *= 10) {
            int listIndex = 0;

            for (int i = 0; i < list.length; i++) {
                int leastSignificantDigit = (list[i] / power) % 10;
                radixBuckets.get(leastSignificantDigit).add(list[i]);
            }

            for (int i = 0; i < radixBuckets.size(); i++) {
                while (radixBuckets.get(i).size() > 0) {
                    list[listIndex++] = radixBuckets.get(i).poll();
                }
            }
        }

        return list;
    }
    
    private static List<LinkedList<Integer>> createRadixBuckets() {
        List<LinkedList<Integer>> radixBuckets = new ArrayList<>();

        for(int i = 0; i < 10; i++)
            radixBuckets.add(new LinkedList<Integer>());
        return radixBuckets;
    }

    private static int getLargestNumberInList(int[] list) {
        int largestNumber = list[0];

        for (int i = 1; i < list.length; i++)
            if (list[i] > largestNumber)
                largestNumber = list[i];
        return largestNumber;
    }
}
