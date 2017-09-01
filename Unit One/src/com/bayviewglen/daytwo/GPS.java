package com.bayviewglen.daytwo;

import java.util.Scanner;

public class GPS {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the number of points:");
		int num = keyboard.nextInt();

		double[][] points = new double[num][2];

		System.out.println("Enter "+ num +" points:");
		
		// gets points through scanner
		for (int i = 0; i < num; i++) {
			points[i][0] = keyboard.nextDouble();
			points[i][1] = keyboard.nextDouble();
		}

		double min = Integer.MAX_VALUE;

		double coordinateXOne = Integer.MAX_VALUE;
		double coordinateYOne = Integer.MAX_VALUE;
		double coordinateXTwo = Integer.MAX_VALUE;
		double coordinateYTwo = Integer.MAX_VALUE;
		
		// goes through all pairs of points to find the min distance
		for (int i = 0; i < num - 1; i++) {
			for (int k = i + 1; k < num; k++) {
				double distance = Math.sqrt(Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2));
				if (distance < min) {
					min = distance;
					coordinateXOne = points[i][0];
					coordinateYOne = points[i][1];
					coordinateXTwo = points[k][0];
					coordinateYTwo = points[k][1];
				}
			}
		}
		System.out.println("The closest two points are " + "("+coordinateXOne +"," +coordinateYOne + ")" + " and " + "("+coordinateXTwo +"," +coordinateYTwo + ")");
		
	}

}
