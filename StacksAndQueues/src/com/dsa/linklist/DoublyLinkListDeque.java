package com.dsa.linklist;

public class DoublyLinkListDeque {
	
	private Link first;
	private Link last;
	
	public void pushFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		if (isEmpty()) {			
			last = newLink;
		} else {
			newLink.setNext(first);
			first.setPrevious(newLink);
		}
		first = newLink;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

	public void pushLast(int id, double dd) {
		Link newLink = new Link(id, dd);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.setNext(newLink);
			newLink.setPrevious(last);
		}
		last = newLink;
	}
	
	public Link popFirst() {
		Link temp = first;
		if (!isEmpty()) {
			first = first.getNext();
			first.setPrevious(null);
		}
		return temp;
	}
	
	public Link popLast() {
		Link temp = last;
		if (!isEmpty()) {
			last = last.getPrevious();
			last.setNext(null);
		}
		return temp;
	}
	
	public Link getFirst() {
		return first;
	}

	public Link getLast() {
		return last;
	}

	public static void main(String[] args) {
		DoublyLinkListDeque deque = new DoublyLinkListDeque();
		deque.pushFirst(30, 10);
		deque.pushFirst(20, 10);
		deque.pushFirst(10, 10);
		deque.pushLast(40, 10);
		deque.pushLast(50, 10);
		deque.pushLast(60, 10);
		Link curr = deque.getFirst();
		while(curr != null) {
			System.out.println(curr.getIData());
			curr = curr.getNext();
		}
		deque.popFirst();
		deque.popLast();
		curr = deque.getFirst();
		while(curr != null) {
			System.out.println(curr.getIData());
			curr = curr.getNext();
		}
	}

}
