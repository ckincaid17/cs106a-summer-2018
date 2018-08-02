/* File: EmployeeProgram.java
 * --------------------------
 * This file is an example program using the new variable
 * type we defined, Employee.
 */
import acm.program.*;

public class EmployeeProgram extends ConsoleProgram {
	public void run() {
		Employee colin = new Employee("Colin", "Karel Programmer", 9);
		Employee annie = new Employee("Annie");
		println("Annie makes $" + annie.getSalary());
		
		println(colin);
		while (colin.promote()) {
			println("Colin got a promotion!");
			println("Colin's title is now " + colin.getTitle());
			println("Colin's salary is now $" + colin.getSalary());
		}
		println("Colin can't be promoted anymore.");
	}
}
