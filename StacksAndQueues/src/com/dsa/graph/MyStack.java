package com.dsa.graph;

import java.lang.reflect.Array;

public class MyStack<K> {
	private K[] stackArray;
	private int maxSize;
	private int top;
	
	public MyStack(int s, Class<K[]> clazz) {
		maxSize = s;
		stackArray = clazz.cast(Array.newInstance(clazz.getComponentType(), s)); 
		top = -1;// stack is initially empty
	}
	
	public void push (K j) {
		if (!isFull())
			stackArray[++top] = j;
		else
			throw new UnsupportedOperationException("Stack is full. Cannot insert " + j);
	}
	
	public K pop() {
		if (!isEmpty())
			return stackArray[top--];
		else 
			throw new UnsupportedOperationException("Stack is empty.");
	}
	
	public K peek() {
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
		MyStack<String> s = new MyStack<String>(10, String[].class);
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
