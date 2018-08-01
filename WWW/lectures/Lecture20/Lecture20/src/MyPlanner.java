/*
 * A program that prompts for a list of tasks, and them reprompts the user
 * to enter them in the order they want to tackle them.  At the end, prints
 * out the ordering they have entered.
 * 
 * EXAMPLE OUTPUT:
 *
 * ** STEP 1 **
 * Enter task: do crossword
 * Enter task: sleep
 * Enter task: talk to Annie
 * Enter task: 
 * ** STEP 2 **
 * Great!  Enter the order to complete your tasks.
 * Tasks remaining: [do crossword, sleep, talk to Annie]
 * Next task to complete: do crossword
 * Tasks remaining: [sleep, talk to Annie]
 * Next task to complete: talk to Annie
 * Tasks remaining: [sleep]
 * Next task to complete: go to gym
 * That's not on your list - stay focused!
 * Tasks remaining: [sleep]
 * Next task to complete: sleep
 * ** STEP 3 **
 * Congrats!  Your day is all planned out:
 * [do crossword, talk to Annie, sleep]
 */

import java.util.*;
import acm.program.*;

public class MyPlanner extends ConsoleProgram {
	public void run() {
		// Step 1: Prompt for tasks
		
		// Step 2: Reprompt for order of tasks
		// TODO create task list for final order
		println("Great!  Enter the order to complete your tasks.");
		// TODO while there are remaining tasks to complete:
		// 			print remaining tasks
		//			update lists or remind them to focus
		print("Tasks remaining: ");
		String task = readLine("Next task to complete: ");
		println("That's not on your list - stay focused!");
		
		// Step 3: print out new task ordering
		println("Congrats! Your day is all planned out:");
		// TODO print ordered tasks
	}
}
