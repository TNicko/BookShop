
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class ActivityLogging extends Main{
	
	ActivityLogging() throws FileNotFoundException {
		super();
	}
	
	static String bookISBN;
	static String bookPrice;
	static String userID;
	static String userPostcode;
	
	static void booksInBasket(String status, String paymentMethod) throws FileNotFoundException {
		
		// Gets userID and postcode 
		FileReader userData = new FileReader("UserAccounts.txt");
		Scanner userScanner = new Scanner(userData);
		while (userScanner.hasNextLine()) {
			String[] userInfo = userScanner.nextLine().split(", ");
			if (userInfo[1].equals(panel1.user)) {
				userID = userInfo[0];
				userPostcode = userInfo[4];
			}
		}
		userScanner.close();
		
		// Gets Date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		
		
		//Creates the ActivityLog for each book in basket
		ArrayList<String> bookLogs = new ArrayList<String>();
		ArrayList<String> books = new ArrayList<String>();
		int start = 0;
		for (String line : panel3.basketList.getText().split("\r\n")) {
			int bookQuantity = 1;
			String[] bookData = line.split(", ");
			bookISBN = bookData[0];
			bookPrice = bookData[6];
			String bookLog = userID+", "+userPostcode+", "+bookISBN+", "+bookPrice+", "+bookQuantity+", "+status+", "+paymentMethod+", "+currentDate;
			
			//Merges books with same isbn into one activity log
			for (int i = 0; i < books.size();i++) {
				if (books.get(i).equals(line)) {
					
					for (int logIndex = 0; logIndex < bookLogs.size(); logIndex++) {
						if (bookLogs.get(logIndex).equals(bookLog)) { bookLogs.remove(logIndex); }
					}
					
					bookLog = bookLog.replaceAll(", "+String.valueOf(bookQuantity)+", ", ", "+String.valueOf(bookQuantity+1)+", ");
					
					if (i+1 == books.size()) {bookLogs.add(bookLog);}
					bookQuantity++;
					
					
				} else if(i+1 == books.size()) {bookLogs.add(bookLog);}
			}
			
			if (start==0) {bookLogs.add(bookLog);}
			
			books.add(line);
			start++;
		}
		
		// Adds old ActivityLog to array
		File logData = new File("ActivityLog.txt");
		Scanner logScanner = new Scanner(logData);
		
		ArrayList<String> oldBookLogs = new ArrayList<String>();
		
		while (logScanner.hasNextLine()) {
			oldBookLogs.add(logScanner.nextLine());
		}
		logScanner.close();
		
		// Clears ActivityLog file
		PrintWriter clearFile = new PrintWriter("ActivityLog.txt");
		clearFile.print("");
		clearFile.close();
	    
		// Adds new and old ActivityLog to file
		try {
	        FileWriter writer = new FileWriter("ActivityLog.txt", true);
	        for (int i = 0; i < bookLogs.size(); i++) {
	            writer.write(bookLogs.get(i)+"\n");
	        }
	        for (int i = 0; i < oldBookLogs.size();i++) {
	        	 writer.write(oldBookLogs.get(i)+"\n");
	        }
	        
	        
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}
}
