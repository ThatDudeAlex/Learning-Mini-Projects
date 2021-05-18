import static Helper.ListUtils.*;
import static Helper.ListGenerator.*;

public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedList        = generateSortedList(100);
        int numberToFind        = 44; // change this number to test if is in the list
        int numberFoundAtIndex  = performBinarySearch(sortedList, numberToFind);
        
        printHeaders(String.format("Sorted list of size: %d", sortedList.length));
        printList(sortedList, numberFoundAtIndex);

        if (numberFoundAtIndex >= 0) 
            printNumberFoundHeader(numberFoundAtIndex, numberToFind);
        else
            printNumberNotFoundHeader(numberToFind);
    }

    //  return the index of the number found or -1
    private static int performBinarySearch(int[] sortedList, int numberToFind) {
        int lowestIndex = 0;
        int highestIndex = sortedList.length - 1;
        int middleIndex = (lowestIndex + highestIndex) / 2;

        while (lowestIndex <= highestIndex) {

            if (sortedList[middleIndex] > numberToFind)
                highestIndex = middleIndex - 1;
            else if (sortedList[middleIndex] < numberToFind)
                lowestIndex = middleIndex + 1;
            else if (sortedList[middleIndex] == numberToFind)
                return middleIndex;

            middleIndex = (lowestIndex + highestIndex) / 2;
        }

        return -1;
    } 

    
    private static void printNumberFoundHeader(int numberFoundAtIndex, int numberToFind) {
        String headerMsg = "HOORAY! NUMBER %d WAS FOUND IN COL: %d ROW: %d";
        int column       = numberFoundAtIndex % 10 + 1;
        int row          = numberFoundAtIndex / 10 + 1;

        printHeaders(String.format(headerMsg, numberToFind, column, row));
    }


    private static void printNumberNotFoundHeader(int numberToFind) {
        printHeaders(String.format("LIST DOES NOT CONTAINER THE NUMEBER %d", numberToFind));
    }
}