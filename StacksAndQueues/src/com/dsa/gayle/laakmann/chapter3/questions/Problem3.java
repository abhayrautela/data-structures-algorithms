package com.dsa.gayle.laakmann.chapter3.questions;

import java.util.ArrayList;
import java.util.List;

import com.dsa.queue.MyDeque;

/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore,
 * in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
 * Stacks should be composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
 * pop () should behave identically to a single stack (that is, pop () should return the
 * same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a
 * specific sub-stack.
 */
public class Problem3 {
	private List<MyStack<String>> listStack = new ArrayList<MyStack<String>>();
	private List<MyDeque> listQueue = new ArrayList<MyDeque>();
	private int MAX_STACK_SIZE = 5; //default
	
	public Problem3(int mAX_STACK_SIZE) {
		super();
		MAX_STACK_SIZE = mAX_STACK_SIZE;
		listStack.add(new MyStack<String>(MAX_STACK_SIZE, String[].class));
		listQueue.add(new MyDeque(MAX_STACK_SIZE));
	}

	public void push(String s) {
		if (listStack.get(listStack.size()-1).isFull()) {
			listStack.add(new MyStack<String>(MAX_STACK_SIZE, String[].class));
		}
		listStack.get(listStack.size()-1).push(s);
	}
	
	public void pushDequeue(String s) {
		if (listQueue.get(listQueue.size()-1).isFull()) {
			listQueue.add(new MyDeque(MAX_STACK_SIZE));
		}
		listQueue.get(listQueue.size()-1).push(s);
	}
	
	public String pop() {
		String s = listStack.get(listStack.size()-1).pop();
		if (listStack.get(listStack.size()-1).size() == 0) {
			listStack.remove(listStack.size()-1);
		}
		return s;
	}
	
	public String popAt(int index) {
		String s = listQueue.get(index).removeRear(); // same as pop operation in a stack
		if (listQueue.size() >= index) {
			for (int i=index+1;i<listQueue.size(); i++) {
				listQueue.get(i-1).push(listQueue.get(i).removeFront());
			}
		}		
		return s;
	}
	
	public static void main(String[] args) {
		Problem3 p = new Problem3(3);
		for (int i=0; i<9; i++) {
			String x = String.valueOf(Math.floor(Math.random() * 100));
			p.push(String.valueOf(x));
			p.pushDequeue(String.valueOf(x));
		}
		p.popAt(1); // second in list
		System.out.println("Done");
	}

}
