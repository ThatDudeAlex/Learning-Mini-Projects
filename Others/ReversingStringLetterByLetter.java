
public class ReversingStringLetterByLetter {
    public static void main(String[] args) {
        String stringToReverse = "HELLO WORLD! IS SUCH A BEAUTIFUL DAY";

        
        System.out.printf("\nOriginal Sting: %s\n\n", stringToReverse);
        System.out.printf("Reversed String: %s\n\n", reverseString(stringToReverse));
    }

    private static String reverseString(String originalString) {
        StringBuilder reversed = new StringBuilder();
        
        for (int i = originalString.length() - 1; i >= 0; i--)
            reversed.append(originalString.charAt(i));
        return reversed.toString();
    }
}