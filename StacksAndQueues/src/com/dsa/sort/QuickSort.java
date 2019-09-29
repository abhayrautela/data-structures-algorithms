package com.dsa.sort;

public class QuickSort {

	
	private int[] arr;
	
	public QuickSort(int[] arr) {
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
		QuickSort qs = new QuickSort(arr);
		qs.quickSort(0, arr.length-1);
		System.out.println("\nSorted array : ");
		for (int i : arr) {
			System.out.print(i + " , ");
		}
	}

	private void quickSort(int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			int pivot = arr[right];
			int partition = partition(left, right, pivot);
			arr[right] = arr[partition];
			arr[partition] = pivot;
			quickSort(left, partition-1);
			quickSort(partition+1, right);
		}
		
	}

	private int partition(int left, int right, int pivot) {
		int leftPtr = left - 1, rightPtr = right;
		while(true) {
			while (leftPtr < arr.length-1 && arr[++leftPtr] < pivot) {
				// do nothing
			}
			while (rightPtr > 0 && arr[--rightPtr] > pivot) {
				// do nothing
			}
			if (leftPtr >= rightPtr) {
				// partition done
				break;
			} else {
				// swap
				int temp = arr[leftPtr];
				arr[leftPtr] = arr[rightPtr];
				arr[rightPtr] = temp;
			}
		}
		return leftPtr;
	}
}
