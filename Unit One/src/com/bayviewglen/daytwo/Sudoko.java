package com.bayviewglen.daytwo;

import java.util.Scanner;
import java.util.Arrays;

public class Sudoko {

	public static void main(String[] args) {
		System.out.println("Enter a Sudoko puzzle solution:");

		Scanner keyboard = new Scanner(System.in);

		int puzzle[][] = new int[9][9];

		boolean solved = true;

		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				puzzle[i][k] = keyboard.nextInt();
			}
		}

		// go through rows
		int[] row = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				row[k] = puzzle[i][k];
			}
			Arrays.sort(row);
			for (int k = 0; k < 9; k++) {
				if (k + 1 != row[k]) {
					solved = false;
				}
			}
		}

		// go through columns
		int[] column = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				column[k] = puzzle[k][i];
			}
			Arrays.sort(column);
			for (int k = 0; k < 9; k++) {
				if (k + 1 != column[k]) {
					solved = false;
				}
			}
		}

		// check the 3*3 boxes

		int[] box = new int[9];

		for (int i = 0; i < 9; i += 3) {
			for (int k = 0; k < 9; k += 3) {
				int count = 0;
				for (int j = k; j < k + 3; j++) {
					box[count] = puzzle[i][j];
					count++;
				}
				for (int j = k; j < k + 3; j++) {
					box[count] = puzzle[i + 1][j];
					count++;
				}
				for (int j = k; j < k + 3; j++) {
					box[count] = puzzle[i + 2][j];
					count++;
				}

				Arrays.sort(box);
				for (int j = 0; j < 9; j++) {
					if (j + 1 != column[j]) {
						solved = false;
					}
				}

			}
		}

		// return answer
		if (solved) {
			System.out.println("Valid solution");
		} else {
			System.out.println("Invalid solution");
		}

	}

}
