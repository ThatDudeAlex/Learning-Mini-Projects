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
        for (int i = 0; i < list.length; i++)
            if ((i != 0) && (i % 10 == 0))
                System.out.printf("\n%-6d  ", list[i]);
            else 
                System.out.printf("%-6d  ", list[i]);
        System.out.println("\n");
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
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < headerMsg.length() + 6; i++)
            stringBuilder.append("=");

        return stringBuilder.toString();
    }
}
