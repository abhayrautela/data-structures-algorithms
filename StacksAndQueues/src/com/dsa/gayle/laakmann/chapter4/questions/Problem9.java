package com.dsa.gayle.laakmann.chapter4.questions;

/*
 * You are given a binary tree in which each node contains a value. Design an algorithm
 * to print all paths which sum to a given value. The path does not need to start
 * or end at the root or a leaf.
 */
public class Problem9 {
	
	public void findPath(MyNode root, String currPath, int currValue, int targetValue) {		
		if (root != null) {
			currValue += root.getValue();
			currPath += root.getValue();
			if (currValue == targetValue) {
				System.out.println(currPath);
			} else {
				findPath(root.getLeftChild(), currPath, currValue, targetValue);
				findPath(root.getRightChild(), currPath, currValue, targetValue);
			}
		}
	}
	
	public void findForEachNode(MyNode root, int targetValue) {
		if (root != null) {
			findPath(root, "", 0, targetValue);
			findForEachNode(root.getLeftChild(), targetValue);
			findForEachNode(root.getRightChild(), targetValue);
		}
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
		
		Problem9 p = new Problem9();
		p.findForEachNode(tree.getRoot(), 11);
	}
	
}
