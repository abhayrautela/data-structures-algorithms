package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

public class CheckForBST {
	
	boolean isBST(MyNode node, MyNode prev, boolean isLeft) {
		if (node == null)
			return true;
		return isBST(node.getLeftChild(), node, true) && ((prev == null) || 
				((isLeft) && (node.getValue() < prev.getValue())) || ((!isLeft) && (node.getValue() > prev.getValue()))) && isBST(node.getRightChild(), node, false);
	}
	
	boolean compare(MyNode node, MyNode target, boolean isLeft) {
		if (target == null)
			return true;
		if ((isLeft && node.getValue() < target.getValue()) || (!isLeft && node.getValue() > target.getValue()))
			return false;
		return compare(node, target.getLeftChild(), isLeft) && compare(node, target.getRightChild(), isLeft); 
	}
	
	boolean isBST(MyNode node) {
		if (node == null)
			return true;
		return compare(node, node.getLeftChild(), true) && compare(node, node.getRightChild(), false) 
				&& isBST(node.getLeftChild()) && isBST(node.getRightChild()); 
	}
	
	public static void main(String[] args) {
		/*
			5
		4		6
	2				9
				7		10
				*/
		MyNode root = new MyNode(5);
		root.setLeftChild(new MyNode(4));
		root.getLeftChild().setLeftChild(new MyNode(2));
		root.setRightChild(new MyNode(6));
		root.getRightChild().setRightChild(new MyNode(9));
		root.getRightChild().getRightChild().setLeftChild(new MyNode(7));
		root.getRightChild().getRightChild().setRightChild(new MyNode(10));
		
		CheckForBST b = new CheckForBST();
		System.out.println(b.isBST(root, null, true));
		System.out.println(b.isBST(root));
	}

}
