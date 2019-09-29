package com.dsa.sort;

public class Partition {
	
	private int[] arr;
	
	public Partition(int[] arr) {
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
		Partition bs = new Partition(arr);
		int pivot = 50;
		System.out.println("Pivot is : " + pivot);
		int partition = bs.partition(pivot);
		System.out.println("\nPartioned array : ");
		for (int i : arr) {
			System.out.print(i + " , ");
		}
		System.out.println("\nPartion at : " + partition);
	}

	private int partition(int pivot) {
		int leftPtr = -1, rightPtr = arr.length;
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
