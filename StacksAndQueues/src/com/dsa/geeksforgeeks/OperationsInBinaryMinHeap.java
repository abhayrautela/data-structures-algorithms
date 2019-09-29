package com.dsa.geeksforgeeks;

public class OperationsInBinaryMinHeap {
	
	int harr[];
	int capacity;
	int heapSize;
	
	public OperationsInBinaryMinHeap(int size) {
		// TODO Auto-generated constructor stub
		capacity = size;
		harr = new int[size];
		for (int i=0; i<size; i++) {
			harr[i] = Integer.MAX_VALUE;
		}
	}
	
	void insertKey(int k) {
		harr[heapSize] = k;
		trickleUp(heapSize++);
	}
	
	void deleteKey(int i) {
		if (heapSize == 0)
			return;		
		int x = harr[i];
		if (heapSize == 1) {
			heapSize--;
			harr[i] = Integer.MAX_VALUE;
			return;
		}
		harr[1] = harr[--heapSize];
		trickleDown(1, x);
	}
	
	int extractMin() {
		if (heapSize == 0)
			return 0;		
		int x = harr[0];
		if (heapSize == 1) {
			heapSize--;
			harr[0] = Integer.MAX_VALUE;
			return x;
		}
		harr[0] = harr[--heapSize];
		trickleDown(0, x);
		return x;
	}
	
	void trickleDown(int index, int x) {
		while (index < heapSize) {
			int left = 2*index+1;
			int right = left+1;
			if (harr[left] < harr[right]) {
				harr[index] = harr[left];
				index = left;
			}
			else {
				harr[index] = harr[right];
				index = right;
			}
		}
		harr[index] = x;
	}
	
	void trickleUp(int index) {
		if (index == 0)
			return;
		int x = harr[index];
		while (index > 0) {
			int pIndex = (index-1)/2;
			int p = harr[pIndex];
			if (p > x)
				harr[index] = p;
			index = pIndex;
		}
		harr[index] = x;
	}
	
	public static void main(String[] args) {
		OperationsInBinaryMinHeap m = new OperationsInBinaryMinHeap(100);
		m.insertKey(6);
		m.insertKey(5);
		m.insertKey(4);
		m.insertKey(3);
		m.insertKey(2);
		m.insertKey(1);
		System.out.println(m.extractMin());
		System.out.println(m.extractMin());		
		m.deleteKey(3);
		System.out.println(m.extractMin());
		System.out.println(m.extractMin());
		System.out.println(m.extractMin());
		System.out.println();
	}

}
