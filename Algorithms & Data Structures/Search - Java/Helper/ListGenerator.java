package Helper;

import java.util.Random;

public class ListGenerator {
    
    // Returns a default unsortted list of random numbers, between the range of [0 <= 1000]
    // The length of the list will be of size: 20
    public static int[] generateUnsortedList() {
        return buildUnsortedList(20, 1000);
    }

    // Returns an unsortted list of random numbers, between the range of [0 <= upperBoundForRandomNumber]
    // The length of the list will be of size: <listSize> 
    public static int[] generateUnsortedList(int listSize, int upperBoundForRandomNumber) {
        return buildUnsortedList(listSize, upperBoundForRandomNumber);
    }

    private static int[] buildUnsortedList(int listSize, int upperBoundForRandomNumber) {
        int[] unsortedList = new int[listSize];
        Random randomNumberGenerator = new Random();

        // upperBound is not inclusive, so we need the + 1 to generate numbers between 0 - 1000
        for (int i = 0; i < unsortedList.length; i++)
            unsortedList[i] = randomNumberGenerator.nextInt(upperBoundForRandomNumber + 1);
        return unsortedList;
    }


    /* 
        ===============================================================
    */

    public static int[] generateSortedList() {
        return buildSortedList(20);
    }

    public static int[] generateSortedList(int listSize) {
        return buildSortedList(listSize);
    }

    private static int[] buildSortedList(int listSize) {
        int[] sortedList = new int[listSize];

        for (int i = 0, j = 1; i < sortedList.length; i++, j++) {
            if (i == 0)
                sortedList[i] = i;
            else 
                sortedList[i] = sortedList[i - 1] + j;

            if (j % 100 == 0)
                j = 1;
        }
        return sortedList;
    }


}
