package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

public class HeightOfBinaryTree {
	int height(MyNode node) 
    {
         // Your code here
         if (node == null)
            return 0;
        return java.lang.Math.max(height(node.getLeftChild()), height(node.getRightChild()))+1;
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
	
	HeightOfBinaryTree h = new HeightOfBinaryTree();
	System.out.println(h.height(root));;
	}
}
