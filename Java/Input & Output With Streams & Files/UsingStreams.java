import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public class UsingStreams {
    UsingStreams(){}

    public static void main(String[] args) throws Exception {
        UsingStreams myClass = new UsingStreams();
        String readPath = "readerTest.txt";

        myClass.readFromFileUsingInputStreams(readPath); 
        myClass.readFromFileUsingInputReaders(readPath);   
    }

    public void readFromFileUsingInputStreams(String readPath) {
        readUsingFileInputStream(readPath);
        readUsingBufferedInputStream(readPath);
    }

    public void readFromFileUsingInputReaders(String readPath) {
        readFileUsingFileReader(readPath);
        readFileUsingBufferedReader(readPath);
    }


    /**
     *  _____________________________________________________________
     * |          Java InputStreams & OutputStreams Methods          |
     * |_____________________________________________________________|
     * 
     * InputStreams & OutputStrems are byte based Objects, meaning they read/write data as raw bytes
     */

    /**
     * Reads file 1 character at a time using FileInputStream & converts the byte value into characters
     * to display them to the screen
     * 
     * @param readPath
     */
    public void readUsingFileInputStream(String readPath) {
        System.out.println("--- Using FileInputStream To Read 1 Byte at a time ---");

        // Try/Catch with resources so that stream can be closed automatically 
        try (InputStream input = new FileInputStream(readPath)) {
            int intVal;

            System.out.println("\nASCII Value Of Each Byte:\n");
            // keep reading file until intVal = -1 which means the file ended
            while ((intVal = input.read()) >= 0)
                System.out.printf("%d|", (byte) intVal);
        } catch (Exception e) {
            // handle exception
            handleExceptions(e);
        }
    }

    /**
     * 
     * @param writePath
     */
    public void writeUsingFileOutputStream(String writePath) {
        
    }

    /**
     * Reads file 1024 characters per line by using a BufferredInputStream & stores those characters into a buffer
     * to then display the contents of the buffer into the screen
     * 
     * @param readPath
     */
    public void readUsingBufferedInputStream(String readPath) {
        // byte buff, because BufferedInputStreams reads the file in chunks of bytes buffer can hold 1024 characters because 1 byte = 1 char
        byte[] buffer = new byte[1024];
        System.out.println("\n\n--- Using BufferedInputStream To Read chunks of Bytes at a time ---");

        // Try/Catch with resources that layers a BufferedInputStream over a FileInputStream, & automatically closes both streams       
        try (InputStream input = new BufferedInputStream(new FileInputStream(readPath))) {
            int length;
            System.out.println("\nASCII Value Of Each Byte Read Into Buffer:\n");

            // Keeps reading characters into the buffer, and tells length the number of characters contained in the buffer 
            // until length = -1 which means end of file. Then prints out the content of the buffer
            while ((length = input.read(buffer)) >= 0) {
                for(int i = 0; i < length; i++) 
                    if ((int)buffer[i] == 10)
                        System.out.printf("%d|\n", buffer[i]);
                    else
                        System.out.printf("%d|", buffer[i]);
            }
        } catch (Exception e) {
            // handle exception
            handleExceptions(e);
        }

    }

    /**
     *  _____________________________________________________________
     * |          Java InputReader & OutputWriter Methods            |
     * |_____________________________________________________________|
     * 
     * InputReaders & OutputWriters are character based Objects, meaning they read/write data as characters
     */

    public void readFileUsingFileReader(String readPath) {
        System.out.println("\n\n--- Using FileReader To Read 1 char at a time ---");

        // Try/Catch with resources so that stream can be closed automatically 
        try (Reader input = new FileReader(readPath)) {
            int intVal;
            System.out.println("\nValue Of Each Char:\n");

            // keep reading file until intVal = -1 which means the file ended
            while ((intVal = input.read()) >= 0){
                char charVal = (char)intVal;
                System.out.printf("%c |", charVal);
                // System.out.printf("%d |", intVal);
            }
        } catch (Exception e) {
            // handle exception
            handleExceptions(e);
        }
    }

    public void readFileUsingBufferedReader(String readPath) {
        char[] buffer = new char[1024];
        System.out.println("\n\n--- Using BufferedReader To Read chunks of char at a time ---");

        // Try/Catch with resources that layers a BufferedInputStream over a FileInputStream, & automatically closes both streams       
        try (Reader input = new BufferedReader(new FileReader(readPath)) ) {
            int length;
            System.out.println("\nEach line of characters represents the chars stored in the Buffer:\n");

            // Keeps reading characters into the buffer, and tells length the number of characters contained in the buffer 
            // until length = -1 which means end of file. Then prints out the content of the buffer
            while ((length = input.read(buffer)) >= 0) {
                for(int i = 0; i < length; i++) 
                    System.out.printf("%c", buffer[i]);
            }
        } catch (Exception e) {
            // handle exception
            handleExceptions(e);
        }
    }

    public void writeToFile() {
        
    }

    public void appendToFileAndReadIt() {
        
    }

    public void deleteOutputFile() {
        
    }

    public void handleExceptions(Exception e) {
        System.out.printf("An Error Occurred: %s", e.getMessage());
    }
}
