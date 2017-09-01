package com.bayviewglen.extra;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Practice {

	public static void main(String[] args) {
		Stack<Integer> stacky = new Stack<Integer>();
		
		stacky.push(1);
		stacky.push(2);
		System.out.println(stacky.pop() + stacky.pop());
		
		Set<Integer> sety = new HashSet<Integer>();

		sety.add(1);
		sety.add(2);
		sety.add(3);
		sety.add(3);
		sety.add(7);
		
		for(Integer i :sety){
			System.out.println(i);
		}
		
	}

}
