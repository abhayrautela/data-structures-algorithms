package com.dsa.sort;

public class SelectionSort {
	
	private int[] arr;
	
	public SelectionSort(int[] arr) {
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
		SelectionSort bs = new SelectionSort(arr);
		bs.sort();
		System.out.println("\nSorted array : ");
		for (int i : arr) {
			System.out.print(i + " , ");
		}
	}

	private void sort() {		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int index = i;
			for (int j = i; j < arr.length; j++) {				
				if (temp > arr[j]) {
					temp = arr[j];
					index = j;
				}
			}
			if (index != i) {
				arr[index] = arr[i];
				arr[i] = temp;				
			}			
		}
		long t2 = System.currentTimeMillis();
		System.out.println("\nTime taken : " + (t2-t1) + " ms");
	}

}
