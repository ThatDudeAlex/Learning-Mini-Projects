import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;

// This Class holds various methods, that I used to practice using Format Specifiers 

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


    // Prints out messages for the most commonly used format specifiers
    private static void commonFormatConversions(){

        // Objects who's toString() Method will be printed out
        ToStringTester stringTester1 = new FormatSpecifierPractice.ToStringTester();
        
        // Prints Method Header & General Syntax for Format Specifiers 
        printHeader("Common Format Conversions");
        printFormatSpecifierSyntax();

        // %d for formatting Integer values
        System.out.printf("Decimal conversion of 32: %d\n", 32);
        // %o for formatting Octal values
        System.out.printf("\nOctal conversion of 32: %o\n", 32);
        // %x or %X for formatting Hexadecimal values
        System.out.printf("\nHex conversion of 32: %x\n", 32);
        // %f for formatting Floating-Point values, with a .2 precision (Aka number of decimals to show)
        System.out.printf("\nFloating Point conversion of 32.5: %.2f\n", 32.5);
        // %e for formatting Integer or Floating-Point values into Scientific Notation
        System.out.printf("\nScientific Notation conversion of 32.5: %e\n", 32.5);
        // %s for formatting String values
        System.out.printf("\nString conversion of some string: %s\n", "THIS IS THE STRING");
        // %s can also be used on an Object to format the Object's toString() Method
        System.out.printf("\nString conversion of Object toString Method: %s\n\n", stringTester1);
    }

    // Prints out messages that show the Radix (Aka: base value) of numbers
    private static void radixFormat(){

        // Prints Method Header & General Syntax for Format Specifiers
        printHeader("Radix Format Flag: #");
        printFormatSpecifierSyntax();

        // Print Method Description
        System.out.println("The # flag is used to show the radix of a number, aka the base");
        System.out.println("Octal base starts with a 0");
        System.out.println("Hexidecimal base starts with a 0x\n");

        // #o for showing the base of Octal values, in the form: 0<Octal-Value>
        System.out.printf("\nOctal conversion of 32 with Radix: %#o", 32);
        // #o for showing the base of Hexadecimal values, in the form: 0x<Hex-Value>
        System.out.printf("\nHex conversion of 32 with Radix: %#x\n", 32);
    }

    // Prints out messages that use width, zero-padding, & left-justify format specifiers 
    private static void usingWidthZeroPaddingAndLeftJustify(){

        // Prints Method Header & General Syntax for Format Specifiers
        printHeader("Zero Padding & Left-Justify Format Flags: 0, -");
        printFormatSpecifierSyntax();

        // Print Method Description
        System.out.println("All The numbers used here have a width of 4 to align them");
        System.out.println("The 0 flag is used to pad any empty space on the width of a number with 0's");
        System.out.println("The - flag is used to change from the default right justify alignment to left-justify");

        // Uses a witdh of 4 on the specifier to helps align the values
        System.out.printf("\nTesting width for alignment: %4d", 32);
        System.out.printf("\nTesting width for alignment: %4d\n", 150);

        // Uses a witdh of 6 on the specifier to helps align the values
        // Also uses the '0' flag, to pad empty spaces with 0's
        System.out.printf("\nTesting with zero padding: %06d", 32);
        System.out.printf("\nTesting with zero padding: %06d\n", 150);

        // Uses a width of 3 because you need to specify a with when using the '-' flag
        // The '-' flag prints the values as left-justify, meaning they start from the left
        System.out.printf("\nTesting with left justify: %-3d", 32);
        System.out.printf("\nTesting with left justify: %-3d\n", 150);
    }

    // Prints out messages that use a comma for large numberic values
    private static void groupSeparator(){

        // Prints Method Header & General Syntax for Format Specifiers
        printHeader("Group Separator Format Flag: ,");
        printFormatSpecifierSyntax();

        // Print Method Description
        System.out.println("The , flag is used to add commas into digits to make them for readable");

        // prints messages without comma
        System.out.printf("\nTesting Integer without grouping: %8d", 1250000);
        System.out.printf("\nTesting Float without grouping: %10.1f\n", 2340250.0);

        // prints messages with the comma included 
        System.out.printf("\nTesting Integer with grouping: %,8d", 1250000);
        System.out.printf("\nTesting Float with grouping: %,8.1f\n", 2340250.0);
    }

    // Prints out messages with positive & negative values 
    private static void signedNumbers(){

        // Prints Method Header & General Syntax for Format Specifiers
        printHeader("Signed Numbers Format Flag: <empty space>, +, (");
        printFormatSpecifierSyntax();

        // Print Method Description
        System.out.println("The <empty space> flag leaves space for postive numbers or displays a negative sign for negative numbers");
        System.out.println("The + flag always shows the sign for the number");
        System.out.println("The ( flag encloses negative numbers in parenthesis");

        // Uses the <empty space> flag to skip the sign of positive value, so that the numbers can be aligned
        System.out.printf("\nTesting with <empty space> flag on positive number: % d", 1250000);
        System.out.printf("\nTesting with <empty space> flag on negative number: % d\n", -1250000);

        // Uses the '+' flag so that the signs for either positive or negative values is displayed 
        System.out.printf("\nTesting with + flag on positive number: %+d", 2250000);
        System.out.printf("\nTesting with + flag on negative number: %+d\n", -2250000);

        // Uses the '(' flag so that negative numbers are enclosed in parenthesis: (Negative-Number)
        System.out.printf("\nTesting with ( flag on positive number: %(d", 3250000);
        System.out.printf("\nTesting with ( flag on negative number: %(d\n", -3250000);

        // Combines the <empty space> flag & the '(' flag to align the values together
        System.out.printf("\nTesting with ( & <empty space> flags on positive number: % (d", 4250000);
        System.out.printf("\nTesting with ( & <empty space> flags on negative number: % (d\n", -4250000);
    }

    // Prints out messages that specified and Argument Index in their format specifier
    private static void argumentIndex(){

        // Prints Method Header & General Syntax for Format Specifiers
        printHeader("Argument Indexes: index$, <");
        printFormatSpecifierSyntax();

        // Print Method Description
        System.out.println("An Argument Index lets you specify which argument value you want for a particular format specifier");
        System.out.println("To specify an Argument Index you use index$");
        System.out.println("To use the same value as the previous format specier you use <");

        // Print message without using argument indexes
        System.out.printf("\nTesting with no argument specifiers: %6d %3d %3d", 100, 200, 300);
        // Uses agument indexes (value$) to select the 3rd values to be printed first, the 1th value second, and the 2nd value last
        System.out.printf("\nTesting with index$ argument specifier: %3$3d %1$3d %2$3d", 100, 200, 300);
        // Uses the '<' agument index flag, to select the previous specifier value as the 2nd value & then continues the sequence for the 3rd value
        System.out.printf("\nTesting with < argument specifier: %8d %<3d %3d\n\n", 100, 200, 300);

        // Final Thoughts
        System.out.println("No argument index is the common way of using argument indexes");
        System.out.println("The index$ is used during rare circumstances when dealing with complex string formats, be careful using it");
        System.out.println("The < argument index is used when we want to present the same value in different formats\n");
    }

    // Writes to a file, using format specifiers 
    private static void writeFormattedContentToStream() throws IOException{
        
        // Prints Method Header & General Syntax for Format Specifiers
        printHeader("Write Formatted Content To Stream");
        printFormatSpecifierSyntax();

        // creates the BufferedWriter stream that will be used
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("FormattedContent.txt"));

        // try-with-resources that wraps the BufferedWriter into the Formatter class, so that it can write formatted Strings to a file
        try (Formatter formatter = new Formatter(writer)) {
            for(int i = 0; i <= 2000; i += 100){
                // makes i negative if its divisible by 3
                int value = (i % 3 == 0) ? (i * -1) : i;
                // writes the formatted string to the file
                formatter.format("Formatted Value is: %, d\n\n", value);
            }
        } catch (Exception e) {
            // handle exception
            System.out.printf("An error occurd while writing to file: %s\n\n", e.getMessage());
        }

        // Message to give user some context
        System.out.println("Finished Writing to the file FormattedContent.txt\n");
    }


    // helper function for printing the header for each method call
    private static void printHeader(String title){
        System.out.println("\n------------------------------------------------");
        System.out.printf("%s\n", title);
        System.out.println("------------------------------------------------\n");
    }

    // helper function for printing the specifier syntax for each method call
    private static void printFormatSpecifierSyntax() {
        // conversion: Is the value we want to conver to, for ex: a integer, decimal, hex, string, etc..
        // [.precision]: Is how many decimal points we want in a floating-point value, for example 2.5 instead of 2.500
        // [width]: Is the minimum number of space we want the format specier to take
        // [flags]: Is for format specifier flags that can alter the behavior of the string, for example the ',' flag to put commas into numbers: 1,000
        // [argument_index$]: Is for selecting which argument you want to use for that specific format specifier
        System.out.println("Syntax of Format Specifier: %[argument_index$][flags][width][.precision]conversion\n");
    }

    // Nested class meant to test out %s conversion of the toString() method in an object
    private static class ToStringTester {
        public String toString() {
            return "toString method inside of ToStringTester";
        }
    }
}
