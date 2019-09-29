package com.dsa.algo;

import com.dsa.gayle.laakmann.chapter4.questions.MyBinaryTree;
import com.dsa.gayle.laakmann.chapter4.questions.MyNode;
import com.dsa.linklist.Link;

public class Problem6 {
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
		Link link = BToDll(root, null, false);
		while (link != null) {
			System.out.println(link.getIData() + ",");
			link = link.getNext();
		}
	}
	
	private static Link BToDll(MyNode node, Link prev, boolean isRight) {
		Link link = null;
		if (node != null) {			
			link = new Link();
			link.setIData(node.getValue());
			Link previous = BToDll(node.getLeftChild(), link, false);			
			if (previous != null) {
				previous.setNext(link);				
			}
			link.setPrevious(previous);
			BToDll(node.getRightChild(), link, true);
		}
		if (link != null) {
			return link;
		} else {
			return prev;
		}		
	}
}
