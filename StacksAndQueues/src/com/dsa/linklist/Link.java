package com.dsa.linklist;

public class Link {
	private int iData;
	private double dData;
	private Link next;
	private Link previous;
	
	public Link getPrevious() {
		return previous;
	}

	public void setPrevious(Link previous) {
		this.previous = previous;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}
	
	public Link() {
		
	}

	public Link(int id, double dd) {
		iData = id;
		dData = dd;
	}
	
	public void displayLink() {
		System.out.println("iData : " + iData + " dData : " + dData);
	}

	public int getIData() {
		return iData;
	}

	public void setIData(int data) {
		iData = data;
	}

	public double getDData() {
		return dData;
	}

	public void setDData(double data) {
		dData = data;
	}
}
