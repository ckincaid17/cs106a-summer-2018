/* File: TicTacToe.java
 * -------------------
 * This program uses 2D arrays to play the game "Tic-Tac-Toe".
 * -------------------
 */

import java.util.*;
import acm.program.*;

public class TicTacToe extends ConsoleProgram {

	private static final char EMPTY = ' ';

	public void run() {
		// Step 1: create the 2D array for the board
		int size = readInt("Enter board size: ");
		char[][] board = createBoard(size);
		
		// Step 2: print out the initial board to the screen
		printBoard(board);
		
		// Step 3: play a single turn

		// Step 4: detect end of game

		println("Game over!");
	}

	// Step 1: This method returns a 2D array of the given size filled with EMPTY.
	private char[][] createBoard(int size) {
		char[][] board = new char[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				board[row][col] = EMPTY;
			}
		}
		return board;
	}

	/*
	 * Step 2: This method prints out the given 2D array as a tic-tac-toe board.
	 * The print out looks something like the following (where size = 3):
	 * 
	 *  x | o | x
	 *  o |   |  
	 *  x |   | o
	 */
	private void printBoard(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			print(EMPTY);
			for (int col = 1; col < board[0].length; col++) {
				print(" | " + EMPTY);
			}
			println();
		}
	}
}
