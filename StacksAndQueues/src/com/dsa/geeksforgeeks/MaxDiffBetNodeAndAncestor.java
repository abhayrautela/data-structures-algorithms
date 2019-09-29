package com.dsa.geeksforgeeks;

import com.dsa.trees.binary.Node;

public class MaxDiffBetNodeAndAncestor {
	
	/*
	 * Given a Binary Tree you need to  find maximum value which you  can get by subtracting value of node B from value of node A, 
	 * where A and B are two nodes of the binary tree and A is an ancestor of B . You are required to complete the function maxDiff . 
	 * You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.
	 * 
	 * Input:
	 * The task is to complete the function maxDiff which takes 1 argument, root of the Tree . The struct node has a data part which stores the data, 
	 * pointer to left child and pointer to right child.
	 * There are multiple test cases. For each test case, this method will be called individually.
	 * 
	 * Output:
	 * The function should return an integer denoting the maximum difference.
	 * 
	 * Constraints:
	 * 1 <=T<= 30
	 * 1 <=Number of nodes<= 100
	 * 1 <=Data of a node<= 1000
	 * 
	 * Example
	 * Input
	 * 1
	 * 2
	 * 5 2 L 5 1 R
	 * 
	 * Output
	 * 4
	 * 
	 *         5
     *      /    \
     *     2       1
     *     In above example there is one test case which represents a  tree with 3 nodes and 2 edges where root is 5, 
     *     left child of 5 is 2 and right child of 5 is 1 hence the max difference we can get is from 5 and 1 ie 4 .
	 */
	int maxDiff(Node root)
	{
		//Your code here
		if (root == null) {
		    return Integer.MIN_VALUE;
		}
		int max = java.lang.Math.max(findDiff(root, root.getLeftChild(), Integer.MIN_VALUE),
		    findDiff(root, root.getRightChild(), Integer.MIN_VALUE));
		int max1 = maxDiff(root.getLeftChild());
		int max2 = maxDiff(root.getRightChild());
		if (max1 > max) {
		    max = max1;
		}
		if (max2 > max) {
		    max = max2;
		}
		return max;
	}
	
	int findDiff(Node ref, Node node, int max) {
	    if (node == null) {
	        return max;
	    }
	    int diff = ref.getData() - node.getData();
	    if (diff > max) {
	        max = diff;
	    }
	    return java.lang.Math.max(findDiff(ref, node.getLeftChild(), max), 
	        findDiff(ref, node.getRightChild(), max));
	}
	
	public static void main(String[] args) {
		// refer to ExtremeNodesInAlternateOrder.png for input tree
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node18 = new Node(18);
		Node node19 = new Node(19);
		Node node20 = new Node(20);
		Node node21 = new Node(21);
		Node node22 = new Node(22);
		Node node23 = new Node(23);
		Node node24 = new Node(24);
		Node node25 = new Node(25);
		Node node26 = new Node(26);
		Node node27 = new Node(27);
		Node node28 = new Node(28);
		Node node29 = new Node(29);
		Node node30 = new Node(30);
		Node node31 = new Node(31);
		root.setLeftChild(node2);
		root.setRightChild(node3);
		node2.setLeftChild(node4);
		node2.setRightChild(node5);
		node3.setLeftChild(node6);
		node3.setRightChild(node7);
		node4.setLeftChild(node8);
		node4.setRightChild(node9);
		node5.setLeftChild(node10);
		node5.setRightChild(node11);
		node6.setLeftChild(node12);
		node6.setRightChild(node13);
		node7.setLeftChild(node14);
		node7.setRightChild(node15);
		node8.setLeftChild(node16);
		node8.setRightChild(node17);
		node9.setLeftChild(node18);
		node9.setRightChild(node19);
		node10.setLeftChild(node20);
		node10.setRightChild(node21);
		node11.setLeftChild(node22);
		node11.setRightChild(node23);
		node12.setLeftChild(node24);
		node12.setRightChild(node25);
		node13.setLeftChild(node26);
		node13.setRightChild(node27);
		node14.setLeftChild(node28);
		node14.setRightChild(node29);
		node15.setLeftChild(node30);
		node15.setRightChild(node31);
		MaxDiffBetNodeAndAncestor m = new MaxDiffBetNodeAndAncestor();
		System.out.println(m.maxDiff(root));
	}
}
