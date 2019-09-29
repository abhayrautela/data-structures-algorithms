package com.dsa.gayle.laakmann.chapter4.questions;

/*
 * Determine if a binary tree is a binary search tree
 */
public class Problem10 {
	
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
		
		Problem10 prob = new Problem10();
		if (prob.isBSTBruteForce(tree.getRoot())) {
			System.out.println("Tree is a BST");
		} else {
			System.out.println("Tree is not a BST");
		}
		
		if (prob.isBSTEffecient(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("Tree is a BST");
		} else {
			System.out.println("Tree is not a BST");
		}
		
		if (prob.isBstUsingInorder(tree.getRoot(), Integer.MIN_VALUE)) {
			System.out.println("Tree is a BST");
		} else {
			System.out.println("Tree is not a BST");
		}
	}
	
	/*
	 * This method is not effecient. The algo is: A binary tree is a BST if :
	 * 1. Node value is > left child
	 * 2. Node value is < right child
	 * 1 and 2 are true for left and right subtree.
	 */
	boolean isBSTBruteForce(MyNode node) {
		if (node == null) {
			return true;
		}
		return isSubtreeLessThan(node.getLeftChild(), node.getValue()) && isSubtreeGreaterThan(node.getRightChild(), node.getValue()) && isBSTBruteForce(node.getLeftChild()) && isBSTBruteForce(node.getRightChild());
	}

	boolean isSubtreeLessThan(MyNode node, int value) {
		if (node == null) {
			return true;
		}
		
		return (node.getValue() < value) && isSubtreeLessThan(node.getLeftChild(), value) && isSubtreeLessThan(node.getRightChild(), value);
	}

	boolean isSubtreeGreaterThan(MyNode node, int value) {
		if (node == null) {
			return true;
		}
		if (node.getValue() <= value) {
			return false;
		}
		return (node.getValue() > value) && isSubtreeGreaterThan(node.getLeftChild(), value) && isSubtreeGreaterThan(node.getRightChild(), value);
	}
	
	/*
	 * This runs in O(LogN). 
	 *   10
	 *  /  \
	 * 5   15
	 *    /  \
	 *   6    20
     * Instead of examining all nodes of both subtrees in each pass, we only need to examine two nodes in each pass.
     * Refer back to the binary tree (1) above. As we traverse down the tree from node (10) to right node (15), 
     * we know for sure that the right node’s value fall between 10 and +INFINITY. 
     * Then, as we traverse further down from node (15) to left node (6), we know for sure that the left node’s value 
     * fall between 10 and 15. And since (6) does not satisfy the above requirement, we can quickly determine it is not a valid BST. 
     * All we need to do is to pass down the low and high limits from node to node! 
	 */
	boolean isBSTEffecient(MyNode node, int low, int high) {
		if (node == null) {
			return true;
		}
		if (node.getValue() <= low && node.getValue() >= high) {
			return false;
		}
		return isBSTEffecient(node.getLeftChild(), low, node.getValue()) && isBSTEffecient(node.getRightChild(), node.getValue(), high); 
	}
	
	/*
	 * This algo also runs in O(N) time and O(1) space. Traverse the tree inorder and check if 
	 * current node value is greater or equal to previous traversed value 
	 */
	boolean isBstUsingInorder(MyNode node, int prev) {
		if (node == null) {
			return true;
		}
		isBstUsingInorder(node.getLeftChild(), node.getValue());
		if (node.getValue() < prev) {
			return false;
		}
		isBstUsingInorder(node.getRightChild(), node.getValue());
		return true;
	}

}
