package com.dsa.algo;

import com.dsa.gayle.laakmann.chapter2.questions.GenericLink;
import com.dsa.gayle.laakmann.chapter2.questions.GenericLinkList;
import com.dsa.gayle.laakmann.chapter4.questions.MyNode;
import com.dsa.queue.MyNodeQueue;

public class Problem4 {
	
	public static void main(String[] args) {
		GenericLinkList<Integer> linkList = new GenericLinkList<Integer>();
		linkList.add(new Integer(10));
		linkList.add(new Integer(12));
		linkList.add(new Integer(15));
		linkList.add(new Integer(25));
		linkList.add(new Integer(30));
		linkList.add(new Integer(36));
		MyNode node = createTree(linkList);
		System.out.println(node);
	}
	
	private static MyNode createTree(GenericLinkList<Integer> linkList) {
		GenericLink<Integer> linkHead = linkList.getFirst();
		if (linkHead == null)
			return null;
		MyNodeQueue queue = new MyNodeQueue(linkList.getnCurr());
		GenericLink<Integer> currLink = linkHead;
		MyNode firstNode = new MyNode(currLink.getElement());
		queue.insert(firstNode);
		MyNode node = null;
		MyNode leftChild = null;
		MyNode rightChild = null;
		while (!queue.isEmpty() && currLink != null) {
			GenericLink<Integer> left = currLink.next();
			currLink = currLink.next();
			GenericLink<Integer> right = currLink.next();
			currLink = currLink.next();
			
			
			node = queue.remove();
			if (left != null) {
				leftChild = new MyNode(left.getElement());
				node.setLeftChild(leftChild);
			}
			if (right != null) {
				rightChild = new MyNode(right.getElement());
				node.setRightChild(rightChild);
			}
			queue.insert(leftChild);
			queue.insert(rightChild);			
		}
		return firstNode;
	}
	
}
