package com.dsa.queue;


public class MyDeque {
	
	private String[] dequeArray;
	private int nItems;
	private int front;
	private int rear;
	private int maxSize;
	
	public MyDeque(int n) {
		maxSize = n;
		dequeArray = new String[maxSize];
		nItems = 0;
		front = 0;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public boolean isFull() {
		return nItems == maxSize;
	}
	
	public void insertRear(String item) {
		if (!isFull()) {
			if (rear == maxSize - 1) {
				rear = -1;
			}
			dequeArray[++rear] = item;
			nItems++;
		} else {
			throw new UnsupportedOperationException("Queue is full");
		}
	}
	
	public void insertFront(String item) {
		if (!isFull()) {
			if (front == 0) {
				front = maxSize;
			}
			dequeArray[--front] = item;
			nItems++;
		} else {
			throw new UnsupportedOperationException("Queue is full");
		}
	}
	
	public String removeRear() {
		if (!isEmpty()) {
			String temp = dequeArray[rear--];
			nItems--;
			return temp;
		} else {
			throw new UnsupportedOperationException("Queue is empty");
		}
	}
	
	public String removeFront() {
		if (!isEmpty()) {
			String temp = dequeArray[front++];
			if (front == maxSize) {
				front = 0;
			}
			nItems--;
			return temp;
		} else {
			throw new UnsupportedOperationException("Queue is empty");
		}
	}
	
	public void push(String item) {
		insertRear(item);
	}
	
	public String pop() {
		return removeRear();
	}
	
	public void insert(String item) {
		insertRear(item);
	}
	
	public String remove() {
		return removeFront();
	}
	
	public static void main (String args[]) {
		// access it as a stack
		MyDeque deq = new MyDeque(5);
		deq.push("A");
		deq.push("B");
		deq.push("H");
		deq.push("A");
		deq.push("Y");
		System.out.println(deq.pop());
		System.out.println(deq.pop());
		System.out.println(deq.pop());
		System.out.println(deq.pop());
		System.out.println(deq.pop());
		
		// access it as a queue
		deq.insert("A");
		deq.insert("B");
		deq.insert("H");
		deq.insert("A");
		deq.insert("Y");
		System.out.println(deq.remove());
		System.out.println(deq.remove());
		System.out.println(deq.remove());
		System.out.println(deq.remove());
		System.out.println(deq.remove());
	}
}
