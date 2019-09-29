package com.dsa.algo;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

/*
 * Given a binary tree, print nodes of extreme corners of each level but in alternate order.
 * Refer http://www.practice.geeksforgeeks.org/problem-page.php?pid=700308
 */
public class Problem2 {
	private MyNode root;
	
	public static void main(String args[]) {
		MyNode root = new MyNode(1);
		root.setLeftChild(new MyNode(2));
		root.setRightChild(new MyNode(3));
		root.getLeftChild().setLeftChild(new MyNode(4));
		root.getLeftChild().setRightChild(new MyNode(5));
		root.getRightChild().setLeftChild(new MyNode(6));
		root.getRightChild().setRightChild(new MyNode(7));
		print(root);
	}
	
	private static void print(MyNode root) {
		if (root != null) {
			System.out.print(root.getValue());
			MyNode leftNode = root.getLeftChild();
			MyNode rightNode = root.getRightChild();
			int count = 0;
			while (leftNode != null && rightNode != null) {
				if (count++ % 2 == 0) {
					System.out.print(leftNode.getValue());
				} else {
					System.out.print(rightNode.getValue());
				}
				if (leftNode.getLeftChild() != null) {
					leftNode = leftNode.getLeftChild();
				} else {
					leftNode = leftNode.getRightChild();
				}
				if (rightNode.getRightChild() != null) {
					rightNode = rightNode.getRightChild();
				} else {
					rightNode = rightNode.getLeftChild();
				}
			}
		}
	}
}
