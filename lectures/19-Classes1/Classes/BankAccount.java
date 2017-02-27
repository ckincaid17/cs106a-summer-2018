
import java.util.*;

public class BankAccount {

	// 1. What variables make up a bank account?
	private double money; // every bank account has money
	private String name; // every bank account has a name
	private String password; // every bank account has a password

	// 3. How does one make a new bank account?
	/**
	 * Constructor: Bank Account
	 * -------------------------
	 * When you make a new bank account, start with initial values.
	 */
	public BankAccount(String name, double start) {
		this.name = name;
		this.money = start;
		this.password = "";
	}

	// 2. What methods can you call on a bank account instance?
	/**
	 * Method: Withdraw
	 * -------------------------
	 * Tries to take money out of the account. Makes sure that there is
	 * sufficient funds. Returns whether or not the withdrawal was successful
	 */
	public boolean withdraw(double amount) {
		if(this.money >= amount) {
			this.money -= amount;
			return true;
		}
		return false;
	}
	
	/**
	 * Method: Deposit
	 * -------------------------
	 * Puts money into the bank account!
	 */
	public void deposit(double amount) {
		this.money += amount;
	}
	
	/**
	 * Method: Check Balance
	 * -------------------------
	 * returns the amount of money in this account.
	 */
	public double checkBalance() {
		return this.money;
	}

	/**
	 * Method: Transfer
	 * -------------------------
	 * transfers money from one account to another.
	 */
	public boolean transfer(BankAccount other, double amount) {
		if(this.money >= amount) {
			this.money -= amount;
			other.money += amount;
			return true;
		}
		return false;
	}
	
	/**
	 * Method: To String
	 * -------------------------
	 * Returns a string that contains the bankAccounts info (except password)
	 */
	public String toString() {
		String str = "";
		String dollarFormat = String.format("%10.2f", this.money).trim();
		str = this.name + ": $" + dollarFormat;
		return str;
	}

	/**
	 * Method: Check Password
	 * -------------------------
	 * Returns true if the given password matches the actual password.
	 */
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	/**
	 * Method: Set Password
	 * -------------------------
	 * Sets the bank accounts password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
