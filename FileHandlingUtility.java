import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // Method to write content to a file
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nFile Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file content (replace a word)
    public static void modifyFile(String fileName, String oldWord, String newWord) {
        File file = new File(fileName);
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Read existing content
            while ((line = reader.readLine()) != null) {
                content.append(line.replace(oldWord, newWord)).append("\n");
            }

            // Write modified content back to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content.toString());
            }

            System.out.println("File modified successfully.");

        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = "sample.txt";

        // Writing to file
        System.out.println("Enter text to write into file:");
        String inputText = scanner.nextLine();
        writeFile(fileName, inputText);

        // Reading from file
        readFile(fileName);

        // Modifying file
        System.out.println("\nEnter word to replace:");
        String oldWord = scanner.nextLine();

        System.out.println("Enter new word:");
        String newWord = scanner.nextLine();

        modifyFile(fileName, oldWord, newWord);

        // Reading modified file
        readFile(fileName);

        scanner.close();
    }
}