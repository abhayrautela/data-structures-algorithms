package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

public class KDistanceFromRoot {
	
	void printKdistance(MyNode root, int k)
    {
         // Your code here
         if (root == null)
           return;
       if (k==0)
           System.out.print(root.getValue() + " ");
       printKdistance(root.getLeftChild(), k-1);
       printKdistance(root.getRightChild(), k-1);
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
	
	KDistanceFromRoot k = new KDistanceFromRoot();
	k.printKdistance(root, 2);
	}

}
