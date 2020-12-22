import java.util.StringJoiner;

// This Class holds various methods, that I used to practice using 
// StringJoiner under different circumstaces 

public class StringJoinerPractice {

    public static void main(String[] args) {
        simpleCommaSequence();
        simpleCurrencySequence();
        fancySequence();
        singleValueEdgeCase1();
        singleValueEdgeCase2();
        noValueEdgeCase1();
        noValueEdgeCase2();
        noValueEdgeCaseWithEmptyHandling1();
        noValueEdgeCaseWithEmptyHandling2();
        noValueEdgeCaseWithEmptyHandlingError1();
        noValueEdgeCaseWithEmptyHandlingError2();
    }

    // Uses StringJoiner with only a separator, to seperate a list of integer with a comma & a space
    private static void simpleCommaSequence() {

        StringJoiner stringJoiner = new StringJoiner(", ");

        for(int i = 0; i <= 20; i++)
            stringJoiner.add(Integer.toString(i));

        printHeader("simpleCommaSequence");
        System.out.println(stringJoiner.toString());
    }

    // Uses StringJoiner with a separator & start/end strings, to represent a list of dollar values separated by a comma & space
    private static void simpleCurrencySequence() {

        StringJoiner stringJoiner = new StringJoiner(", $", "$", "");

        for(int i = 100; i <= 2000; i+=100)
            stringJoiner.add(Integer.toString(i));

        printHeader("simpleCurrencySequence");
        System.out.println(stringJoiner.toString());
    }

    // Uses StringJoiner with a separator & start/end strings, to represent a fancy list of dollar values
    // Each dollar value is enclosed in [] and separated by a comma & space 
    private static void fancySequence() {

        StringJoiner stringJoiner = new StringJoiner("], [$", "[$", "]");

        for(int i = 100; i <= 1500; i+=100)
            stringJoiner.add(Integer.toString(i));

        printHeader("fancySequence");
        System.out.println(stringJoiner.toString());
    }

    // Testing edge-case 1 when using StringJoiner with a single value
    // edge-case 1: when constructed with separator only, returns the value added
    private static void singleValueEdgeCase1() {

        StringJoiner stringJoiner = new StringJoiner(", ");
        stringJoiner.add("mySingleValue");

        printHeader("singleValueEdgeCase1");
        System.out.println(stringJoiner.toString());
    }

    // Testing edge-case 2 when using StringJoiner with a single value
    // edge-case 2: when constructed with separator & start/end strings, returns the value added
    // within the start/end strings
    private static void singleValueEdgeCase2() {

        StringJoiner stringJoiner = new StringJoiner("], [$", "[$", "]");
        stringJoiner.add("mySingleValue");

        printHeader("singleValueEdgeCase2");
        System.out.println(stringJoiner.toString());
    }


    // Testing edge-case 1 when using StringJoiner with no value added
    // edge-case 1: when constructed with separator only, returns an empty string
    private static void noValueEdgeCase1() {

        StringJoiner stringJoiner = new StringJoiner(", ");

        printHeader("noValueEdgeCase1");
        System.out.println(stringJoiner.toString());
    }

    // Testing edge-case 2 when using StringJoiner with no value added
    // edge-case 2: when constructed with separator & start/end strings, returns a string
    // with start/end values only
    private static void noValueEdgeCase2() {

        StringJoiner stringJoiner = new StringJoiner("], [$", "[$", "]");

        printHeader("noValueEdgeCase2");
        System.out.println(stringJoiner.toString());
    }

    // Testing edge-case 1 when using StringJoiner with no value added with a set default value when empty
    // when no value added & only using a separator, print out the set empty value
    private static void noValueEdgeCaseWithEmptyHandling1() {

        StringJoiner stringJoiner = new StringJoiner(", ");
        stringJoiner.setEmptyValue("THIS SEQUENCE WAS EMPTY");

        printHeader("noValueEdgeCaseWithEmptyHandling1");
        System.out.println(stringJoiner.toString());
    }

    // Testing edge-case 2 when using StringJoiner with no value added with a set default value when empty
    // when no value added using a separator & start/end strings, still print out the set empty value
    private static void noValueEdgeCaseWithEmptyHandling2() {

        StringJoiner stringJoiner = new StringJoiner("], [$", "[$", "]");
        stringJoiner.setEmptyValue("THIS SEQUENCE WAS EMPTY");

        printHeader("noValueEdgeCaseWithEmptyHandling2");
        System.out.println(stringJoiner.toString());
    }

    // setEmptyValue() only works when add() is never called on the StringJoiner
    // Testing edge-case 1 when using StringJoiner with no value with a set default value when empty & adding an empty string
    // when no value added & only using a separator, prints out the empty string just like if using a single value
    private static void noValueEdgeCaseWithEmptyHandlingError1() {

        StringJoiner stringJoiner = new StringJoiner(",");
        
        stringJoiner.add("");
        stringJoiner.setEmptyValue("THIS SEQUENCE WAS EMPTY");

        printHeader("noValueEdgeCaseWithEmptyHandling2");
        System.out.println(stringJoiner.toString());
    }

    // setEmptyValue() only works when add() is never called on the StringJoiner
    // Testing edge-case 2 when using StringJoiner with no value added with a set default value when empty & adding an empty string
    // when no value added using a separator & start/end strings, prints out the start/end string just like when using single value
    private static void noValueEdgeCaseWithEmptyHandlingError2() {

        StringJoiner stringJoiner = new StringJoiner("], [$", "[$", "]");
        
        stringJoiner.add("");
        stringJoiner.setEmptyValue("THIS SEQUENCE WAS EMPTY");

        printHeader("noValueEdgeCaseWithEmptyHandling2");
        System.out.println(stringJoiner.toString());
    }

    // helper function for printing the header for each method call
    private static void printHeader(String title){
        System.out.println("\n----------------------------------------------");
        System.out.printf("|      %s          \n", title);
        System.out.println("----------------------------------------------\n");
    }


}