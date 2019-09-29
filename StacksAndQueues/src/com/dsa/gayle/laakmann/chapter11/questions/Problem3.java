package com.dsa.gayle.laakmann.chapter11.questions;

import java.util.Scanner;

/*
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 */
public class Problem3 {
	
	private static int[] arr;
	private static int x;
	
	public static void main(String[] args) {
		getInput();
		find(x);
	}		
	
	/*
	 * This method first finds the partitions such that on or before partition, all elements are decreasing and after partition, all elements are increasing.
	 * It uses binary search
	 */
	private static void find(int x) {
		int partition = 0;
		while (partition < arr.length-1) {
			if (arr[partition] > arr[partition+1]) {
				break;
			} else {
				partition++;
			}
		}
		int index = search (x, 0, partition);
		if (index == -1) {
			index = search(x, partition+1, arr.length-1);
		}
		if (index == -1) {
			System.out.println("Not found");
		} else {
			System.out.println("Found at index: " + index);
		}
	}
	
	public static int search (int x, int start, int end) {
		if (end<start) {
			return -1;
		}
		int mid = (start+end)/2;
		if (arr[mid] == x) {
			return mid;
		}
		if (x <= arr[mid]) {
			return search(x, start, mid-1);
		} else {
			return search(x, mid+1, end);
		}
		
	}
	
	private static void getInput() {
		Scanner scn = new Scanner(System.in);		
		System.out.println("Enter size of array: ");
		int size = scn.nextInt();
		arr = new int[size];
		System.out.println("Enter values for array separated by space: ");
		for (int i=0; i<size; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println("Enter integer to search: ");
		x = scn.nextInt();
	}
}
