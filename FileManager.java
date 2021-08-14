import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

	static Scanner scanner = new Scanner(System.in);
	static String filePath = "Files";

	public static ArrayList<String> getAllFileNames() {

		// get file folder
		File fileFolder = new File(filePath);

		// get all files under file folder and put them in an array
		File[] fileArray = fileFolder.listFiles();

		// create a new list to store the file names
		ArrayList<String> fileNames = new ArrayList<String>();

		// iterate through the file array, and assign each file name to the list
		for (File file : fileArray) {
			String fileName = file.getName();
			fileNames.add(fileName);
		}

		return fileNames;
	}

	public static void addFile() {
		System.out.println("Please enter a file name: ");
		String input = scanner.nextLine();

		try {
			File file = new File(filePath + "/" + input);
			file.createNewFile();
			System.out.println("File inserted successfully!");
		} catch (Exception e) {
			System.out.println("Error! Could not create file.");
		}
		Main.displayFileOptions();
	}

	public static void deleteFile() {
		System.out.println("Please enter a file name: ");
		String input = scanner.nextLine();

		try {
			File file = new File(filePath + "/" + input);
			if (file.delete()) {
				System.out.println("File deleted successfully!");
			}
			else {
				System.out.println("Error! File does not exist.");
			}
		} catch (Exception e) {
			System.out.println("Error! File does not exist.");
		}
		Main.displayFileOptions();
	}

	public static void searchFile() {
		System.out.println("Please enter a file name: ");
		String input = scanner.nextLine();

		try {
			File file = new File(filePath + "/" + input);
			System.out.println(file.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("Error! File does not exist.");
		}
		Main.displayFileOptions();
	}

}
