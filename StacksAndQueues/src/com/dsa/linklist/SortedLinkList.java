package com.dsa.linklist;

public class SortedLinkList {
	
	private Link first;
	
	public SortedLinkList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void display() {
		Link curr = first;
		while (curr != null) {
			System.out.println(curr.getIData());
			System.out.println(curr.getDData());
			curr = curr.getNext();
		}
	}
	
	public void insert(int i, double d) {
		Link temp = new Link(i, d);
		Link curr = first;
		Link prev = null;
		while (curr != null && i >= curr.getIData()) {
			prev = curr;
			curr = curr.getNext();
		}
		if (prev == null) {
			// list is empty
			first = temp;
		} else {
			prev.setNext(temp);
		}
		temp.setNext(curr);
	}
	
	public Link remove() {
		// removes first element
		Link temp = null;
		if (!isEmpty()) {
			temp = first;
			first = first.getNext();	
		}
		return temp;
	}
	
	public Link delete(int key) {
		Link curr = first;
		Link prev = null;
		Link temp = null;
		while (curr != null) {
			if (curr.getIData() ==  key) {
				temp = curr;
				if (prev == null) {
					first = curr.getNext();
				} else {
					prev.setNext(curr.getNext());
				}
				break;
			}
			prev = curr;
			curr = curr.getNext();
		}
		return temp;
	}

}
