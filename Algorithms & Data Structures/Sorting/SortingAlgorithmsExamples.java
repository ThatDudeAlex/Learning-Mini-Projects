import java.util.Random;

public class SortingAlgorithmsExamples {

    public static void main(String[] args) {
        
        // Bubble Sort Test 
        System.out.println("Bubble Sorting\n");
        int[] unsortedList = createUnsortedList();
        printList(unsortedList);
        printList(performBubbleSort(unsortedList));

        // Selection Sort Test
        System.out.println("Selection Sorting\n");
        unsortedList = createUnsortedList();
        printList(unsortedList);
        printList(performSelectionSort(unsortedList));
    }


    // Returns an unsorted list of randomly generated numbers
    private static int[] createUnsortedList() {
        int[] unsortedList = new int[10];
        int upperBoundForRandomNumber = 1000;
        Random randomNumberGenerator = new Random();

        // upperBound is not inclusive, so we need the + 1 to generate numbers between 0 - 1000
        for (int i = 0; i < unsortedList.length; i++)
            unsortedList[i] = randomNumberGenerator.nextInt(upperBoundForRandomNumber + 1);
        return unsortedList;
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

    private static void swap(int[] unsortedList, int index1, int index2) {
        int placeHolder = unsortedList[index2];
        unsortedList[index2] = unsortedList[index1];
        unsortedList[index1] = placeHolder;
    }

    private static void printList(int[] list) {
        for (int num : list)
            System.out.printf("%-5d", num);
        System.out.println("\n");
    }

}