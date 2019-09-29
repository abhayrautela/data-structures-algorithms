package com.dsa.gayle.laakmann.chapter2.questions;

public class GenericLink<T> {
	
	private T element;
	private GenericLink<T> next;

	public GenericLink(T element) {
		super();
		this.element = element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	public GenericLink<T> next() {
		return next;
	}

	public void setNext(GenericLink<T> next) {
		this.next = next;
	}
}
