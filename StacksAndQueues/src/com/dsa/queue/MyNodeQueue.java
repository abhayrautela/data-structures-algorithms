package com.dsa.queue;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

public class MyNodeQueue {
	private MyNode[] queueArray;
	private int maxSize;
	private int front;
	private int rear;
	private int nItems;
	
	public MyNodeQueue(int n) {
		queueArray = new MyNode[n];
		nItems = 0;
		maxSize = n;
		front = 0;
		rear = -1;
	}
	
	public void insert(MyNode node) {
		if (!isFull()) {
			if (rear == maxSize -1)
				rear = -1;
			queueArray[++rear] = node;
			nItems++;
		} else {
			throw new UnsupportedOperationException("Cannot insert as queue is full.");
		}
	}
	
	public MyNode remove() {
		if (!isEmpty()) {
			MyNode temp = queueArray[front++];
			if (front == maxSize)
				front = 0;
			nItems--;			
			return temp;
		} else {
			throw new UnsupportedOperationException("Cannot remove as queue is empty.");
		}
	}
	
	public MyNode peek() {
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
		MyNodeQueue queue = new MyNodeQueue(10);
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
			queue.insert(new MyNode(i));
			System.out.println("Inserting " + i);
		}
		System.out.println("front : " + queue.front + " rear : " + queue.rear);
		try {
			queue.insert(new MyNode(i++));
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
			queue.insert(new MyNode(i++));
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("front : " + queue.front + " rear : " + queue.rear);
		try {
			queue.insert(new MyNode(i++));
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("front : " + queue.front + " rear : " + queue.rear);		
	}

}
