package com.dsa.linklist;

public class LinkListIterator {
	
	private Link curr;
	private Link prev;
	private LinkList ourList;
	
	public LinkListIterator(LinkList list) {
		ourList = list;
		reset();
	}
	
	public void reset() {
		curr = ourList.getFirst();
		prev = null;
	}
	
	public boolean atEnd() {
		return curr.getNext() == null;
	}
	
	public void nextLink() {
		prev = curr;
		curr = curr.getNext();
	}
	
	public Link getCurr() {
		return curr;
	}
	public void setCurr(Link curr) {
		this.curr = curr;
	}
	public Link getPrev() {
		return prev;
	}
	public void setPrev(Link prev) {
		this.prev = prev;
	}
	public LinkList getList() {
		return ourList;
	}
	public void setList(LinkList list) {
		this.ourList = list;
	}

}
