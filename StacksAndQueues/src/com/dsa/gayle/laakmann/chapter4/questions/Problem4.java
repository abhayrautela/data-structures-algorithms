package com.dsa.gayle.laakmann.chapter4.questions;

import java.util.ArrayList;
import java.util.List;

import com.dsa.gayle.laakmann.chapter2.questions.GenericLink;
import com.dsa.gayle.laakmann.chapter2.questions.GenericLinkList;

/*
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class Problem4 {
	
	private List<GenericLinkList<MyNode>> listArr;
	private MyBinaryTree tree;
	
	public Problem4() {
			/*
			5
		4		6
	2				9
				7		10
				*/
	tree = new MyBinaryTree();
	tree.insert(5);
	tree.insert(4);
	tree.insert(6);
	tree.insert(2);
	tree.insert(9);
	tree.insert(10);
	tree.insert(7);
	listArr = new ArrayList<GenericLinkList<MyNode>>();
	}
	
	/*
	 * Using recursion. Preorder, inorder, or postorder can be used
	 */
	public void preorder(MyNode node, int depth) {
		if (node != null) {
			if (listArr.size() <= depth) {
				listArr.add(depth, new GenericLinkList<MyNode>());
			}
			listArr.get(depth).add(node);
			depth++;
			preorder(node.getLeftChild(), depth);
			preorder(node.getRightChild(), depth);
		}		
	}
	
	/*
	 * Using iteration.
	 */
	public void alternateSolution(MyNode node) {
		GenericLinkList<MyNode> current = new GenericLinkList<MyNode>();
		current.add(node);
		while (current != null && !current.isEmpty()) {
			listArr.add(current);
			GenericLinkList<MyNode> parents = current;
			current = new GenericLinkList<MyNode>();
			GenericLink<MyNode> currParentNode = parents.getFirst();
			while (currParentNode != null) {
				if (currParentNode.getElement().getLeftChild() != null) {
					current.add(currParentNode.getElement().getLeftChild());
				}
				if (currParentNode.getElement().getRightChild() != null) {
					current.add(currParentNode.getElement().getRightChild());
				}
				currParentNode = currParentNode.next();
			}
		}		
	}
	
	public void display() {
		int depth = 0;
		for (GenericLinkList<MyNode> ll : listArr) {
			System.out.println("\nDisplaying link list at depth " + depth++);			
			ll.display();
		}
	}
	
	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(2);
		tree.insert(9);
		tree.insert(10);
		tree.insert(7);
		Problem4 p = new Problem4();
		//p.preorder(tree.getRoot(), 0);
		//p.display();
		p.alternateSolution(tree.getRoot());
		p.display();		
		System.out.println("Done");
	}

}
