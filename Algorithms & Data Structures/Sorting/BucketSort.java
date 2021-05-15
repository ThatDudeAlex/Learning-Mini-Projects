import static Helper.ListUtils.*;
import static Helper.UnsortedListGenerator.*;

public class BucketSort {
 
    public static void main(String[] args) {
        int UPPER_BOUND = 100;
        int[] list = generateUnsortedList(30, UPPER_BOUND);

        printHeaders("Before Bucket Sort");
        printList(list);

        printHeaders("After Bucket Sort");
        printList(performBucketSort(list, UPPER_BOUND));
    }


    /* 
        Bucket Sort

        Time Complexity
        ---------------------
        Worst   : O(n^2)

        Average : O(n + k)
        
        Best    : O(n + k)
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
