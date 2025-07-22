import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * FileHandlingUtility class provides methods to perform basic file operations:
 * reading, writing, and modifying text files with proper error handling.
 */
public class FileHandlingUtility{
    
    /**
     * Writes content to a specified file.
     * @param filePath The path to the file
     * @param content The content to write
     * @return boolean indicating success or failure
     */
    public static boolean writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Successfully wrote to file: " + filePath);
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Appends content to an existing file.
     * @param filePath The path to the file
     * @param content The content to append
     * @return boolean indicating success or failure
     */
    public static boolean appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Successfully appended to file: " + filePath);
            return true;
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Reads content from a specified file.
     * @param filePath The path to the file
     * @return List of strings containing file lines, or empty list if error occurs
     */
    public static List<String> readFromFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("Successfully read from file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return lines;
    }
    
    /**
     * Modifies specific line in a file by replacing it with new content.
     * @param filePath The path to the file
     * @param lineNumber The line number to modify (1-based index)
     * @param newContent The new content for the line
     * @return boolean indicating success or failure
     */
    public static boolean modifyFileLine(String filePath, int lineNumber, String newContent) {
        List<String> lines = readFromFile(filePath);
        
        if (lineNumber < 1 || lineNumber > lines.size()) {
            System.err.println("Invalid line number: " + lineNumber);
            return false;
        }
        
        lines.set(lineNumber - 1, newContent);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Successfully modified line " + lineNumber + " in file: " + filePath);
            return true;
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Main method demonstrating usage of file handling operations.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nFile Handling Utility - Choose an option:");
            System.out.println("1. Write to file");
            System.out.println("2. Append to file");
            System.out.println("3. Read from file");
            System.out.println("4. Modify a line in file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter file path: ");
                    String writePath = scanner.nextLine();
                    System.out.println("Enter content to write (end with a single line containing only 'END'):");
                    StringBuilder writeContent = new StringBuilder();
                    while (true) {
                        String line = scanner.nextLine();
                        if (line.equals("END")) break;
                        writeContent.append(line).append("\n");
                    }
                    writeToFile(writePath, writeContent.toString().trim());
                    break;
                case "2":
                    System.out.print("Enter file path: ");
                    String appendPath = scanner.nextLine();
                    System.out.println("Enter content to append (end with a single line containing only 'END'):");
                    StringBuilder appendContent = new StringBuilder();
                    while (true) {
                        String line = scanner.nextLine();
                        if (line.equals("END")) break;
                        appendContent.append(line).append("\n");
                    }
                    appendToFile(appendPath, appendContent.toString().trim());
                    break;
                case "3":
                    System.out.print("Enter file path: ");
                    String readPath = scanner.nextLine();
                    List<String> lines = readFromFile(readPath);
                    if (lines.isEmpty()) {
                        System.out.println("No content or file not found.");
                    } else {
                        System.out.println("\nFile contents:");
                        for (int i = 0; i < lines.size(); i++) {
                            System.out.println("Line " + (i + 1) + ": " + lines.get(i));
                        }
                    }
                    break;
                case "4":
                    System.out.print("Enter file path: ");
                    String modPath = scanner.nextLine();
                    System.out.print("Enter line number to modify: ");
                    int lineNum = -1;
                    try {
                        lineNum = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid line number.");
                        break;
                    }
                    System.out.println("Enter new content for the line:");
                    String newContent = scanner.nextLine();
                    modifyFileLine(modPath, lineNum, newContent);
                    break;
                case "5":
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}