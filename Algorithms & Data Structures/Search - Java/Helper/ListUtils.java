package Helper;

public class ListUtils {
    
    private static final String TEXT_BLUE = "\u001B[34m";
    private static final String TEXT_RESET = "\u001B[0m";


    /* 
        -------------------------------------------------------------------------------------------------------------------------
                                        Print List Methods
        -------------------------------------------------------------------------------------------------------------------------
    */

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
