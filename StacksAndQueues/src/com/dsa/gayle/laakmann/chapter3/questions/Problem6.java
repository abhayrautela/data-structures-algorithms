package com.dsa.gayle.laakmann.chapter3.questions;

/*
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy the
 * elements into any other data structure (such as an array). The stack supports the
 * following operations: push, pop, peek, and isEmpty.
 */
public class Problem6 {
	
	private MyStack<Long> myStack = null;
	private MyStack<Long> tempStack = null;
	
	public Problem6(int size) {
		myStack = new MyStack<Long>(size, Long[].class);
		tempStack = new MyStack<Long>(size, Long[].class);
		for (int i=0; i<size; i++) {
			myStack.push(Math.round(Math.random()*100));
		}
	}
	
	public void sort() {
		Long element = null;
		while (!myStack.isEmpty() && (element = myStack.pop()) != null) {
			while (!tempStack.isEmpty() && element < tempStack.peek()) {
				myStack.push(tempStack.pop());
			}
			tempStack.push(element);
		}
	}
	
	public static void main(String[] args) {
		Problem6 p = new Problem6(10);
		p.sort();
		System.out.println("Sort complete");
	}
	
}
