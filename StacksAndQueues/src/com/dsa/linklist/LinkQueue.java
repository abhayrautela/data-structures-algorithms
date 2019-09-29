package com.dsa.linklist;

public class LinkQueue {
	
	private DoubleEndedLinkList linkList;
	
	public LinkQueue() {
		linkList = new DoubleEndedLinkList();
	}
	
	public void insert(int id, double dd) {
		linkList.insertLast(id, dd);
	}
	
	public void remove() {
		linkList.deleteFirst();
	}

}
