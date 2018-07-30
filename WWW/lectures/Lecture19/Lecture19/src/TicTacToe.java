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
		// playTurn(board, 'X');

		// Step 4: detect end of game
		while (!gameOver(board)) {
			playTurn(board, 'X');
			if (!gameOver(board)) {
				playTurn(board, 'O');
			}
		}
		println("Game over!");
	}

	// Step 1: This method returns a 2D array of the given size filled with EMPTY.
	private char[][] createBoard(int size) {
		char[][] board = new char[size][size];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				board[r][c] = EMPTY;
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
		for (int r = 0; r < board.length; r++) {
			print(" " + board[r][0]);
			for (int c = 1; c < board[0].length; c++) {
				print(" | " + board[r][c]);
			}
			println();
		}
	}

	/* 
	 * Step 3: This method plays a single turn for the given player.
	 * It prompts the user until it gets a valid, empty square, and then
	 * marks their symbol on that square.
	 */
	private void playTurn(char[][] board, char player) {
		// Prompt for a valid move
		while (true) {
			String line = readLine("Move (" + player + "): ");
			Scanner s = new Scanner(line);
			int row = s.nextInt();
			int col = s.nextInt();
			
			// Stop prompting if it's empty (assume row and col are in bounds)
			if (board[row][col] == EMPTY) {
				board[row][col] = player;
				break;
			}
			println("That space is already taken!");
		}
		
		// Update and print out the game board
		printBoard(board);
	}

	/*
	 * Step 4: This method returns true if the game is over, and false otherwise.
	 * The game can end when either:
	 * 	- a player has a single row with only their mark
	 *	- a player has a single column with only their mark
	 *	- a player has a single diagonal with only their mark
	 *	- all squares have been filled
	 */
	private boolean gameOver(char[][] board) {
		if (checkRows(board)) {
			return true;
		} else if (checkColumns(board)) {
			return true;
		} else if (checkDiagonals(board)) {
			return true;
		}
		return isDraw(board);
	}
	
	/*
	 * This method checks all rows and returns true if any of them
	 * are marked with all of a single player's markers (e.g. 3 in a row,
	 * 4 in a row, etc.).  Otherwise, returns false.
	 */
	private boolean checkRows(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			char ch = board[r][0];
			if (ch != EMPTY) {
				int counter = 1;
				for (int c = 1; c < board[0].length; c++) {
					if (board[r][c] == ch) {
						counter++;
					}
				}

				if (counter == board[0].length) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * This method checks all columns and returns true if any of them
	 * are marked with all of a single player's markers (e.g. 3 in a col,
	 * 4 in a col, etc.).  Otherwise, returns false.
	 */
	private boolean checkColumns(char[][] board) {
		for (int c = 0; c < board[0].length; c++) {
			char ch = board[0][c];
			if (ch != EMPTY) {
				int counter = 1;
				for (int r = 1; r < board.length; r++) {
					if (board[r][c] == ch) {
						counter++;
					}
				}

				if (counter == board.length) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * This method checks both diagonals and returns true if any of them
	 * are marked with all of a single player's markers.
	 * Otherwise, returns false.
	 */
	private boolean checkDiagonals(char[][] board) {
		int nDiagEntries = board.length;
		
		// Check top-left to bottom-right
		char ch = board[0][0];
		if (ch != EMPTY) {
			int counter = 1;
			for (int i = 1; i < nDiagEntries; i++) {
				if (board[i][i] == ch) {
					counter++;
				}
			}
			if (counter == nDiagEntries) {
				return true;
			}
		}

		// Check bottom-left to top-right
		ch = board[nDiagEntries][0];
		if (ch != EMPTY) {
			int counter = 1;
			for (int i = 1; i < nDiagEntries; i++) {
				if (board[nDiagEntries - i - 1][i] == ch) {
					counter++;
				}
			}

			return counter == nDiagEntries;
		}

		return false;
	}

	/*
	 * This method returns true if all squares are occupied, and
	 * false otherwise.
	 */
	private boolean isDraw(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == EMPTY) {
					return false;
				}
			}
		}

		return true;
	}
}
