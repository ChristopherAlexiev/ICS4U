package com.bayviewglen.dayone;

import java.util.Scanner;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Stack<Integer> stacky = new Stack<Integer>();
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();

	// postfix evaluation
	for(
	int i = 0;i<input.length();i++)
	{
		String stringy;
		stringy = input.substring(i, i + 1);
		if (stringy.equals("+")) {
			stacky.push(stacky.pop() + stacky.pop());
		} else if (stringy.equals("-")) {
			stacky.push(stacky.pop() - stacky.pop());
		} else if (stringy.equals("/")) {
			stacky.push(stacky.pop() / stacky.pop());
		} else if (stringy.equals("*")) {
			stacky.push(stacky.pop() * stacky.pop());
		} else {
			while (true) {
				i++;
				if (input.substring(i,i+1).equals(" ")) {
					break;
				}
				stringy += input.substring(i, i + 1);
			}

			stacky.push(Integer.parseInt(stringy));
		}

	}

	System.out.println(stacky.pop());

}

}
