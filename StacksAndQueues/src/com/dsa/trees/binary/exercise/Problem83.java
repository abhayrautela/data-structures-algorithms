package com.dsa.trees.binary.exercise;

import com.dsa.trees.binary.Node;

public class Problem83 {
	
	private static String s = "ABCDEFGHIJ";
	
	public static void main(String[] args) {
		int i = 1;
		Node root = new Node(s.substring(i-1, i));
		create(root, i);
		inorder(root);
	}
	
	public static void inorder(Node localNode) {
		if (localNode != null) {
			inorder(localNode.getLeftChild());
			System.out.println(localNode.getsData());
			inorder(localNode.getRightChild());
		}
	}
	
	public static void create(Node node, int i) {		
		int lcIndex = 2*i;
		int rcIndex = 2*i+1;		
		if (lcIndex < s.length()+1) {
			Node lc = new Node(s.substring(lcIndex-1, lcIndex));
			node.setLeftChild(lc);
			create(lc, lcIndex);
		}
		if (rcIndex < s.length()+1) {
			Node rc = new Node(s.substring(rcIndex-1, rcIndex));		
			node.setRightChild(rc);
			create(rc, rcIndex);
		}		
	}

}
