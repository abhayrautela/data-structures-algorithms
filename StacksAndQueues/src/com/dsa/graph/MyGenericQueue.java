package com.dsa.graph;

import java.lang.reflect.Array;

public class MyGenericQueue<K> {
	private K[] queueArray;
	private int maxSize;
	private int front;
	private int rear;
	private int nItems;
	
	public MyGenericQueue(int n, Class<K[]> clazz) {
		queueArray = clazz.cast(Array.newInstance(clazz.getComponentType(), n));
		nItems = 0;
		maxSize = n;
		front = 0;
		rear = -1;
	}
	
	public void insert(K x) {
		if (!isFull()) {
			if (rear == maxSize -1)
				rear = -1;
			queueArray[++rear] = x;
			nItems++;
		} else {
			throw new UnsupportedOperationException("Cannot insert as queue is full.");
		}
	}
	
	public K remove() {
		if (!isEmpty()) {
			K temp = queueArray[front++];
			if (front == maxSize)
				front = 0;
			nItems--;			
			return temp;
		} else {
			throw new UnsupportedOperationException("Cannot remove as queue is empty.");
		}
	}
	
	public K peek() {
		if (!isEmpty())
			return queueArray[front];
		throw new UnsupportedOperationException("Cannot peek as queue is empty.");
	}
	
	public boolean isEmpty() {
		if (nItems == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if (nItems == maxSize)
			return true;
		else
			return false;
	}
	
	public static void main (String args[]) {
		MyGenericQueue<Integer> queue = new MyGenericQueue<Integer>(10, Integer[].class);
		System.out.println("front : " + queue.front + " rear : " + queue.rear);
		System.out.println("Remove from empty queue");
		try {
			queue.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("Peek from empty queue");
		try {
			queue.peek();
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		int i = 0;			
		System.out.println("inserting 10 elements");
		for (; i < 10; i++) {				
			queue.insert(i);
			System.out.println("Inserting " + i);
		}
		System.out.println("front : " + queue.front + " rear : " + queue.rear);
		try {
			queue.insert(i++);
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("front : " + queue.front + " rear : " + queue.rear);
		try {
			queue.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("front : " + queue.front + " rear : " + queue.rear);
		try {
			queue.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("front : " + queue.front + " rear : " + queue.rear);
		try {
			queue.insert(i++);
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("front : " + queue.front + " rear : " + queue.rear);
		try {
			queue.insert(i++);
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("front : " + queue.front + " rear : " + queue.rear);		
	}

}
