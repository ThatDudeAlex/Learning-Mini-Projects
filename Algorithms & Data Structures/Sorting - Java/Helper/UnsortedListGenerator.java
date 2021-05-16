package Helper;

import java.util.Random;

public class UnsortedListGenerator {
    
    // Returns a default unsortted list of random numbers, between the range of [0 <= 1000]
    // The length of the list will be of size: 20
    public static int[] generateUnsortedList() {
        return generateList(20, 1000);
    }

    // Returns an unsortted list of random numbers, between the range of [0 <= upperBoundForRandomNumber]
    // The length of the list will be of size: <listSize> 
    public static int[] generateUnsortedList(int listSize, int upperBoundForRandomNumber) {
        return generateList(listSize, upperBoundForRandomNumber);
    }

    private static int[] generateList(int listSize, int upperBoundForRandomNumber) {
        int[] unsortedList = new int[listSize];
        Random randomNumberGenerator = new Random();

        // upperBound is not inclusive, so we need the + 1 to generate numbers between 0 - 1000
        for (int i = 0; i < unsortedList.length; i++)
            unsortedList[i] = randomNumberGenerator.nextInt(upperBoundForRandomNumber + 1);
        return unsortedList;
    }
}
