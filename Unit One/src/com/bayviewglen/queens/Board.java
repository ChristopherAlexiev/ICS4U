package com.bayviewglen.queens;

import java.util.Stack;

public class Board {

	private int n;
	private Boolean[][] boardy;
	private boolean[] filledColumns;
	private Stack<Queen> stacky = new Stack<Queen>();

	// constructor
	public Board(int n) {
		this.n = n;
		boardy = new Boolean[n][n];
		for (int i = 0; i < boardy.length; i++) {
			for (int k = 0; k < boardy[i].length; k++) {
				boardy[i][k] = false;
			}
		}
		filledColumns = new boolean[n];
		for (int i = 0; i < filledColumns.length; i++) {
			filledColumns[i] = false;
		}

	}

	// the main method that goes through the board to figure out solution and
	// save it to the board array
	public boolean canSolve() {
		int startColumn = 0;
		for (int row = 0; row <= boardy.length; row++) {
			// test the next row (starting at the column determined by
			// startColumn)
			for (int column = startColumn; column <= boardy.length; column++) {
				if (row == 0 && (int) ((boardy.length - 1) / 2) + 1  == column) {
					// if past the middle of the bottom row then escape
					return false;
				} else if (column == boardy.length) {
					// if reached the end of the row then go to the row below
					startColumn = removeQueenOnRow(row - 1) + 1;
					row -= 2;
					break;
				}
				if (spaceAvailable(row, column)) {
					// if space is available for the queen then put it in
					insertQueen(row, column);
					startColumn = 0;
					break;
				}
			}
			// check whether board is completed
			if (row >= boardy.length-1) {
				return true;
			}
		}
		// make autocorrect happy
		return false;
	}

	// return true if the spot is available
	private boolean spaceAvailable(int row, int column) {
		// check the vertical
		if (filledColumns[column] == true) {
			return false;
		}
		// check the diagonals by returning false if a queen is found in the
		// diagonal
		int i = 0;
		while (true) {
			int pseudoRow = row - 2 * i;
			int pseudoColumn = column - 2 * i;
			if ((column < n && row < n && boardy[row][column])
					|| (column < n && pseudoRow >= 0 && boardy[pseudoRow][column])
					|| (pseudoColumn >= 0 && row < n && boardy[row][pseudoColumn])
					|| (pseudoColumn >= 0 && pseudoRow >= 0 && boardy[pseudoRow][pseudoColumn])) {
				return false;
			}
			if (row >= n && column >= n && pseudoRow <= 0 && pseudoColumn <= 0) {
				return true;
			}
			row++;
			column++;
			i++;
		}
	}

	// insert a queen onto the board at a space, insert to stack and make the
	// board array index true
	private void insertQueen(int row, int column) {
		boardy[row][column] = true;
		stacky.push(new Queen(row, column));
		filledColumns[column] = true;
	}

	// remove a queen from a row on the board, pop it, and return its column
	private int removeQueenOnRow(int row) {
		int column = stacky.pop().getColumn();
		boardy[row][column] = false;
		filledColumns[column] = false;
		return column;
	}

	// print the board as a grid of Xs and Qs
	public void printBoard() {
		for (int row = 0; row < boardy.length; row++) {
			for (int column = 0; column < boardy.length; column++) {
				if (boardy[row][column] == true) {
					System.out.print("Q ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}

}
