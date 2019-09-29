package com.dsa.gayle.laakmann.chapter4.questions;

public class MyVertex {
	private String label;
	private boolean isVisited;
	private int index;
	
	public MyVertex(String label, int index) {
		super();
		this.label = label;
		this.index = index;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}		
}
