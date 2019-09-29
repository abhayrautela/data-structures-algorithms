package com.dsa.gayle.laakmann.chapter4.questions;

public class MyNode {
	@Override
	public String toString() {
		return "MyNode [value=" + value + "]";
	}

	private int value;
	private MyNode leftChild;
	private MyNode rightChild;
	private MyNode parentNode;
	private MyNode random;
	
	public MyNode getRandom() {
		return random;
	}
	
	public void setRandom(MyNode node) {
		this.random = node;
	}
	
	public MyNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(MyNode parentNode) {
		this.parentNode = parentNode;
	}

	public MyNode(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setLeftChild(MyNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(MyNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public MyNode getLeftChild() {
		return this.leftChild;
	}
	
	public MyNode getRightChild() {
		return this.rightChild;
	}
}