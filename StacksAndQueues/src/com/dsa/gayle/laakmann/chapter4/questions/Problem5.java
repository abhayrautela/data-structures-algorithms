package com.dsa.gayle.laakmann.chapter4.questions;

/*
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Problem5 {
	
	private static MyBinaryTree tree;
	
	private int lastValue;
	
	public Problem5() {
				/*
				5
			4		6
		2				9
					7		10
					*/
		tree = new MyBinaryTree();
		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(2);
		tree.insert(9);
		tree.insert(10);
		tree.insert(7);
	}
	
	/*
	 * uses inorder traversal
	 */
	public boolean isBST(MyNode node) {
		if (node != null) {
			if (!isBST(node.getLeftChild()))
				return false;			 
			if (node.getValue() < lastValue) {
				return false;
			}
			this.lastValue = node.getValue();
			if (!isBST(node.getRightChild()))
				return false;
		}		
		return true;
	}
	
	public static void main(String[] args) {
		Problem5 p = new Problem5();
		boolean isBST = p.isBST(tree.getRoot());
		System.out.println(isBST);
	}

}
