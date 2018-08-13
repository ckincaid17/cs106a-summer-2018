/*
 * File: KnightMove.java
 * ---------------------
 * This class implements the method knightCanMove, which checks if a
 * knight can move from a given square to another square on a chess board,
 * and some helper methods to test knightCanMove.
 */

import java.awt.Color;
import java.util.Arrays;

import acm.program.*;

public class KnightMove extends ConsoleProgram {
	
	public void run() {
		// Initialize a chess board and fill it with the
		// same values as shown in the lecture slides
		String[][] chessBoard = new String[8][8];
		fillWithEmptyString(chessBoard);
		chessBoard[0][4] = "king";
		chessBoard[1][2] = "knight";
		chessBoard[3][1] = "rook";

		// Test the method with the same tests that appear
		// in the lecture slides
		testKnightCanMove(chessBoard, 2, 2, 3, 4, false);
		testKnightCanMove(chessBoard, 1, 2, 0, 4, false);
		testKnightCanMove(chessBoard, 1, 2, 3, 2, false);
		testKnightCanMove(chessBoard, 1, 2, 3, 3, true);
	}
	
	/*
	 * This method fills every cell in a 2D String array
	 * with the empty string, "".
	 */
	private void fillWithEmptyString(String[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				board[row][col] = "";
			}
		}
	}
	
	/*
	 * This method tests the knightCanMove method with the first five parameters,
	 * and accepts a value for whether or not the knight can actually make that move.
	 * This value is then compared against the value the method returns, and if the
	 * two don't match, this method prints an error message to the console.
	 */
	private void testKnightCanMove(String[][] board, int startRow, int startCol,
									int endRow, int endCol, boolean expectedResult) {
		boolean result = knightCanMove(board, startRow, startCol, endRow, endCol);
		String methodCall = "knightCanMove(board, " + startRow + ", " + startCol + ", " + 
		                    endRow + ", " + endCol + ")";
		
		if (result == expectedResult) {
			println(methodCall + " returned " + result + ", as expected!");
		} else {
			println(methodCall + " - expected return value " + expectedResult +
					", but instead returned " + result + "!", Color.RED);
		}
		println();
	}
	
	/*
	 * This method returns true if the starting square contains a knight,
	 * the end square is empty, and the knight can legally move from the
	 * start square to the end square.
	 * Assumes that (startRow, startCol) and (endRow, endCol) are in bounds.
	 */
	private boolean knightCanMove(String[][] board, int startRow, int startCol,
							      int endRow, int endCol) {
		if (board[startRow][startCol].equals("knight")) {
			if (board[endRow][endCol].equals("")) {
				int rowDifference = Math.abs(startRow - endRow);
				int colDifference = Math.abs(startCol - endCol);
				if ((rowDifference == 1 && colDifference == 2) || 
				    (rowDifference == 2 && colDifference == 1)) {
					return true;
				}
			}
		}
		return false;
	}
}

