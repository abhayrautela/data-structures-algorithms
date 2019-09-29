package com.dsa.stack;

public class MyStringStack {
	private String[] stackArray;
	private int maxSize;
	private int top;
	
	public MyStringStack(int s) {
		maxSize = s;
		stackArray = new String[maxSize];
		top = -1;// stack is initially empty
	}
	
	public void push (String j) {
		if (!isFull())
			stackArray[++top] = j;
		else
			throw new UnsupportedOperationException("Stack is full. Cannot insert " + j);
	}
	
	public String pop() {
		if (!isEmpty())
			return stackArray[top--];
		else 
			throw new UnsupportedOperationException("Stack is empty.");
	}
	
	public String peek() {
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
		MyStringStack s = new MyStringStack(10);
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
				s.push(String.valueOf(i));
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}				
		try {
			s.push(String.valueOf(i));
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}		
		System.out.println("Peeking..." + s.peek());
		System.out.println("Popping..." + s.pop());
		System.out.println("Popping..." + s.pop());
		
	}
}
