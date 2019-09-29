package com.dsa.recursion;

public class BinarySearch {
	
	private static int[] a = {1, 2, 3, 4, 5, 6, 7, 9, 10};;
	
	public static int recFind(int key, int lowBound, int highBound) {
		int curr = (lowBound + highBound)/2;
		if (a[curr] == key) {
			return curr;
		} else if (a[curr] < key) {
			lowBound = curr + 1;
		} else {
			highBound = curr - 1;
		}
		return recFind(key, lowBound, highBound);
	}
	
	public static void main (String args[]) {
		int index = recFind(5, 0, a.length - 1);
		System.out.println(index);
	}

}
