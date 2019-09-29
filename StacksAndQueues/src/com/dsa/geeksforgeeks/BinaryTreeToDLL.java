package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyBinaryTree;
import com.dsa.gayle.laakmann.chapter4.questions.MyNode;
import com.dsa.linklist.Link;

public class BinaryTreeToDLL {
	
	Link head = null;

	Link BToDll(MyNode node, Link prev, boolean isLeftChild) {
		if (node == null) {
			if (head == null && prev != null) {
				head = prev;
			}
			return null;
		}
		Link curr = new Link(node.getValue(), 0);
		Link prevProcessed = BToDll(node.getLeftChild(), curr, true);
		if (isLeftChild) {
			curr.setNext(prevProcessed);
			if (prevProcessed != null)
				prevProcessed.setPrevious(curr);
		} else {
			if (prevProcessed != null)
				prevProcessed.setNext(curr);
			curr.setPrevious(prevProcessed);
		}
		prevProcessed = BToDll(node.getRightChild(), curr, false);
		return prevProcessed;
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
		MyNode root = tree.getRoot();
		BinaryTreeToDLL d = new BinaryTreeToDLL();
		d.BToDll(root, null, true);
		while (d.head != null) {
			System.out.println(d.head.getIData() + ",");
			d.head = d.head.getNext();
		}
	}
	
}
