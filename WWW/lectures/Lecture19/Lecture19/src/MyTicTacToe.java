/* File: MyTicTacToe.java
 * -------------------
 * This program uses 2D arrays to play the game "Tic-Tac-Toe".
 * -------------------
 */

import java.util.Arrays;
import java.util.Scanner;

import acm.program.*;

public class MyTicTacToe extends ConsoleProgram {

	private static final char EMPTY = ' ';
	
	private char[][] board; 

	public void run() {
		// Step 1: create the 2D array for the board
		int size = readInt("Enter board size: ");
		board = createBoard(size);
		
		// Step 2: print out the initial board to the screen
		printBoard();
		
		// Step 3: play a single turn
//		playTurn('X');
		
		// Step 4: detect end of game
		while (!gameOver()) {
			playTurn('X');
			if (!gameOver()) {
				playTurn('O');
			}
		}

		println("Game over!");
	}

	// Step 1: This method returns a 2D array of the given size filled with EMPTY.
	private char[][] createBoard(int size) {
		char[][] newBoard = new char[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				newBoard[row][col] = EMPTY;
			}
		}
		return newBoard;
	}

	/*
	 * Step 2: This method prints out the given 2D array as a tic-tac-toe board.
	 * The print out looks something like the following (where size = 3):
	 * 
	 *  x | o | x
	 *  o |   |  
	 *  x |   | o
	 */
	private void printBoard() {
		for (int row = 0; row < board.length; row++) {
			print(board[row][0]);
			for (int col = 1; col < board[0].length; col++) {
				print(" | " + board[row][col]);
			}
			println();
		}
	}
	
	/* 
	 * Step 3: This method plays a single turn for the given player.
	 * It prompts the user until it gets a valid, empty square, and then
	 * marks their symbol on that square.
	 */
	private void playTurn(char player) {
		String turn = readLine("Move (" + player + "): ");
		Scanner tokens = new Scanner(turn);
		int userRow = tokens.nextInt();
		int userCol = tokens.nextInt();
		board[userRow][userCol] = player;
		printBoard();
	}
	
	/*
	 * Step 4: This method returns true if the game is over, and false otherwise.
	 * The game can end when either:
	 * 	- a player has a single row with only their mark
	 *	- a player has a single column with only their mark
	 *	- a player has a single diagonal with only their mark
	 *	- all squares have been filled
	 */
	private boolean gameOver() {
		if (checkRows()) {
			return true;
		} else if (checkColumns()) {
			return true;
		} else if (checkDiagonals()) {
			return true;
		}
		return isDraw();
	}
	
	/*
	 * This method checks all rows and returns true if any of them
	 * are marked with all of a single player's markers (e.g. 3 in a row,
	 * 4 in a row, etc.).  Otherwise, returns false.
	 */
	private boolean checkRows() {
		int numRows = board.length;
		int numCols = board[0].length;
		for (int row = 0; row < numRows; row++) {
			char mark = board[row][0];
			if (mark != EMPTY) {
				int markCount = 1;
				for (int col = 1; col < numCols; col++) {
					if (board[row][col] == mark) {
						markCount++;
					}
				}
				if (markCount == numCols) {
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
	private boolean checkColumns() {
		int numRows = board.length;
		int numCols = board[0].length;
		for (int col = 0; col < numRows; col++) {
			char mark = board[0][col];
			if (mark != EMPTY) {
				int markCount = 1;
				for (int row = 1; row < numCols; row++) {
					if (board[row][col] == mark) {
						markCount++;
					}
				}
				if (markCount == numRows) {
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
	private boolean checkDiagonals() {
		int numDiagEntries = board.length;
		// top left to bottom right
		char mark = board[0][0];
		if (mark != EMPTY) {
			int markCount = 1;
			for (int i = 1; i < numDiagEntries; i++) {
				if (board[i][i] == mark) {
					markCount++;
				}
			}
			if (markCount == numDiagEntries) {
				return true;
			}
		}
		
		// bottom left to top right
		mark = board[numDiagEntries - 1][0];
		if (mark != EMPTY) {
			int markCount = 1;
			for (int i = 1; i < numDiagEntries; i++) {
				if (board[numDiagEntries - 1 - i][i] == mark) {
					markCount++;
				}
			}
			if (markCount == numDiagEntries) {
				return true;
			}
		}
		return false;
	}

	/*
	 * This method returns true if all squares are occupied, and
	 * false otherwise.
	 */
	private boolean isDraw() {
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

