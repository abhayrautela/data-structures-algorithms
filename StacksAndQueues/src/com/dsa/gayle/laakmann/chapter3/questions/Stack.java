package com.dsa.gayle.laakmann.chapter3.questions;

public interface Stack<T> {
	
	public void push(T element);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public boolean isFull();
	public int size();
}
