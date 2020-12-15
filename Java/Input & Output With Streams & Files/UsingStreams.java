import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class UsingStreams {
    UsingStreams(){}

    public static void main(String[] args) throws Exception {
        UsingStreams myClass = new UsingStreams();
        String readPath = "readerTest.txt";
        String writePath = "writerTest.txt";

        // myClass.readFromFileUsingInputStreams(readPath); 
        // myClass.readFromFileUsingInputReaders(readPath);   
        myClass.writeUsingFileWriter(writePath);
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
                // adds | if its not a Carriage return or new line character
                if(intVal != 13 && intVal != 10)
                    System.out.printf("%c |", intVal);
                else
                    System.out.printf("%c", intVal);
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


    /**
     * 
     * @param writePath
     */
    public void writeUsingFileWriter(String writePath) {
        System.out.println("--- Using FileWriter To Write 1 String at a time ---");

        String[] data = {
            "Starting Writer Test",
            "Writing 1",
            "Writing 1 2",
            "Writing 1 2 3",
            "Writing Testing Complete"
        };

        try (Writer writer = new FileWriter(writePath)) {
            for(String string : data){
                writer.write(string);
                writer.write('\n');
            }
        } catch (Exception e) {
            //TODO: handle exception
            handleExceptions(e);
        }
    }

    

    public void handleExceptions(Exception e) {
        System.out.printf("An Error Occurred: %s", e.getMessage());
    }
}
