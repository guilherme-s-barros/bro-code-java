import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        var filePath = "test.txt";
        var textContent = """
                          Roses are Red
                          Violets are Blue
                          """;

        try (var writer = new FileWriter(filePath)) {
            writer.write(textContent);
            System.out.println("File has been written.");
        } catch (FileNotFoundException exception) {
            System.out.println("Could not locate file location.");
        } catch (IOException exception) {
            System.out.println("Could not write file.");
        }
    }
}
