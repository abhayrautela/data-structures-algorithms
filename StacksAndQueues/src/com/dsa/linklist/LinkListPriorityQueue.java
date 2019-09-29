package com.dsa.linklist;


public class LinkListPriorityQueue {
	
	private Link first;
	
	public void push(int id, double dd) {
		Link newLink = new Link(id, dd);
		if (isEmpty()) {
			first = newLink;
		} else {
			Link curr = first;
			Link previous = null;
			while (curr != null) {
				if (id <= curr.getIData()) {
					newLink.setNext(curr);
					if (previous == null) {
						first = newLink;
					} else {
						previous.setNext(newLink);
					}
					break;
				} else {
					previous = curr;
					curr = curr.getNext();										
				}				
			}
			if (previous != null)
				previous.setNext(newLink);
		}
	}
	
	public Link pop() {
		Link temp = first;
		if (!isEmpty())
			first = first.getNext();
		System.out.println(temp.getIData());
		return temp;
	}
	
	public Link peek() {
		System.out.println(first.getIData());
		return first;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public static void main(String[] args) {
		String x = "Abhay";
		int a = x.charAt(0);
		System.out.println(a);
	}

}
