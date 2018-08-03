/* File: BankAccountProgram.java
 * --------------------------
 * This file is an example program using the new variable
 * type we defined, BankAccount.
 */
import acm.program.*;

public class BankAccountProgram extends ConsoleProgram {
	public void run() {
		BankAccount colinAccount = new BankAccount("Colin", 50);
		colinAccount.deposit(50);
		println("Colin's balance is now $" + colinAccount.getBalance());

		BankAccount annieAccount = new BankAccount("Annie");
		annieAccount.deposit(50);
		boolean success = annieAccount.withdraw(10);
		if (success) {
			println("Annie withdrew $10.");
		}
		println(annieAccount);
	}
}