package com.dsa.gayle.laakmann.chapter4.questions;


/*
 * Determine if a binary tree is a binary search tree
 */
public class Problem11 {
	
	private static int[] arr;
	private static int index = 0;
	private static MyNode root;
	
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
		
		arr = new int[50];
		Problem11 prob = new Problem11();
		prob.serialize(tree.getRoot(), 0);
		for (int i : arr) {
			if (i != 0) {
				System.out.println(i + " , ");
			}								
		}
		root = new MyNode(arr[0]);
		prob.deserialize(root, 0);
		System.out.println("Done");
	}

	private void deserialize(MyNode node, int index) {		
		int leftChildIndex = 2*index + 1;
		int rightChildIndex = leftChildIndex + 1;
		if (node.getValue() == -1) {
			return;
		}
		node.setLeftChild(new MyNode(arr[leftChildIndex]));
		node.setRightChild(new MyNode(arr[rightChildIndex]));		
		deserialize(node.getLeftChild(), leftChildIndex);
		deserialize(node.getRightChild(), rightChildIndex);
	}

	private void serialize(MyNode root, int index) {
		if (root == null) {
			arr[index] = -1;
		} else {
			arr[index] = root.getValue();
			int leftChildIndex = 2*index + 1;
			int rightChildIndex = leftChildIndex + 1;
			serialize(root.getLeftChild(), leftChildIndex);
			serialize(root.getRightChild(), rightChildIndex);
		}		
	}
}
