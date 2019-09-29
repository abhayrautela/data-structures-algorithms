package com.dsa.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.trees.binary.Node;

/*
 * Given a binary tree, print nodes of extreme corners of each level but in alternate order.
 * For tree in ExtremeNodesInAlternateOrder.png, the output is
 * 1 2 7 8 31.
 */
public class ExtremeNodesInAlternateOrder {
	
	void printExtremeNodeinAlternateOrder(Node node) {
		Node curr = node;
		int h = height(curr);
		Queue<Node> queue = new LinkedList<Node>();
		boolean flag = false;
		for (int i=1; i<=h;i++) {
			curr = node;
			enqueGivenLevel(queue, curr, i, 1);
			Node temp = null;
			while (!queue.isEmpty()) {
				temp = queue.remove();
				if (flag) 
					break;
			}
			queue.clear();
			flag = !flag;
			System.out.print(temp.getData() + " ");
		}
	}
	
	void levelOrderTraversal(Node node) {
		Node curr = node;
		int h = height(curr);
		for (int i=1; i<=h;i++) {
			curr = node;
			printGivenLevel(curr, i, 1);
			System.out.println();
		}
	}
	
	void enqueGivenLevel(Queue<Node> queue, Node node, int level, int currLevel) {
		if (node != null) {
			if (level == currLevel) 
				queue.add(node);
			enqueGivenLevel(queue, node.getLeftChild(), level, currLevel+1);
			enqueGivenLevel(queue, node.getRightChild(), level, currLevel+1);
		}		
	}
	
	void printGivenLevel(Node node, int level, int currLevel) {
		if (node != null) {
			if (level == currLevel) 
				System.out.print(node.getData() + " ");
			printGivenLevel(node.getLeftChild(), level, currLevel+1);
			printGivenLevel(node.getRightChild(), level, currLevel+1);
		}		
	}
	
	int height(Node node) {
		if (node == null)
			return 0;
		return Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
	}
	
	/*
	 * This method works only for complete tree.
	 */
	void print(Node node) {
		if (node == null) return;
		System.out.print(node.getData() + " ");
		Node left = node;
		Node right = node;
		boolean isLeft = true;
		while (left != null && right != null) {
			if (left.getLeftChild() != null)
				left = left.getLeftChild();
			else if (left.getRightChild() != null)
				left = left.getRightChild();
			else break;
			
			if (right.getRightChild() != null)
				right = right.getRightChild();
			else if (right.getLeftChild() != null)
				right = right.getLeftChild();
			else break;
			
			if (isLeft) {
				System.out.print(left.getData() + " ");
				isLeft = false;
			} else {
				System.out.print(right.getData() + " ");
				isLeft = true;
			}
		}
	}
	
	public static void main(String[] args) {
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
		ExtremeNodesInAlternateOrder e = new ExtremeNodesInAlternateOrder();
		e.print(root);
		System.out.println();
		System.out.println("Height of tree : " + e.height(root));
		System.out.println();
		e.levelOrderTraversal(root);
		System.out.println();
		e.printExtremeNodeinAlternateOrder(root);
	}

}
