package com.bayviewglen.heapystuff;

public class Heap {

	public static int[] arr;
	public static int arrLength;

	public static void main(String[] args) {
		arr = new int[1000000];

		add(6);
		add(7);
		add(16);
		add(23);
		add(3);
		deleteRoot();

		for (int i = 0; i < arrLength; i++) {
			System.out.println(arr[i]);
		}
	}

	static void add(int value) {
		arr[arrLength] = value;
		arrLength++;
		siftUp(arrLength - 1);
	}

	static void siftUp(int index){
		if (arr[index]>arr[(index-1)/2]){
			int temp = arr[index];
			arr[index] = arr[(index-1)/2];
			arr[(index-1)/2] = temp;
			siftUp((index-1)/2);
		}
	}
	
	static void deleteRoot(){
		arr[0]= arr[arrLength-1];
		arrLength--;
		siftDown(0);
	}
	
	//only works with positives still
	static void siftDown(int index){
		if (arr[index]<arr[2*index+1] || arr[index]<arr[2*index+2]){
			int childIndex;
			if (arr[2*index+1]>arr[2*index+2]){
				childIndex = 2*index+1;
			} else {
				childIndex = 2*index+2;
			}
			int temp = arr[index];
			arr[index] = arr[childIndex];
			arr[childIndex] = temp;
			siftDown(childIndex);
		}
	}

}
