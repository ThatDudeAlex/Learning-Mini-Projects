import java.util.Random;

public class SortingAlgorithmsExamples {

    public static void main(String[] args) {
        
        testBubbleSort(createUnsortedList());
        testSelectionSort(createUnsortedList());
        testInsertionSort(createUnsortedList());
    }


    // Returns an unsorted list of randomly generated numbers
    private static int[] createUnsortedList() {
        int[] unsortedList = new int[20];
        int upperBoundForRandomNumber = 1000;
        Random randomNumberGenerator = new Random();

        // upperBound is not inclusive, so we need the + 1 to generate numbers between 0 - 1000
        for (int i = 0; i < unsortedList.length; i++)
            unsortedList[i] = randomNumberGenerator.nextInt(upperBoundForRandomNumber + 1);
        return unsortedList;
    }


    // ========================= O(n^2) Sorting Algorithms ==============================

    private static void testBubbleSort(int[] unsortedList) {
        System.out.println("Bubble Sorting\n");
        printList(unsortedList);
        printList(performBubbleSort(unsortedList));
    }

    /* 
        Bubble Sort works by slowly moving bigger numbers down the list, eventually every number will  
        end in their correct spot. Not a very efficient sorting algorithm.

        Worst Case runtime: O(n^2)
        Best Case runtime:  O(n)
    */
    private static int[] performBubbleSort(int[] unsortedList) {
        for (int i = 0; i < unsortedList.length; i++) 
            for (int j = 0; j < unsortedList.length; j++)
                if ((j + 1) < unsortedList.length && unsortedList[j] > unsortedList[j + 1])
                    swap(unsortedList, j, j + 1);
                    
        return unsortedList;        
    }



    private static void testSelectionSort(int[] unsortedList) {
        System.out.println("Selection Sorting\n");
        printList(unsortedList);
        printList(performSelectionSort(unsortedList));
    }

    /* 
        Selection Sort

        Worst Case runtime: O(n^2)
        Best Case runtime:  O(n)
    */
    private static int[] performSelectionSort(int[] unsortedList) {
        int smallestNumberIndex;

        for (int i = 0; i < unsortedList.length; i++){
            smallestNumberIndex = i;

            for (int j = i + 1; j < unsortedList.length; j++) 
                if (unsortedList[j] < unsortedList[smallestNumberIndex]) 
                    smallestNumberIndex = j;
            swap(unsortedList, i, smallestNumberIndex);
        } 
                    
        return unsortedList;        
    }

    private static void testInsertionSort(int[] unsortedList) {
        System.out.println("Insertion Sorting\n");
        printList(unsortedList);
        printList(performInsertionSort(unsortedList));
    }

    /* 
        Insertion Sort

        Worst Case runtime: O(n^2)
        Best Case runtime:  O(n)
    */
    private static int[] performInsertionSort(int[] unsortedList) {
        for (int i = 1; i < unsortedList.length; i++) 
            for (int j = i; j >= 1; j--) 
                if (unsortedList[j - 1] > unsortedList[j]) 
                    swap(unsortedList, j, j - 1);
        return unsortedList;
    }



    // ========================= Helper Methods ==============================

    // Swap the location of two numbers in an array 
    private static void swap(int[] unsortedList, int index1, int index2) {
        int placeHolder = unsortedList[index2];
        unsortedList[index2] = unsortedList[index1];
        unsortedList[index1] = placeHolder;
    }

    // Prints every number in an array, each number will have a width of 5 and be left-justified 
    private static void printList(int[] list) {
        for (int num : list)
            System.out.printf("%-5d", num);
        System.out.println("\n");
    }

}