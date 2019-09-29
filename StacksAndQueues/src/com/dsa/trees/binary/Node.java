package com.dsa.trees.binary;

public class Node {
	
	private int data;
	private String sData;
	private Node random;
	
	public Node getRandom() {
		return random;
	}
	public void setRandom(Node random) {
		this.random = random;
	}
	public String getsData() {
		return sData;
	}
	public void setsData(String sData) {
		this.sData = sData;
	}
	private Node leftChild;
	private Node rightChild;	
	public Node(int x) {
		this.data = x;
	}
	public Node(String x) {
		this.sData = x;
	}	
	public Node(int x, String y) {
		this.data = x;
		this.sData = y;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

}
