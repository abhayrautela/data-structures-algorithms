package com.dsa.geeksforgeeks;

import com.dsa.trees.binary.Node;

/*
 * Given a Binary Tree having random pointers clone the Binary Tree. The task is to complete the function cloneTree 
 * which take one argument the root of the tree to be copied and should return the root of the cloned tree.
 * 
 * Input:
 * The first line of input contains the no of test cases. Then T test cases follow. 
 * Each test case contains 2 lines the first line contains and integer N denoting the no of edges of the tree 
 * and then in the next line are N space separated queries .The query on tree are of three types
 * a) a b L  (Represents that b is the left child of a)
 * b) a b R (Represents that b is the right child of a)
 * c) a b X (Represents a random pointer from node a to node b)  
 * 
 * Output:
 * Your function should return the root of the cloned tree. The output will be 1 if the tree is successfully cloned.
 * 
 * Constraints:
 * 1 <=T<= 30
 * 1 <=Number of nodes<= 100
 * 1 <=Data of a node<= 1000
 * 
 * Example(To be used only for expected output):
 * Input
 * 1
 * 6
 * 6 3 L 6 8 R 3 1 L 3 5 R 1 3 X 5 6 X
 * 
 * Output
 * 1
 */
public class CloneBinaryTree {
	
	Node cloneTree(Node node, Node parent, boolean isLeft) {
		Node newNode = null;
		if (node != null) {
			newNode = new Node(node.getData());
			if (parent != null) {
				if (isLeft) {
					parent.setLeftChild(newNode);
				} else {
					parent.setRightChild(newNode);
				}
			}			
			cloneTree(node.getLeftChild(), newNode, true);
			cloneTree(node.getRightChild(), newNode, false);
			newNode.setRandom(node);
			node.setLeftChild(newNode);
		}
		return  newNode;
	}
	
	void cloneRandom(Node node) {
		if (node != null) {
			Node origNode = node.getRandom();
			if (origNode != null) {
				Node origRandom = origNode.getRandom();
				if (origRandom != null) {
					node.setRandom(origRandom.getLeftChild());
				} else {
					node.setRandom(null);
				}
			}
			cloneRandom(node.getLeftChild());
			cloneRandom(node.getRightChild());
		}
	}
	
	public static void main(String[] args) {
		CloneBinaryTree clone = new CloneBinaryTree();
		Node root = new Node(6);
		
		Node node1 = new Node(3);
		Node node2 = new Node(8);
		root.setLeftChild(node1);
		root.setRightChild(node2);
		
		Node node3 = new Node(1);
		Node node4 = new Node(5);
		node1.setLeftChild(node3);
		node1.setRightChild(node4);
		
		node3.setRandom(node1);
		node4.setRandom(root);
		
		Node rootClone = clone.cloneTree(root, null, true);
		clone.cloneRandom(rootClone);
		System.out.println(rootClone);
	}

}
