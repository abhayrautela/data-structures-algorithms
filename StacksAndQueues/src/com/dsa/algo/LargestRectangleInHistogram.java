package com.dsa.algo;

import java.util.Scanner;
import java.util.Stack;

/*
 * This method calculates the largest area in a histogram. Refer fig. histogram1.png.
 * Get input from user:
 * 5
 * 1 2 3 4 5
 * First line of input is number of bars in histogram and second line is height of 
 * each bar
 */
public class LargestRectangleInHistogram {
	
private static int arr[];
	
	public static void main(String[] args) {
        getInput();
		findLargestAreaInHistogram();
		System.out.print(largestRectangleArea(arr));
	}
	
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();
	 
		int max = 0;
		int i = 0;
	 
		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
	 
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}
	
	/*
	 * This method runs in O(N^2) time. Not effecient.
	 */
	private static void findLargestAreaInHistogram() {
		int maxArea = 0;
		for (int i=0; i<arr.length; i++) {
			int barCount = 1;
			int leftPtr = i, rightPtr = i;
			while (--leftPtr > -1) {
				if (arr[leftPtr] >= arr[i]) {
					barCount++;
				} else {
                    break;
                }
			}
			while (++rightPtr < arr.length) {
				if (arr[rightPtr] >= arr[i]) {
					barCount++;
				} else {
                    break;
                }
			}
			maxArea = Math.max(arr[i] * barCount, maxArea);
		}
		System.out.print(maxArea);
	}
	
	private static void getInput() {
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		arr = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = scn.nextInt();
		}        
	}

}
