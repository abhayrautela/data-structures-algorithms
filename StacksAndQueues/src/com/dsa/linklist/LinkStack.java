package com.dsa.linklist;

public class LinkStack {
	
	private LinkList linkList;
	
	public LinkStack() {
		linkList = new LinkList();
	}
	
	public void push(int id, double dd) {
		linkList.insertFirst(id, dd);
	}
	
	public Link pop() {
		return linkList.deleteFirst();
	}

}
