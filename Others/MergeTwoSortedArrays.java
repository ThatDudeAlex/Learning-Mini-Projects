import java.util.StringJoiner;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {2, 7, 9};
        int[] arr2 = {-3, 5, 12, 15, 22};

        System.out.printf("Array 1: %s\n", formatArray(arr1));
        System.out.printf("Array 2: %s\n", formatArray(arr2));
        System.out.printf("Sorted Merged Array: %s", formatArray(mergeSortedArrays(arr1, arr2)));
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];

        int arr1Idx   = 0;
        int arr2Idx   = 0;
        int mergedIdx = 0;

        while (arr1Idx < arr1.length || arr2Idx < arr2.length) {
            if (arr1Idx >= arr1.length)
                mergedArray[mergedIdx++] = arr2[arr2Idx++];
            else if (arr2Idx >= arr2.length)
                mergedArray[mergedIdx++] = arr1[arr1Idx++];
            else if (arr1[arr1Idx] <= arr2[arr2Idx])
                mergedArray[mergedIdx++] = arr1[arr1Idx++];
            else 
                mergedArray[mergedIdx++] = arr2[arr2Idx++];
        }
        return mergedArray;
    }

    private static String formatArray(int[] arr) {
        StringJoiner stringJoiner = new StringJoiner(", ","{","}");

        for (int num : arr)
            stringJoiner.add(Integer.toString(num));

        return stringJoiner.toString();
    }
}