package com.dsa.gayle.laakmann.chapter4.questions;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a Binary Tree having random pointers clone the Binary Tree. The task is to complete the function cloneTree which take one argument the root of the tree to be copied and should return the root of the cloned tree.

Input:
The first line of input contains the no of test cases. Then T test cases follow. Each test case contains 2 lines the first line contains and integer N denoting the no of edges of the tree and then in the next line are N space separated queries .The query on tree are of three types
a) a b L  (Represents that b is the left child of a)
b) a b R (Represents that b is the right child of a)
c) a b X (Represents a random pointer from node a to node b)  

Output:
Your function should return the root of the cloned tree. The output will be 1 if the tree is successfully cloned.
 */
public class Problem12 {
	
	public static void main(String[] args) {
		/*
			5
		4		6
	2				9
				7		10
				*/
		MyBinaryTree tree = new MyBinaryTree();
		MyNode node1 = tree.insert(5);
		tree.insert(4);
		MyNode node3 = tree.insert(6);
		tree.insert(2);
		MyNode node2 = tree.insert(9);
		tree.insert(10);
		MyNode node4 = tree.insert(7);
		node3.setRandom(node4);
		node1.setRandom(node2);
		
		MyNode clone = clone(tree.getRoot());
		cloneRandom(clone, tree.getRoot());
		System.out.println("Done");
	}
	
	private static void cloneRandom(MyNode node, MyNode originalNode) {
		if (node != null) {
			node.setRandom(cloneMap.get(originalNode.getRandom()));
			cloneRandom(node.getLeftChild(), originalNode.getLeftChild());
			cloneRandom(node.getRightChild(), originalNode.getRightChild());
		}
	}
	
	private static Map<MyNode, MyNode> cloneMap = new HashMap<MyNode, MyNode>();
	
	private static MyNode clone(MyNode node) {
		if (node != null) {
			MyNode newNode = new MyNode(node.getValue());
			cloneMap.put(node, newNode);
			newNode.setLeftChild(clone(node.getLeftChild()));
			newNode.setRightChild(clone(node.getRightChild()));
			return newNode;
		}
		return null;
	}

}
