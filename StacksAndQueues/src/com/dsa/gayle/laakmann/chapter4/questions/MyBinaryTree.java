package com.dsa.gayle.laakmann.chapter4.questions;

public class MyBinaryTree {
	private MyNode root;	
	
	public MyNode find(int x) {
		MyNode curr = root;
		if (curr != null) {
			while (curr != null) {
				if (curr.getValue() == x) {
					return curr;
				} else if (curr.getValue() < x) {
					curr = curr.getRightChild();
				} else {
					curr = curr.getLeftChild();
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	public void insertWithParentRef(int x) {
		MyNode node = new MyNode(x);
		if(root == null) {
			root = node;
		} else {
			MyNode parent = null;
			MyNode curr = root;
			while (curr != null) {
				if (x < curr.getValue()) {
					parent = curr;
					curr = curr.getLeftChild();
					if (curr == null) {
						parent.setLeftChild(node);
						node.setParentNode(parent);
					}
				} else if (x > curr.getValue()) {
					parent = curr;
					curr = curr.getRightChild();
					if (curr == null) {
						parent.setRightChild(node);
						node.setParentNode(parent);
					}
				} else {
					System.out.println("Node already exists.");
				}
			}
		}
	}
	
	public MyNode insert(int x) {
		MyNode node = new MyNode(x);
		if(root == null) {
			root = node;
		} else {
			MyNode parent = null;
			MyNode curr = root;
			while (curr != null) {
				if (x < curr.getValue()) {
					parent = curr;
					curr = curr.getLeftChild();
					if (curr == null) {
						parent.setLeftChild(node);
					}
				} else if (x > curr.getValue()) {
					parent = curr;
					curr = curr.getRightChild();
					if (curr == null) {
						parent.setRightChild(node);
					}
				} else {
					System.out.println("Node already exists.");
				}
			}
		}
		return node;
	}
	
	public MyNode getRoot() {
		return root;
	}

	public void setRoot(MyNode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		/*
			5
		4		6
	2				9
				7		10
				*/
		MyBinaryTree tree = new MyBinaryTree();
		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(2);
		tree.insert(9);
		tree.insert(10);
		tree.insert(7);
		System.out.println("Done");
	}
}