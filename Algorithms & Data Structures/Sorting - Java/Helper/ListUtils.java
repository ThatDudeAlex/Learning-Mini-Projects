package Helper;

public class ListUtils {
    

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

    /* 
        -------------------------------------------------------------------------------------------------------------------------
                                        Print List Methods
        -------------------------------------------------------------------------------------------------------------------------
    */

    // Prints every number in an array, each number will have a width of 5 and be left-justified 
    public static void printList(int[] list) {
        displayList(list, 0, list.length - 1);
    }

    // Prints every number between the 2 bounds in the array, each number will have a width of 5 and be left-justified 
    public static void printListBetweenBounds(int[] list, int lowerBound, int higherBound) {
        displayList(list, lowerBound, higherBound);
    }

    private static void displayList(int[] list, int lowerBound, int higherBound) {
        StringBuilder listOutput = new StringBuilder();
        
        for (int i = lowerBound, j = 0; i <= higherBound; i++, j++)
            if ((i != 0) && (j % 10 == 0))
                listOutput.append(String.format("\n%-10d", list[i]));
            else 
                listOutput.append(String.format("%-10d", list[i]));
                
        System.out.println(listOutput.append("\n").toString());
    }

    /* 
        -------------------------------------------------------------------------------------------------------------------------
                                        Header Methods
        -------------------------------------------------------------------------------------------------------------------------
    */

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
