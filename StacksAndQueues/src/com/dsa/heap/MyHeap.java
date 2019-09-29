package com.dsa.heap;

public class MyHeap {
	
	private int heapArr[];
	private int size;
	private int currentSize;
	
	public MyHeap(int size) {
		heapArr = new int[size];
		this.size = size;
	}
	
	public boolean insert(int x) {
		if (currentSize == size) {
			return false;
		} else {
			heapArr[currentSize] = x;
			trickleUp(currentSize++);
			return true;
		}
	}

	private void trickleUp(int index) {
		int parentIndex = (index-1)/2;
		int current = heapArr[index];
		
		while (heapArr[parentIndex] < current) {
			heapArr[index] = heapArr[parentIndex];
			index = parentIndex;
			parentIndex = (index-1)/2;
		}
		heapArr[index] = current;
	}
	
	public int remove() {
		int root = heapArr[0];
		heapArr[0] = heapArr[--currentSize];
		trickleDown(0);
		return root;
	}

	private void trickleDown(int index) {
		int leftChildIndex = 2*index + 1;
		int rightChildIndex = leftChildIndex + 1;
		int current = heapArr[index];
		int largerChildIndex;
		while (index < currentSize/2) {
			if (rightChildIndex < currentSize
					&& heapArr[rightChildIndex] > heapArr[leftChildIndex]) {
				largerChildIndex = rightChildIndex;
			} else {
				largerChildIndex = leftChildIndex;
			}
			if (current < heapArr[largerChildIndex]) {
				heapArr[index] = heapArr[largerChildIndex];
			} else {
				break;
			}
			index = largerChildIndex;// go down
		}
		heapArr[index] = current;
	}
	
	public boolean change (int index, int newValue) {
		if(index < 0 || index >= currentSize) {
			return false;
		} else {
			int oldValue = heapArr[index];
			heapArr[index] = newValue;
			if (newValue > oldValue) {
				trickleUp(index);
			} else {
				trickleDown(index);
			}
			return true;
		}
	}

}
