package com.dsa.geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.linklist.Link;
import com.dsa.trees.binary.Node;

/*
 * Given Linked List Representation of Complete Binary Tree, construct the Binary tree.Your task is to complete the function convert 
 * which takes two arguments the first being the head denoting the head of the linked list and the second argument is root denoting 
 * the root of the tree to be constructed.
 * 
 * Note : The complete binary tree is represented as an linked list in a way where If root node is stored at position i, its left, 
 * and right children are stored at position 2*i+1, 2*i+2 respectively.
 */
public class MakeBinaryTree {
	
	Node createTree(Link l) {
		if (l == null)
			return null;
		Queue<Node> q = new LinkedList<Node>();
		Node root = new Node(l.getIData());
		q.add(root);
		while(l != null) {
			Node node = q.remove();
			Link left = l.getNext();
			Link right = (left != null)? left.getNext() : null;
			if (left != null)
				node.setLeftChild(new Node(left.getIData()));
			if (right != null)
				node.setRightChild(new Node(right.getIData()));
			q.add(node.getLeftChild());
			q.add(node.getRightChild());
			l = right;
		}
		return root;
	}
	
	public static void main(String[] args) {
		Link first = new Link(10, 0);
		Link l = first;
		l.setNext(new Link(12, 0));
		l = l.getNext();
		l.setNext(new Link(15, 0));
		l = l.getNext();
		l.setNext(new Link(25, 0));
		l = l.getNext();
		l.setNext(new Link(30, 0));
		l = l.getNext();
		l.setNext(new Link(36, 0));
		l = l.getNext();
		MakeBinaryTree t = new MakeBinaryTree();
		Node root = t.createTree(first);
		System.out.println("Done");
	}

}
