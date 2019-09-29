package com.dsa.gayle.laakmann.chapter2.questions;


public class GenericLinkListAddLast<T> {
	
	private GenericLink<T> first;
	private int nCurr;
	
	public int getnCurr() {
		return nCurr;
	}

	public void setFirst(GenericLink<T> first) {
		this.first = first;
	}

	public GenericLink<T> getFirst() {
		return first;
	}

	public boolean isEmpty() {
		return (first == null);
	}
	
	public void add(T element) {
		if (isEmpty()) {
			first = new GenericLink<T>(element);
		} else {
			GenericLink<T> curr = first;
			GenericLink<T> previous = first;
			while (curr != null) {
				previous = curr;
				curr = curr.next();
			}				
			GenericLink<T> link = new GenericLink<T>(element);
			previous.setNext(link);
		}
		nCurr++;
	}
	
	public void remove(String s) {
		GenericLink<T> curr = first;
		GenericLink<T> previous = null;
		while (curr != null) {
			if (curr.getElement().equals(s)) {
				if (previous == null) {
					first = curr.next();
				} else {
					previous.setNext(curr.next()); 
				}
				nCurr++;
			} else {
				previous = curr;
				curr = curr.next();
			}
		}
	}
	
	public String display() {
		GenericLink<T> curr = first;
		StringBuilder buff = new StringBuilder();
		while (curr != null) {
			System.out.print(curr.getElement());
			buff.append(curr.getElement());
			curr = curr.next();
		}
		return buff.toString();
	}

}
