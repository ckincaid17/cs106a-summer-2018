import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;

public class PhoneBook extends ConsoleProgram {
	
	public void run() {
		setFont("Courier-24");
		HashMap<String, Integer> phoneBook = 
				new HashMap<String, Integer>();
		
		phoneBook.put("Chris", 8666586);
		phoneBook.put("Waddie", 1234567);
		println(phoneBook.get("Chris"));
		
		/*while(true) {
			String cmd = readLine("Enter command (printAll, add, lookup): ");
			if(cmd.equals("printAll")) {
				printMap(phoneBook);
			}
			if(cmd.equals("add")){
				addToMap(phoneBook);
			}
			if(cmd.equals("lookup")){
				lookup(phoneBook);
			}
			println("");
		}*/
		
		
	}

	private void printMap(HashMap<String, Integer> phoneBook) {
		// talk about on friday.
	}

	private void lookup(HashMap<String, Integer> phoneBook) {
		String key = readLine("Key: ");
		Integer phoneNumber = phoneBook.get(key);
		if(phoneNumber == null) {
			println("Sorry but there is no number for " + key);
		} else {
			println(key + ": " + phoneNumber);
		}
	}

	private void addToMap(HashMap<String, Integer> phoneBook) {
		String key = readLine("Key: ");
		int phoneNumber = readInt("Phone number: " );
		phoneBook.put(key, phoneNumber);
		println("Added " + key);
	}
	
	
}
