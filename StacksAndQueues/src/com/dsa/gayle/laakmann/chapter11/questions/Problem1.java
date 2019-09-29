package com.dsa.gayle.laakmann.chapter11.questions;

import java.util.Scanner;

/*
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order
 */
public class Problem1 {
	
	private static int[] arrA;
	private static int[] arrB;
	
	public static void main(String[] args) {
		getInput();
		
		mergeSort();
		
	}
	
	private static void mergeSort() {
		int sizeA = arrA.length;
		int sizeB = arrB.length;
		int aPtr = sizeA-1;
		int bPtr = sizeB-sizeA-1;
		int cPtr = sizeB-1;
		
		while (aPtr >=0 && bPtr >=0) {
			if (arrA[aPtr] > arrB[bPtr]) {
				arrB[cPtr--] = arrA[aPtr--];
			} else {
				arrB[cPtr--] = arrB[bPtr--];
			}
		}
		
		while (aPtr >= 0) {
			arrB[cPtr--] = arrA[aPtr--];
		}
		
		while (bPtr >= 0) {
			arrB[cPtr--] = arrB[aPtr--];
		}
		
		display();
	}
	
	public static void display() {
		for (int i=0; i<arrB.length-1; i++) {
			System.out.print(arrB[i]+" ");
		}
	}

	private static void getInput() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter size of array A: ");
		int sizeA = scn.nextInt();
		arrA = new int[sizeA];
		System.out.println("Enter values for array A separated by space: ");
		for (int i=0; i<sizeA; i++) {
			arrA[i] = scn.nextInt();
		}
		
		System.out.println("Enter size of array B: ");
		int sizeB = scn.nextInt();
		arrB = new int[sizeA+sizeB];
		System.out.println("Enter values for array B separated by space: ");
		for (int i=0; i<sizeB; i++) {
			arrB[i] = scn.nextInt();
		}
	}
	
}
