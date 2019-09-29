package com.dsa.geeksforgeeks;

import java.util.Map;
import java.util.TreeMap;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

public class RightViewOfBinaryTree {
	
	void rightView(MyNode node) {
		if (node == null) {
            return;
        }
        java.util.Queue<MyNode> q = new java.util.LinkedList<MyNode>();
        q.add(node);
        int count = q.size();
        while (!q.isEmpty()) {
            MyNode temp = q.remove();
            if (temp != null) {
            	if (count == 1)
            		System.out.print(temp.getValue() + " ");
                if (temp.getLeftChild() != null)
                    q.add(temp.getLeftChild());
                if (temp.getRightChild() != null)
                    q.add(temp.getRightChild());
                count--;
                if (count == 0) {                       
                    count = q.size();
                }
            }
        }
	}
	
	void rightViewAlternate(MyNode node) {
		if (node == null)
			return;
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
		view(node, 0, m);
		if (m != null && m.size() > 0) {
			for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
				System.out.print(entry.getValue() + " ");
			}
		}
	}
	
	void view (MyNode node, int h, Map<Integer, Integer> m) {
		if (node == null)
			return;
		m.put(h, node.getValue());
		view(node.getLeftChild(), h+1, m);
		view(node.getRightChild(), h+1, m);
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
	
	RightViewOfBinaryTree l = new RightViewOfBinaryTree();
	l.rightView(root);
	l.rightViewAlternate(root);
	}
}
