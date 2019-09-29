package com.dsa.linklist;

public class DoubleEndedLinkList {
	
	private Link first;
	private Link last;
	
	public DoubleEndedLinkList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		if (isEmpty()) {
			last = newLink;
		}
		newLink.setNext(first);
		first = newLink;
	}
	
	public void insertLast(int id, double dd) {
		Link newLink = new Link(id, dd);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.setNext(newLink);
		}
		last = newLink;
	}
	
	public void deleteFirst() {
		if (!isEmpty()) {
			first = first.getNext();
			if (first == null) {
				last = null;
			}
		}
	}

}
