package com.dsa.trees.binary.exercise;

import com.dsa.trees.binary.Node;

public class Problem81 {
	
	public void createTree(String s) {
		Node[] arr = new Node[s.length()]; 
		for (int i=0; i<s.length(); i++) {
			String c = s.substring(i, i+1);
			Node n = new Node(c);
			arr[i] = n;
		}
		for (int i=0; i<arr.length-1; i++) {
			Node nOp = new Node("+");
			nOp.setLeftChild(arr[i]);
			nOp.setRightChild(arr[i+1]);
			arr[i+1] = nOp;
		}
		inorder(arr[s.length()-1]);
	}
	
	public void inorder(Node node) {
		if (node != null) {
			inorder(node.getLeftChild());
			System.out.println(node.getsData());
			inorder(node.getRightChild());
		}
	}
	
	public static void main(String[] args) {
		String s = "ABCDE";
		Problem81 prob = new Problem81();
		prob.createTree(s);
	}

}
