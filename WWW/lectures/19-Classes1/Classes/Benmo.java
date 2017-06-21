import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.program.*;

public class Benmo extends ConsoleProgram{
	
	public void run() {
		BankAccount mehran = new BankAccount("Mehran", 10000);
		BankAccount chris = new BankAccount("Chris", 5);
		BankAccount nick = new BankAccount("Nick", 100);
		
		println("Initial balance:");
		println(chris.toString());
		println(mehran.toString());
		println(nick.toString());
		println("");
		
		chris.deposit(100);
		mehran.withdraw(200);
		chris.transfer(nick, 50);
		
		println("Final balance: ");
		println(chris.toString());
		println(mehran.toString());
		println(nick.toString());
		println("");
		
	}
	
	public void init() {
		setFont("courier-24");
	}
}
