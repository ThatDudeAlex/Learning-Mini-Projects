import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UsingZipFileSystem {
    
    UsingZipFileSystem(){}

    public static void main(String[] args){
        try (FileSystem zipFs = openZip(Paths.get("testZip.zip"));) {
            createFile();
            copyToZip(zipFs);
            writeToFileInZip(zipFs);
        } catch (Exception e) {
            //TODO: handle exception
            handleExceptions(e);
        }
    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri, providerProps);

        return zipFs;
    }

    
    private static void copyToZip(FileSystem zipFs) throws IOException {
        Path sourceFile = Paths.get("fileForZip.txt");
        Path destinationFile = zipFs.getPath("/fileForZipCopied.txt");
        
        Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }
    
    private static void writeToFileInZip(FileSystem zipFs) throws IOException {
        String[] data = {
            "Starting Writing Directly to ZipFile Test",
            "Zip 1",
            "Zip 1 2",
            "Zip 1 2 3",
            "Testing Complete"
        };

        Files.write(zipFs.getPath("newFileWritten.txt"), Arrays.asList(data), StandardOpenOption.CREATE);
    }
    
    private static void createFile() throws Exception {
        String[] data = {
            "Starting ZipFile Test",
            "Writing 1",
            "Writing 1 2",
            "Writing 1 2 3",
            "ZipFile Testing Complete"
        };
        Path path = Paths.get("fileForZip.txt");
        
        Files.write(path, Arrays.asList(data));
        System.out.println("\nFinished Writing To fileForZip.txt");
    }
    
    private static void handleExceptions(Exception e) {
        System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
