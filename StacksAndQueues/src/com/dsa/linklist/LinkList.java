package com.dsa.linklist;

public class LinkList {
	
	private Link first;
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(int id, double dd) {
		Link newLink  = new Link(id, dd);
		newLink.setNext(first);
		first = newLink;
	}
	
	public Link deleteFirst () {
		Link temp = null;
		if (!isEmpty()) {
			temp = first;
			first = first.getNext();
		}
		return temp;
	}
	
	public void displayLinks() {
		Link curr = first;
		while (curr != null) {
			curr.displayLink();
			curr = curr.getNext();
		}
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
	
	public Link find(int key) {
		Link curr = first;
		while (curr != null) {
			if (curr.getIData() ==  key) {
				break;
			}
			curr = curr.getNext();
		}
		return curr;
	}
	
	public LinkListIterator iterator() {
		return new LinkListIterator(this);
	}
	
	public static void main (String args[]) {
		LinkList linkList = new LinkList();
		linkList.insertFirst(10, 10.1);
		linkList.insertFirst(11, 10.2);
		linkList.insertFirst(12, 10.3);
		linkList.insertFirst(13, 10.4);
		linkList.displayLinks();
		linkList.deleteFirst();
		linkList.displayLinks();
		linkList.insertFirst(14, 10.5);
		linkList.insertFirst(15, 10.6);
		linkList.displayLinks();
		System.out.println("finding key 14...");
		linkList.find(14).displayLink();
		System.out.println("deleting key 14..");
		linkList.delete(14);
		linkList.displayLinks();
	}

	public Link getFirst() {
		return first;
	}

	public void setFirst(Link first) {
		this.first = first;
	}

}
