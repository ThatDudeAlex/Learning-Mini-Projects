package Helper;

import java.util.Random;

public class ListUtils {
    
    private static final String TEXT_BLUE = "\u001B[34m";
    private static final String TEXT_RESET = "\u001B[0m";

    private static final Random randomNumberGenerator = new Random();

    // =================== Unsorted List Methods ===================
    
    // Returns a fixed-size unsortted list of random numbers, between the range of [0 <= 1000]
    // The length of the list will be of size: 20
    public static int[] generateUnsortedList() {
        return buildUnsortedList(20, 1000);
    }

    
    // Returns an unsortted list of random numbers, between the range of [0 <= upperBoundForRandomNumber]
    // The length of the list will be of size: <listSize> 
    public static int[] generateUnsortedList(int listSize, int upperBoundForRandomNumber) {
        return buildUnsortedList(listSize, upperBoundForRandomNumber);
    }


    // Handles the creation of the unsorted list 
    private static int[] buildUnsortedList(int listSize, int upperBoundForRandomNumber) {
        int[] unsortedList = new int[listSize];

        // upperBound is not inclusive, so we need the + 1 to generate numbers between 0 - 1000
        for (int i = 0; i < unsortedList.length; i++)
            unsortedList[i] = randomNumberGenerator.nextInt(upperBoundForRandomNumber + 1);
        return unsortedList;
    }

    // =================== Sorted List Methods ===================

    // Returns a fixed-size sorted list of pseudo random numbers
    // The length of the list will be of size: 20
    public static int[] generateSortedList() {
        return buildSortedList(20);
    }


    // Returns a sortted list of pseudo random numbers
    // The length of the list will be of size: <listSize> 
    public static int[] generateSortedList(int listSize) {
        return buildSortedList(listSize);
    }

    // Handles the creation of the sorted list
    // Note: so far the list is static, and will always have the same values depending on its size,
    //       need to add some randomness into the list
    private static int[] buildSortedList(int listSize) {
        int[] sortedList = new int[listSize];

        for (int i = 0, j = 1; i < sortedList.length; i++, j++) {
            if (i == 0)
                sortedList[i] = i;
            else 
                sortedList[i] = sortedList[i - 1] + j;

            if (j % 100 == 0)
                j = 1;

            // Note: Uses later when I have a driver to help run the searches of randomize sorted list and take user input,
            //       this would make it easier to dynamically create a list & have the users perform binary search on the list
            //       so they can see first hand if it works, instead of having a hard-coded value
            // if (i == 0)
            //     sortedList[i] = i + randomNumberGenerator.nextInt(upperBoundForRandomNumber + 1);
            // else 
            //     sortedList[i] = sortedList[i - 1] + randomNumberGenerator.nextInt(upperBoundForRandomNumber + 1);
        }
        return sortedList;
    }
    
    // =================== Auxiliary List Methods ===================

    // Swap the location of two numbers in an array 
    public static void swap(int[] list, int index1, int index2) {
        int placeHolder = list[index2];
        list[index2] = list[index1];
        list[index1] = placeHolder;
    }


    public static boolean isSorted(int[] list) {
        for (int i = 1; i < list.length; i++)
            if (list[i - 1] > list[i])
                return false;
        return true;
    }


    // =================== List Printing Methods ===================

    public static void printList(int[] list) {
        displayList(list, -1);
    }

    public static void printList(int[] list, int indexToHighlight) {
        displayList(list, indexToHighlight);
    }

    private static void displayList(int[] list, int indexToHighlight) {
        StringBuilder listOutput = new StringBuilder();
 
        for (int i = 0, j = 0; i < list.length; i++, j++) 
            if ((i != 0) && (j % 10 == 0) && (i != indexToHighlight))
                listOutput.append(String.format("\n%-10d", list[i]));
            else if ((i != 0) && (j % 10 == 0) && (i == indexToHighlight))
                listOutput.append(String.format("\n%s%-10d%s", TEXT_BLUE, list[i], TEXT_RESET));
            else if(i == indexToHighlight)
                listOutput.append(String.format("%s%-10d%s", TEXT_BLUE, list[i], TEXT_RESET));
            else 
                listOutput.append(String.format("%-10d", list[i]));
        
        System.out.println(listOutput.append("\n").toString());
    }


    // =================== Header Printing Methods ===================

    public static void printHeaders(String headerMsg) {
        System.out.printf("%s\n|  %s  |\n%s\n\n", printHeaderBorders(headerMsg), headerMsg, printHeaderBorders(headerMsg));
    }

    private static String printHeaderBorders(String headerMsg) {
        String borders = "";

        for (int i = 0; i < headerMsg.length() + 6; i++)
            borders += "=";

        return borders;
    }
}