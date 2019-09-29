package com.dsa.stack;

public class MyCharStack {
	private char[] stackArray;
	private int maxSize;
	private int top;
	
	public MyCharStack(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;// stack is initially empty
	}
	
	public void push (char j) {
		if (!isFull())
			stackArray[++top] = j;
		else
			throw new UnsupportedOperationException("Stack is full. Cannot insert " + j);
	}
	
	public char pop() {
		if (!isEmpty())
			return stackArray[top--];
		else 
			throw new UnsupportedOperationException("Stack is empty.");
	}
	
	public char peek() {
		if (!isEmpty())
			return stackArray[top];
		else
			throw new UnsupportedOperationException("Stack is empty.");
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == (maxSize - 1));
	}
	
	public static void main (String args[]) {
		MyCharStack s = new MyCharStack(10);
		try {
			s.peek();
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}
		try {
			s.pop();
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}
		int i = 0;
		try {
			for (; i < 10; i++) 
				s.push((char)i);
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}				
		try {
			s.push((char) i);
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}		
		System.out.println("Peeking..." + s.peek());
		System.out.println("Popping..." + s.pop());
		System.out.println("Popping..." + s.pop());
		
	}
}
