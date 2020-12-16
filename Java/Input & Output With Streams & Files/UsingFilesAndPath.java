import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

// Small program to practice working with files, using Path & Files types
public class UsingFilesAndPath {

    // Constructor 
    UsingFilesAndPath(){}

    public static void main(String[] args) throws Exception {
        UsingFilesAndPath reader = new UsingFilesAndPath();

        // get object representation of file paths 
        Path readPath = Paths.get("readerTest.txt");
        Path writePath = Paths.get("usingFilesAndPath.txt");

        reader.readFromFile(readPath);
        reader.writeToFile(writePath);
        reader.appendToFileAndReadIt(readPath, writePath);
        reader.deleteOutputFile(writePath);
    }


    // Reads all the lines in readerTest.txt and prints them to the console
    private void readFromFile(Path path) throws Exception{
        List<String> lines = Files.readAllLines(path);

        for(String line : lines) 
            System.out.println(line);

    }

    // Writes the data array into writerTest.txt 
    private void writeToFile(Path path) throws Exception {
        String[] data = {
            "Starting Writer Test",
            "Writing 1",
            "Writing 1 2",
            "Writing 1 2 3",
            "Writing Testing Complete"
        };

        Files.write(path, Arrays.asList(data));
        System.out.println("\nFinished Writing To File");
    }

    // Appends the contents of the readerTest.txt file into the writerTest.txt file,
    // then opens & reads writerTest.txt to print it to the console
    private void appendToFileAndReadIt(Path readPath, Path writePath) throws Exception{
        System.out.println("\n--- Preparing Read/Write Pipeline ---\n");

        List<String> data = new ArrayList<>();
        data.add("\n -- Appended readInput --\n");
        data.addAll(Files.readAllLines(readPath));

        Files.write(writePath, data, StandardOpenOption.APPEND);
        readFromFile(writePath);

        System.out.println("\n--- Finished Read/Write Pipeline ---");
    }

    // Clean up by deleting writerTest.txt
    private void deleteOutputFile(Path path) throws Exception{
        Files.delete(path);
        System.out.printf("\nPath: %s was just deleted", path.toString());
    }
}