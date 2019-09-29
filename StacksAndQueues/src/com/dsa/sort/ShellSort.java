package com.dsa.sort;

public class ShellSort {
	
	private int[] arr;
	
	public ShellSort(int[] arr) {
		this.arr = arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.round(Math.random() * 100);
		}
		System.out.println("Unsorted array : ");
		for (int i : arr) {
			System.out.print(i + " , ");
		}
		ShellSort bs = new ShellSort(arr);
		bs.shellSort();
		System.out.println("\nSorted array : ");
		for (int i : arr) {
			System.out.print(i + " , ");
		}
	}

	private void shellSort() {
		int h = 1;
		while (h <= arr.length) {
			h = 3*h + 1;
		}
		if (h > arr.length) {
			h = (h-1)/3;
		}
		while(h > 0) { 
			//for (int i = 0; i <= h-1; i++) {
				insertionSort(arr, h);
				h = (h - 1) / 3;
			//}			
		}
		
	}

	private void insertionSort(int[] arr, int gap) {
		int i, j, index=-1;
		for (i = gap; i < arr.length; i=i+gap) {
			int temp = arr[i];
			for (j = i - gap; j >= 0; j=j-gap) {
				if (temp < arr[j]) {
					arr[j+gap] = arr[j];
					index = j;
				}
			}
			if (index > -1) {
				arr[index] = temp;
				index = -1;
			}
		}
	}

}
