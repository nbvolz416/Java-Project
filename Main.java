import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		displayWelcome();
		displayLoginMenu();
	}
	
	public static void displayWelcome() {
		System.out.println("Welcome!");
		System.out.println("OOPS final project by Nick");
	}
	
	public static void displayLoginMenu() {
		System.out.println("");
		System.out.println("LOGIN MAIN MENU");
		System.out.println("1. Login");
		System.out.println("2. Create Login");
		System.out.println("3. Quit");
		System.out.println("");
		
		while(true) {
			System.out.println("Enter option (1-3): ");
			String input = scanner.nextLine();
			if(input.equals("1")) {
				login();
				break;
			}
			else if(input.equals("2")) {
				createLogin();
				break;
			}
			else if(input.equals("3")) {
				System.out.println("Goodbye!");
				break;
			}
			else {
				System.out.println("Error - please enter valid menu option");
			}
		}
	}
	
	public static void login() {
		System.out.println("");
		System.out.println("Username: ");
		String username = scanner.nextLine();
		
		try {
			File file = new File("Accounts/" + username);
			
			if(file.exists()) {
				System.out.println("Password: ");
				String password = scanner.nextLine();
				
				Scanner fileScanner = new Scanner(file);
				String userPassword = fileScanner.nextLine();
				fileScanner.close();
				
				if(password.equals(userPassword)) {
					System.out.println("Login successful!");
					displayMainMenu();
				}
				else {
					System.out.println("Login failed!");
					displayLoginMenu();
				}
				
			}
			else {
				System.out.println("Username does not exist");
				displayLoginMenu();
			}
		}
		catch(Exception e) {
			System.out.println("Error! Invalid username");
		}
		
	}
	
	public static void createLogin() {
		System.out.println("");
		System.out.println("Enter a username: ");
		String username = scanner.nextLine();
		
		System.out.println("Enter a password: ");
		String password = scanner.nextLine();
		
		try {
			File file = new File("Accounts/" + username);
			if(file.exists() == false) {
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(password);
				fileWriter.close();

				System.out.println("Account created successfully!");
			}
			else{
				System.out.println("Account already exists");
			}
		}
		catch(Exception e) {
			System.out.println("Error! Account creation failed!");
		}
		displayLoginMenu();
	}
	
	public static void displayMainMenu() {
		System.out.println("");
		System.out.println("MAIN MENU");
		System.out.println("1. Retrieve file names");
		System.out.println("2. Display file options");
		System.out.println("3. Quit");
		System.out.println("");
		
		while(true) {
			System.out.println("Enter option (1-3): ");
			String input = scanner.nextLine();
			if(input.equals("1")) {
				retrieveFileNames();
				break;
			}
			else if(input.equals("2")) {
				displayFileOptions();
				break;
			}
			else if(input.equals("3")) {
				System.out.println("Goodbye!");
				break;
			}
			else {
				System.out.println("Error - please enter valid menu option");
			}
		}
	}
	
	public static void retrieveFileNames() {
		System.out.println("");
		try {
			ArrayList<String> fileNamesList = FileManager.getAllFileNames();
			if(fileNamesList.size() > 0) {
				for(String fileName : fileNamesList) {
					System.out.println(fileName);
				}
			}
			else {
				System.out.println("No files found.");
			}
			System.out.println("");
		}
		catch(Exception e) {
			System.out.println("Error! Path does not exist!");
		}
		displayMainMenu();
	}
	
	public static void displayFileOptions() {
		System.out.println("");
		System.out.println("FILE OPTIONS");
		System.out.println("1. Add file");
		System.out.println("2. Delete file");
		System.out.println("3. Search file");
		System.out.println("4. Go to main menu");
		System.out.println("");
		
		while(true) {
			System.out.println("Enter option (1-4): ");
			String input = scanner.nextLine();
			if(input.equals("1")) {
				FileManager.addFile();
				break;
			}
			else if(input.equals("2")) {
				FileManager.deleteFile();
				break;
			}
			else if(input.equals("3")) {
				FileManager.searchFile();
				break;
			}
			else if(input.equals("4")) {
				displayMainMenu();
				break;
			}
			else {
				System.out.println("Error - please enter valid menu option");
			}
		}
	}

}
