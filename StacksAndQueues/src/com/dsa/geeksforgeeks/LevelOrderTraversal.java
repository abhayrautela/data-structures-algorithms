package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

public class LevelOrderTraversal {
	
	void levelOrder(MyNode node) 
    {
        // Your code here
        if (node == null) {
            return;
        }
        java.util.Queue<MyNode> q = new java.util.LinkedList<MyNode>();
        q.add(node);
        int count = q.size();
        while (!q.isEmpty()) {
            MyNode temp = q.remove();
            if (temp != null) {
                System.out.print(temp.getValue() + " ");
                if (temp.getLeftChild() != null)
                    q.add(temp.getLeftChild());
                if (temp.getRightChild() != null)
                    q.add(temp.getRightChild());
                count--;
                if (count == 0) {
                    System.out.print("$ ");   
                    count = q.size();
                }
            }
        }
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
	
	LevelOrderTraversal l = new LevelOrderTraversal();
	l.levelOrder(root);
	}
}
