package mypack1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayWelcomeScreen();
        System.out.println("Enter the file Path: ");
        Scanner pathSc=new Scanner(System.in);
        String path=pathSc.nextLine();
        while (true) {
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                // Invalid input, continue to next iteration of loop
                scanner.nextLine(); // consume the remaining input
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    displayFiles(path);
                    break;
                case 2:
                    manageFiles();
                    break;
                case 3:
                    System.out.println("Thank you for using the File Manager!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayWelcomeScreen() {
        System.out.println("Welcome");
        System.out.println("Application Name: File Management");
        System.out.println("Developed by : Rupali Vaishnav");
        System.out.println("Please select one of the following options:");
        System.out.println("1. Display current file names in ascending order");
        System.out.println("2. Manage files in the directory list");
        System.out.println("3. Close the application");
    }

    private static void displayFiles(String pathScpath) {
        File currentDirectory = new File(pathScpath);
        ArrayList<String> filesList = new ArrayList<>();
        for (File file : currentDirectory.listFiles()) {
            if (file.isFile()) {
                filesList.add(file.getName());
            }
        }
        Collections.sort(filesList);
        for (String fileName : filesList) {
            System.out.println(fileName);
        }
    }

    private static void manageFiles() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please select one of the following options:");
            System.out.println("1. Add a file to the existing directory list");
            System.out.println("2. Delete a user specified file from the existing directory list");
            System.out.println("3. Search a user specified file from the main directory");
            System.out.println("4. Return to the main context");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                // Invalid input, continue to next iteration of loop
                scanner.nextLine(); // consume the remaining input
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter the file name to add: ");
                    String fileNameToAdd = scanner.next();
                    File fileToAdd = new File(fileNameToAdd);
                    try {
                    	if (fileToAdd.createNewFile()) {
                    		 System.out.println("File " + fileNameToAdd + " added successfully!");
                    	} else {
                    		  System.out.println("File is already exist in the directory.");  
                    	}
                       
                    } catch (Exception e) {
                        System.out.println("Error while adding the file: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter the file name to delete: ");
                    String fileNameToDelete = scanner.next();
                    File fileToDelete = new File(fileNameToDelete);
                    if (fileToDelete.exists()) {
                        if (fileToDelete.delete()) {
                            System.out.println("File " + fileNameToDelete + " deleted successfully!");
                        } else {
                            System.out.println("Error while deleting the file!");
                        }
                    } else {
                    	System.out.println("File doesnot Exist");
                    }
            }
        }
    }
}
