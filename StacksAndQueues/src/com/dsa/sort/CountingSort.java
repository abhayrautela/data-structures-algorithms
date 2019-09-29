package com.dsa.sort;

import java.util.Scanner;

public class CountingSort {

	private static int[] arr;
	private static final int MAX_LIMIT = 100;

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		getInput();
		int ref[] = new int[MAX_LIMIT];
		// for (int i=0; i<100; i++) {
		// ref[i] = -1;
		// }
		for (int i = 0; i < arr.length; i++) {
			// if (ref[arr[i]] == -1) {
			// ref[arr[i]] = 0;
			// }
			ref[arr[i]]++;
		}

		for (int i = 1; i < MAX_LIMIT; i++) {
			ref[i] += ref[i - 1];
		}
		int[] output = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i];
			int rank = ref[index] - 1;
			// while (rank != -1) {
			// rank = ref[--index];
			// }
			while (output[rank] > 0)
				--rank;
			output[rank] = arr[i];
		}
		display(output);
	}

	private static void display(int[] ref) {
		for (int i = 0; i < ref.length; i++) {
			System.out.print(ref[i] + " ");
		}
	}

	private static void getInput() {
		/*
		 * input should be in form of : 7 1 4 1 2 7 5 2
		 */
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scn.nextInt();
		}
	}

}