package com.dsa.gayle.laakmann.chapter4.questions;

/*
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
 * a binary search tree. You may assume that each node has a link to its parent.
 * 
 * ALGO: To find inorder successor, we have two conditions: 
 * 1) Node has a right subtree - in this case the leftmost node of the right subtree is the inorder successor
 * 2) Node has no right subtree - in this case go up to parent till a parent is found for which the node is in its left subtree 
 */
public class Problem6 {
	
	public MyNode inorderSuccessor(MyNode node) {
		if (node != null) {
			if (node.getRightChild() != null) {
				// return leftmost child of right subtree
				return leftMostChild(node.getRightChild());
			} else {
				MyNode curr = node;
				MyNode parent = node.getParentNode();
				while (parent != null && parent.getLeftChild() != curr) {
					curr = parent;
					parent = parent.getParentNode();
				}
				return parent;
			}
		} else {
			return null;
		}		
	}
	
	public MyNode leftMostChild(MyNode node) {
		if (node == null) {
			return null;
		}
		while (node.getLeftChild() != null) {
			node = node.getLeftChild();
		}
		return node;
	}
	
	public static void main(String[] args) {
				/*
				5
			4		6
		2				9
					7		10
					*/
		MyBinaryTree tree = new MyBinaryTree();
		tree.insertWithParentRef(5);
		tree.insertWithParentRef(4);
		tree.insertWithParentRef(6);
		tree.insertWithParentRef(2);
		tree.insertWithParentRef(9);
		tree.insertWithParentRef(10);
		tree.insertWithParentRef(7);
		
		Problem6 p = new Problem6();
		System.out.println(p.inorderSuccessor(tree.find(5)));
		System.out.println(p.inorderSuccessor(tree.find(4)));
		System.out.println(p.inorderSuccessor(tree.find(6)));
		System.out.println(p.inorderSuccessor(tree.find(2)));
		System.out.println(p.inorderSuccessor(tree.find(9)));
		System.out.println(p.inorderSuccessor(tree.find(10)));
		System.out.println(p.inorderSuccessor(tree.find(7)));
		
	
	}
	
}
