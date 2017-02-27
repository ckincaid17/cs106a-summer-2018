import java.util.*;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.program.*;

public class BenmoFull extends ConsoleProgram{

	Map<String, BankAccount> users = new HashMap<String, BankAccount>();

	public void run() {
		println("Welcome to Benmo!");
		println("----------------");
		loadBankAccounts();
		BankAccount yourAccount = logIn();

		while(true) {
			String cmd = readLine("Command (send, deposit, showAll): ");
			
			// 1. The "deposit" command
			if(cmd.equals("deposit")) {
				double amount = readDouble("amount: ");
				yourAccount.deposit(amount);
			}
			
			// 2. The "showAll" command
			if(cmd.equals("showAll")) {
				for(String name : users.keySet()) {
					BankAccount account = users.get(name);
					println(account.toString());
				}
			}
			
			// 3. The "send" command
			if(cmd.equals("send")) {
				String otherName = readLine("recipient: ");
				BankAccount other = users.get(otherName); // unsafe. maybe this is null.
				double amount = readDouble("amount: ");
				if(yourAccount.transfer(other, amount)) {
					println("success");
				} else {
					println("fail!");
				}
			}
			println("");
		}
	}

	private BankAccount logIn() {
		println("log in");
		while(true) {
			String userName = readLine("username: ");
			if(users.containsKey(userName)) {
				String password = readLine("password: ");
				BankAccount yourAccount = users.get(userName);
				if(yourAccount.checkPassword(password)) {
					println("welcome " + userName);
					println("");
					return yourAccount;
				} else {
					println("Incorrect password!");
				}
			} else {
				println("Incorrect username!");
			}
		}

	}

	private void loadBankAccounts() {
		BankAccount chris = new BankAccount("chris", 100);
		BankAccount julie = new BankAccount("julie", 1000);
		BankAccount mehran = new BankAccount("mehran", 500);
		chris.setPassword("bananas");
		mehran.setPassword("claire");
		julie.setPassword("password");
		users.put("chris", chris);
		users.put("julie", julie);
		users.put("mehran", mehran);
	}

	public void init() {
		setFont("Courier-24");
	}
}
