package com.dsa.linklist;

public class DoublyLinkList {
	private Link first;
	private Link last;
	
	public DoublyLinkList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int i, double d) {
		Link newLink = new Link(i, d);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.setPrevious(newLink);
		}
		newLink.setNext(first);
		first = newLink;
	}
	
	public void insertLast(int i, double d) {
		Link newLink = new Link(i, d);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.setNext(newLink);
		}
		newLink.setPrevious(last);
		last = newLink;
	}
	
	public Link deleteFirst() {
		return null;
	}
	
	public Link deleteLast() {
		return null;
	}

}
 