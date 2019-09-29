package com.dsa.sort;

public class BubbleSort {
	
	private int[] arr;
	
	public BubbleSort(int[] arr) {
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
		BubbleSort bs = new BubbleSort(arr);
		bs.sort();
		System.out.println("\nSorted array : ");
		for (int i : arr) {
			System.out.print(i + " , ");
		}
	}

	private void sort() {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println("\nTime taken : " + (t2-t1) + " ms");
	}

}
