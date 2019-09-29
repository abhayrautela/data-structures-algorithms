package com.dsa.gayle.laakmann.chapter3.questions;

/*
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Problem5 {
	
	private MyStack<String> stackNewestOnTop = null;
	private MyStack<String> stackOldestOnTop = null;
	private int size;
	
	public Problem5(int size) {
		stackNewestOnTop = new MyStack<String>(size, String[].class);
		stackOldestOnTop = new MyStack<String>(size, String[].class);
		this.size = size;
	}
	
	public void push(String x) {
		while (!stackOldestOnTop.isEmpty()) {
			stackNewestOnTop.push(stackOldestOnTop.pop());
		}
		stackNewestOnTop.push(x);
	}
	
	public String pop() {
		while (!stackNewestOnTop.isEmpty()) {
			stackOldestOnTop.push(stackNewestOnTop.pop());
		}
		return stackOldestOnTop.pop();
	}
	
	public static void main(String[] args) {
		Problem5 p = new Problem5(5);
		p.push("1");
		p.push("2");
		p.push("3");
		p.push("4");
		p.push("5");
		
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.pop());
		System.out.println(p.pop());
	}

}
