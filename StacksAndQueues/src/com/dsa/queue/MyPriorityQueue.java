package com.dsa.queue;


/*
 * A priority queue where highest value element is at 0.
 */
public class MyPriorityQueue {
	
	private long[] pQueueArray;
	private int nItems;
	private int maxSize;
	
	public MyPriorityQueue(int n) {
		nItems = 0;
		maxSize = n;
		pQueueArray = new long[n];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public long peekMin() {
		return pQueueArray[nItems - 1];
	}
	
	public long remove() {
		return pQueueArray[--nItems];
	}
	
	public void insert(long item) {
		if (isFull())
			throw new UnsupportedOperationException("Queue is full");
		if (isEmpty()) {
			pQueueArray[nItems++] = item;
		} else {
			int j;
			for (j = nItems - 1; j >= 0; j--) {
				if (item > pQueueArray[j]) {
					pQueueArray[j + 1] = pQueueArray[j];
				} else {
					break;
				}				
			}
			pQueueArray[j + 1] = item;
			nItems++;
		}
	}
	
	public static void main (String args[]) {
		MyPriorityQueue pQueue = new MyPriorityQueue(5);
		pQueue.insert(30);
		pQueue.insert(10);
		pQueue.insert(50);
		pQueue.insert(40);
		pQueue.insert(100);
		
		while (!pQueue.isEmpty()) {
			System.out.println(pQueue.remove());
		}
	}
}
