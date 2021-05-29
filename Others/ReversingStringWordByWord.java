import java.util.StringJoiner;

public class ReversingStringWordByWord {
    public static void main(String[] args) {
        String stringToReverse = " HELLO   WORLD! IS SUCH A   BEAUTIFUL DAY ";

        System.out.printf("\nOriginal String: %s\n\n", stringToReverse);
        System.out.printf("Reversed String: %s\n\n", reverseStringWithRegex(stringToReverse));
    }

    private static String reverseStringWithRegex(String originalString) {
        if (originalString.startsWith(" "))
            originalString = originalString.replaceFirst("\s+", "");

        StringJoiner reversed = new StringJoiner(" ");
        String[] wordsInOriginalString = originalString.split("\s+");
        
        for (int i = wordsInOriginalString.length - 1; i >= 0; i--)
            reversed.add(wordsInOriginalString[i]);
            
        return reversed.toString();
    }
}
