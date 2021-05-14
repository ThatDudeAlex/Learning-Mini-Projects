public class BinarySearch {

    public static void main(String[] args) {
        int[] data = createSortedData();

        printSortedData(data);
        testDataWithMultiplesOf(data, 90);
        testDataWithMultiplesOf(data, 220);
        testDataWithMultiplesOf(data, 1300);
    }

    // Creates a sorted array of integers
    private static int[] createSortedData() {
        int[] data = new int[50];
        
        for (int i = 0; i < data.length; i++) 
            data[i] = i * 100;

        return data;
    }

    // Performs binary search on the first 10 multiples of the given number
    private static void testDataWithMultiplesOf(int[] data, int multiple) {
        System.out.printf("\nTesting data with the first 10 multiples of %d\n------------\n", multiple);

        for (int i = 1; i <= 10; i++)
            System.out.printf("Is %-4d inside the list: %b\n\n", i * multiple, performBinarySearch(data, i * multiple));
    }

    // Handles the Binary Search Algorithm
    private static boolean performBinarySearch(int[] data, int dataPoint) {
        int lowestIndex = 0;
        int highestIndex = data.length - 1;
        int middleIndex = (lowestIndex + highestIndex) / 2;

        while (lowestIndex <= highestIndex) {

            if (data[middleIndex] > dataPoint)
                highestIndex = middleIndex - 1;
            else if (data[middleIndex] < dataPoint)
                lowestIndex = middleIndex + 1;
            else if (data[middleIndex] == dataPoint)
                return true;

            middleIndex = (lowestIndex + highestIndex) / 2;
        }

        return false;
    } 

    // Prints out the entire the sorted list
    private static void printSortedData(int[] data) {

        System.out.println("\nCurrent List\n------------");

        for (int i = 0; i < data.length; i++) {
            if (i % 10 == 0)
                System.out.printf("\n%-6d", data[i]);
            else
                System.out.printf("%-6d", data[i]);
        }
        
        System.out.println();
    }
}