# FILE-HANDLING-UTILITY

**COMPANY**: CODTECH IT SOLUTIONS

**NAME**: Yash Yogesh Vasani

**INTERN ID**: CT12DL225

**DOMAIN**: JAVA PROGRAMMING

**DURATION**: 12 WEEKS

**MENTOR**: NEELA SANTOSH

**DESCRIPTION**:

# FileHandlingUtility Class Description

The `FileHandlingUtility` class is a Java program designed to perform basic file operations, including writing, appending, reading, and modifying text files. It provides a robust and user-friendly interface for handling text files with proper error handling, making it suitable for basic file manipulation tasks. The class includes four core methods for file operations and a main method that serves as an interactive console-based interface to demonstrate their usage. Below is a detailed explanation of the class, its methods, and its functionality.

## Overview
The `FileHandlingUtility` class is built to simplify common file operations in Java. It uses standard Java I/O classes like `BufferedWriter`, `FileWriter`, `BufferedReader`, and `FileReader` to manage file input and output efficiently. The class is designed with proper exception handling to manage errors such as file not found or permission issues, ensuring reliability. Each method is documented with JavaDoc comments, providing clarity on parameters, return values, and functionality. The main method includes a menu-driven interface that allows users to interact with the file operations through a command-line interface.

## Methods and Their Functionality

### 1. `writeToFile(String filePath, String content)`
This method writes the provided content to a specified file, overwriting any existing content. It takes two parameters:
- `filePath`: The path to the file where the content will be written.
- `content`: The string content to write to the file.

The method uses a `BufferedWriter` wrapped around a `FileWriter` to efficiently write the content. It employs a try-with-resources statement to ensure the file is properly closed after writing, preventing resource leaks. If the operation is successful, it prints a confirmation message and returns `true`. If an `IOException` occurs (e.g., due to an invalid path or lack of permissions), it prints an error message and returns `false`.

### 2. `appendToFile(String filePath, String content)`
This method appends content to an existing file without overwriting its current contents. It also takes `filePath` and `content` as parameters. The `FileWriter` is initialized with the append mode (`true`), ensuring that new content is added to the end of the file. Like `writeToFile`, it uses a `BufferedWriter` and try-with-resources for efficient and safe file handling. A newline character is added after the content to ensure proper formatting. The method returns `true` on success and `false` on failure, with appropriate console messages.

### 3. `readFromFile(String filePath)`
This method reads the contents of a specified file and returns them as a `List<String>`, where each element represents a line in the file. It uses a `BufferedReader` wrapped around a `FileReader` to read the file line by line. The lines are stored in an `ArrayList`, which is returned to the caller. If an error occurs (e.g., the file does not exist), an empty list is returned, and an error message is printed. A success message is displayed if the file is read successfully.

### 4. `modifyFileLine(String filePath, int lineNumber, String newContent)`
This method modifies a specific line in a file by replacing it with new content. It takes three parameters:
- `filePath`: The path to the file.
- `lineNumber`: The 1-based index of the line to modify.
- `newContent`: The new content to replace the specified line.

The method first reads all lines using `readFromFile`. It validates the `lineNumber` to ensure it is within the valid range. If valid, it updates the specified line in the list and rewrites the entire file with the modified content using a `BufferedWriter`. The method returns `true` on success and `false` if the line number is invalid or an error occurs during writing.

### 5. `main(String[] args)`
The `main` method provides an interactive console interface to demonstrate the file operations. It uses a `Scanner` to accept user input and presents a menu with five options:
1. Write to a file.
2. Append to a file.
3. Read from a file.
4. Modify a specific line in a file.
5. Exit the program.

For options 1 and 2, users input a file path and content (terminated by typing "END"). For option 3, the program displays the file's contents with line numbers. For option 4, users specify a file path, line number, and new content. The program handles invalid inputs (e.g., non-numeric line numbers) gracefully and continues running until the user chooses to exit.

## Error Handling and Features
The class incorporates robust error handling using try-catch blocks to manage `IOException`s and other potential issues. It provides informative console messages to guide users and report the success or failure of operations. The use of try-with-resources ensures that file resources are properly closed, reducing the risk of resource leaks. The interactive interface is user-friendly, allowing users to perform multiple operations in a single session.

## Use Cases
The `FileHandlingUtility` class is ideal for applications requiring basic text file manipulation, such as:
- Creating and updating configuration files.
- Logging data to files.
- Reading and processing text file contents.
- Modifying specific lines in files, such as updating a single record in a text-based database.

In summary, the `FileHandlingUtility` class is a versatile and reliable tool for performing essential file operations in Java, with a focus on ease of use, error handling, and clear documentation.

**OUTPUT**:

<img width="1440" height="900" alt="Image" src="https://github.com/user-attachments/assets/5bd8339c-c662-4093-824a-3d1924d6a22d" />
<img width="1440" height="900" alt="Image" src="https://github.com/user-attachments/assets/b5956396-646a-4d3b-8153-9fbfa5b7e216" />
