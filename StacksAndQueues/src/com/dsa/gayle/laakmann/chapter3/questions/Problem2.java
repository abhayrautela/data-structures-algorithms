package com.dsa.gayle.laakmann.chapter3.questions;

import com.dsa.gayle.laakmann.chapter3.questions.Problem2.ElementWithMinAndValue;

/*
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in 0(1) time
 */
public class Problem2 implements Stack<ElementWithMinAndValue> {
	
	private ElementWithMinAndValue[] arr = null;
	private int maxElements = 10; // default
	private int count = 0;
	private int top = -1;
	
	public Problem2(int maxElements) {
		this.maxElements = maxElements;
		arr = new ElementWithMinAndValue[this.maxElements];
	}
	
	@Override
	public void push(ElementWithMinAndValue element) {
		if (!isFull()) {
			if (isEmpty()) {
				element.setMin(element.getValue());
			} else if (element.getValue() < minimum()) {
				element.setMin(element.getValue());
			} else {
				element.setMin(minimum());
			}
			arr[++top] = element;
			count++;
		}		
	}
	
	public int minimum() {
		return peek().getMin();
	}
	
	@Override
	public ElementWithMinAndValue pop() {
		count--;
		return  arr[top--];
	}
	
	@Override
	public ElementWithMinAndValue peek() {
		return arr[top];
	}
	
	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if (top == maxElements-1)
			return true;
		else
			return false;
	}
	
	public class ElementWithMinAndValue {
		private int value;
		private int min;
		
		public ElementWithMinAndValue(int value) {
			super();
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
	}

	@Override
	public int size() {
		return count;
	}
	
	public static void main(String[] args) {
		Problem2 prob =  new Problem2(10);
		for (int i=0; i<10; i++) {
			int value = (int) (Math.random() * 100);
			System.out.println(value);
			prob.push(prob.new ElementWithMinAndValue(value));
		}
	}
}
