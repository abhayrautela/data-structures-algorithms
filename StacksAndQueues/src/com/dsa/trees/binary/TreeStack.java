package com.dsa.trees.binary;

public class TreeStack {
	private Node[] stackArray;
	private int maxSize;
	private int top;
	
	public TreeStack(int s) {
		maxSize = s;
		stackArray = new Node[maxSize];
		top = -1;// stack is initially empty
	}
	
	public void push (Node j) {
		if (!isFull())
			stackArray[++top] = j;
		else
			throw new UnsupportedOperationException("Stack is full. Cannot insert " + j);
	}
	
	public Node pop() {
		if (!isEmpty())
			return stackArray[top--];
		else 
			throw new UnsupportedOperationException("Stack is empty.");
	}
	
	public Node peek() {
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
}
