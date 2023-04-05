import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class fileHandling {
	
	public static void main(String[] args) {
		boolean exit = false;
		Scanner getip = new Scanner(System.in);
		
		while (!exit) {
			System.out.println("Choose an option:");
			System.out.println("1. Create file");
			System.out.println("2. Write to file");
			System.out.println("3. Read from file ");
			System.out.println("4. Update file");
			System.out.println("5. Delete file");
			System.out.println("6. Exit");
			int option = getip.nextInt();
			
			switch (option) {
			case 1:
				createFile();
				break;
			case 2:
				writeFile();
				break;
			case 3:
				readFile();
				break;
			case 4:
				updateFile();
				break;
			case 5:
				deleteFile();
				break;
			case 6:
				exit = true;
				break;
			default:
				System.out.println("Galat option h be.");
			}
		}
		getip.close();
	}
	
	private static String takefilename() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the file name : ");
		String str = scan.nextLine();
//		scan.close();
		return str;
	}
	
	private static void createFile() {
		String str = takefilename();
		try {
			File file = new File(str);
			
			if(file.createNewFile()) {
				System.out.println("File created");
			}else {
				System.out.println("File already exist");
			}
		}catch(IOException e) {
			System.out.println("Error while creating file. Doabara try kar be");
		}
	}
	
	private static void writeFile() {
		String str = takefilename();
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(str))){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the text you want to write to the file ");
			String content = scanner.nextLine();
			writer.write(content);
			System.out.println("Successfully wrote to  the file");
		} catch (IOException e) {
			System.out.println("Error occured while writing to the file");
			e.printStackTrace();
		}
	}
	
	private static void readFile() {
		String str = takefilename();
		try(BufferedReader reader = new BufferedReader(new FileReader(str))){
			String line;
			while((line = reader.readLine())!=null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error occured while reading the file");
			e.printStackTrace();
		}
	}
	
	private static void updateFile() {
		String str = takefilename();
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(str, true))){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the text you want to append to the file ");
			String content = scanner.nextLine();
			writer.write("\n");
			writer.write(content);
			System.out.println("Successfully wrote to  the file");
		} catch (IOException e) {
			System.out.println("Error occured while writing to the file");
			e.printStackTrace();
		}
	}
	
	private static void deleteFile() {
		String str = takefilename();
		try {
			Files.deleteIfExists(Paths.get(str));
			System.out.println("File successfully deleted");
		}catch(IOException e) {
			System.out.println("Error: an error occured while deleting the file.");
			e.printStackTrace();
		}
	}
	
}
