import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;

public class FormatSpecifierPractice {
    public static void main(String[] args) throws IOException {
        commonFormatConversions();
        radixFormat();
        usingWidthZeroPaddingAndLeftJustify();
        groupSeparator();
        signedNumbers();
        argumentIndex();
        writeFormattedContentToStream();
    }

    private static void commonFormatConversions(){
        ToStringTester stringTester1 = new FormatSpecifierPractice.ToStringTester();
        printHeader("Common Format Conversions");
        printFormatSpecifierSyntax();

        System.out.printf("Decimal conversion of 32: %d\n", 32);
        System.out.printf("\nOctal conversion of 32: %o\n", 32);
        System.out.printf("\nHex conversion of 32: %x\n", 32);
        System.out.printf("\nFloating Point conversion of 32.5: %.2f\n", 32.5);
        System.out.printf("\nScientific Notation conversion of 32.5: %e\n", 32.5);
        System.out.printf("\nString conversion of some string: %s\n", "THIS IS THE STRING");
        System.out.printf("\nString conversion of Object toString Method: %s\n\n", stringTester1);


    }

    private static void radixFormat(){
        printHeader("Radix Format Flag: #");
        printFormatSpecifierSyntax();

        System.out.println("The # flag is used to show the radix of a number, aka the base");
        System.out.println("Octal base starts with a 0");
        System.out.println("Hexidecimal base starts with a 0x\n");

        System.out.printf("\nOctal conversion of 32 with Radix: %#o", 32);
        System.out.printf("\nHex conversion of 32 with Radix: %#x\n", 32);
    }

    private static void usingWidthZeroPaddingAndLeftJustify(){
        printHeader("Zero Padding & Left-Justify Format Flags: 0, -");
        printFormatSpecifierSyntax();

        System.out.println("All The numbers used here have a width of 4 to align them");
        System.out.println("The 0 flag is used to pad any empty space on the width of a number with 0's");
        System.out.println("The - flag is used to change from the default right justify alignment to left-justify");

        System.out.printf("\nTesting width for alignment: %4d", 32);
        System.out.printf("\nTesting width for alignment: %4d\n", 150);

        System.out.printf("\nTesting with zero padding: %04d", 32);
        System.out.printf("\nTesting with zero padding: %04d\n", 150);

        System.out.printf("\nTesting with left justify: %-4d", 32);
        System.out.printf("\nTesting with left justify: %-4d\n", 150);
    }

    private static void groupSeparator(){
        printHeader("Group Separator Format Flag: ,");
        printFormatSpecifierSyntax();

        System.out.println("The , flag is used to add commas into digits to make them for readable");

        System.out.printf("\nTesting Integer without grouping: %8d", 1250000);
        System.out.printf("\nTesting Float without grouping: %10.1f\n", 2340250.0);

        System.out.printf("\nTesting Integer with grouping: %,8d", 1250000);
        System.out.printf("\nTesting Float with grouping: %,8.1f\n", 2340250.0);
    }

    private static void signedNumbers(){
        printHeader("Signed Numbers Format Flag: <empty space>, +, (");
        printFormatSpecifierSyntax();

        System.out.println("The <empty space> flag leaves space for postive numbers or displays a negative sign for negative numbers");
        System.out.println("The + flag always shows the sign for the number");
        System.out.println("The ( flag encloses negative numbers in parenthesis");


        System.out.printf("\nTesting with <empty space> flag on positive number: % d", 1250000);
        System.out.printf("\nTesting with <empty space> flag on negative number: % d\n", -1250000);

        System.out.printf("\nTesting with + flag on positive number: %+d", 2250000);
        System.out.printf("\nTesting with + flag on negative number: %+d\n", -2250000);

        System.out.printf("\nTesting with ( flag on positive number: %(d", 3250000);
        System.out.printf("\nTesting with ( flag on negative number: %(d\n", -3250000);

        System.out.printf("\nTesting with ( & <empty space> flags on positive number: % (d", 4250000);
        System.out.printf("\nTesting with ( & <empty space> flags on negative number: % (d\n", -4250000);
    }

    private static void argumentIndex(){
        printHeader("Argument Indexes: index$, <");
        printFormatSpecifierSyntax();

        System.out.println("An Argument Index lets you specify which argument value you want for a particular format specifier");
        System.out.println("To specify an Argument Index you use index$");
        System.out.println("To use the same value as the previous format specier you use <");


        System.out.printf("\nTesting with no argument specifiers: %6d %3d %3d", 100, 200, 300);
        System.out.printf("\nTesting with index$ argument specifier: %3$3d %1$3d %2$3d", 100, 200, 300);
        System.out.printf("\nTesting with < argument specifier: %8d %<3d %3d\n\n", 100, 200, 300);

        System.out.println("No argument index is the common way of using argument indexes");
        System.out.println("The index$ is used during rare circumstances when dealing with complex string formats, be careful using it");
        System.out.println("The < argument index is used when we want to present the same value in different formats\n");
    }

    private static void writeFormattedContentToStream() throws IOException{
        printHeader("Write Formatted Content To Stream");

        BufferedWriter writer = Files.newBufferedWriter(Paths.get("FormattedContent.txt"));

        try (Formatter formatter = new Formatter(writer)) {
            for(int i = 0; i <= 2000; i += 100){
                int value = (i % 3 == 0) ? (i * -1) : i;
                formatter.format("Formatted Value is: %, d\n\n", value);
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.printf("An error occurd while writing to file: %s\n\n", e.getMessage());
        }
        System.out.println("Finished Writing to the file FormattedContent.txt\n");
    }


    // helper function for printing the header for each method call
    private static void printHeader(String title){
        // String header = String.format("%10s", title);
        System.out.println("\n------------------------------------------------");
        System.out.printf("%s\n", title);
        System.out.println("------------------------------------------------\n");
    }

    // helper function for printing the header for each method call
    private static void printFormatSpecifierSyntax() {
        System.out.println("Syntax of Format Specifier: %[argument_index$][flags][width][.precision]conversion\n");
    }

    // Nested class meant to test out %s conversion of toString method in an object
    private static class ToStringTester {
        public String toString() {
            return "toString method inside of ToStringTester";
        }
    }
}
