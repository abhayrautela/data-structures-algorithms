package com.dsa.gayle.laakmann.chapter3.questions;

import java.lang.reflect.Array;


public class MyStack<T> implements Stack<T> {
	
	private T[] arr = null;
	private int maxElements = 10; // default
	private int size = 0;
	private int top = -1;

	public MyStack(int maxElements, Class<T[]> clazz) {
		super();
		this.maxElements = maxElements;
		this.arr = clazz.cast(Array.newInstance(clazz.getComponentType(), maxElements));
	}

	@Override
	public void push(T element) {
		if (!isFull()) {			
			arr[++top] = element;
			size++;
		}
	}

	@Override
	public T pop() {
		size--;
		return  arr[top--];
	}

	@Override
	public T peek() {
		if (!isEmpty())
			return arr[top];
		else
			return null;
	}

	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isFull() {
		if (top == maxElements-1)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return size;
	}

}
