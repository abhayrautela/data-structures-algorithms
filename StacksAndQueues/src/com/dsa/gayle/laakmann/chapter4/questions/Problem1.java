package com.dsa.gayle.laakmann.chapter4.questions;

/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one.
 */
public class Problem1 {
	public boolean isBTBalanced(MyNode node) {
		if (node == null) {
			return true;
		}
		if (Math.abs(getHeight(node.getLeftChild()) - getHeight(node.getRightChild())) > 1) {
			return false;
		} else {
			return isBTBalanced(node.getLeftChild()) && isBTBalanced(node.getRightChild());
		}
	}
	
	public int getHeight(MyNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1;
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
		
		Problem1 prob = new Problem1();
		if (prob.isBTBalanced(tree.getRoot())) {
			System.out.println("Tree is balanced");
		} else {
			System.out.println("Tree is not balanced");
		}
		
	}

}
