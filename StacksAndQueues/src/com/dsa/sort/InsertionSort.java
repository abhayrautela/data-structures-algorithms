package com.dsa.sort;

public class InsertionSort {
	
	private int[] arr;
	
	public InsertionSort(int[] arr) {
		this.arr = arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.round(Math.random() * 100);
		}
		System.out.println("Unsorted array : ");
		for (int i : arr) {
			System.out.print(i + " , ");
		}
		InsertionSort bs = new InsertionSort(arr);
		bs.sort();
		System.out.println("\nSorted array : ");
		for (int i : arr) {
			System.out.print(i + " , ");
		}
	}

	private void sort() {
		long t1 = System.currentTimeMillis();
		int i, j, index=-1;
		for (i = 1; i < arr.length; i++) {
			int temp = arr[i];
			for (j = i - 1; j >= 0; j--) {
				if (temp < arr[j]) {
					arr[j+1] = arr[j];
					index = j;
				}
			}
			if (index > -1) {
				arr[index] = temp;
				index = -1;
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println("\nTime taken : " + (t2-t1) + " ms");
	}

}
