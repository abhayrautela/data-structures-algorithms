package com.dsa.sort;

public class MergeSort {
	
	private static int c[];
	
	public void mergeSort(int[] a, int lb, int mid, int ub) {		
		int ai = lb, bi = mid+1, ci = 0;
		while (ai <= mid && bi <= ub) {
			if (a[ai] < a[bi]) 
				c[ci++] = a[ai++];
			else 
				c[ci++] = a[bi++]; 
		}
		
		while (ai <= mid) {
			c[ci++] = a[ai++];
		}
		
		while (bi <= ub) {
			c[ci++] = a[bi++];
		}
		
		for(int j=0; j < ub-lb+1; j++)
			a[lb+j] = c[j];
		
	}
	
	public void recursiveMergeSort(int[] arr, int lb, int ub) {
		if (lb == ub) {
			return;
		}
		int mid = (lb + ub)/2;
		recursiveMergeSort(arr, lb, mid);
		recursiveMergeSort(arr, mid+1, ub);
		mergeSort(arr, lb, mid, ub);
	}
	
	public static void main (String args[]) {
		MergeSort ms = new MergeSort();
		/*int a[] = {2,34,37,56,87,91,99,130,8,20,30,46,59,64,78,87,98};		
		int c[] = ms.mergeSort(a, 0, 7, a.length-1);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}*/
		int unsortedArr[] = {56,23,56,87,23,76,56,89,9};
		//int unsortedArr[] = {56,23,9};
		c = new int[unsortedArr.length];
		ms.recursiveMergeSort(unsortedArr, 0, unsortedArr.length - 1);
		for (int x : c) {
			System.out.println(x + ",");
		}
	}

}
