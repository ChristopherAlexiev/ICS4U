package com.bayviewglen.queens;

import java.util.Scanner;

public class QueensInterface {

	public static void main(String[] args) {

		// get a value for n from the user
		System.out.println("Welcome to the NQueens program. Please enter a natural number for N:");
		while (true) {
			
			int n = inputter();

			Board boardy = new Board(n);

			boolean possible = boardy.canSolve();

			if (possible) {
				System.out.println("The solution of the board is:");
				boardy.printBoard();
			} else {
				System.out.println("Sorry, but this is impossible.");
			}
			
			System.out.println();
			System.out.println("Please enter your next number:");
		}

	}

	// get a value for n from the user
	private static int inputter() {
		Scanner keyboard = new Scanner(System.in);
		int choice = -1;
		while (true) {
			try {
				choice = Integer.parseInt(keyboard.nextLine());
				if (choice > 0) {
					break;
				}
			} catch (Exception e) {
			}
			System.out.println("Please enter a valid natural number.");
		}
		return choice;
	}
}
