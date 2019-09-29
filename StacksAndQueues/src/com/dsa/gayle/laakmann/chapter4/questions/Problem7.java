package com.dsa.gayle.laakmann.chapter4.questions;

/*
 * Design an algorithm and write code to find the first common ancestor of two nodes
 * in a binary tree. Avoid storing additional nodes in a data structure. Design for 
 * scenarios where the BT is a BST or not necessarily a BST.
 */
public class Problem7 {
	
	/* Algo:
	 * Start from root and based on current node being both less than or 
	 * both greater than current node, keep moving to left or right subtree.
	 * As soon as current node is such that node1 and node2 are on either side subtree,
	 * we have found common ancestor.
	 */
	public MyNode findForBST(MyNode root, int x, int y) {
		MyNode curr = root;
		if (curr != null) {
			while (curr != null) {
				if (curr.getValue() > x && curr.getValue() > y) {
					curr = curr.getLeftChild();
				} else if (curr.getValue() < x && curr.getValue() < y) {
					curr = curr.getRightChild();
				} else {
					return curr;
				}
			}
			return null;
		} else 
			return null;
	}
	
	/*
	 * This method finds the first common ancestor of two nodes x,y when the tree is not a BST.
	 * Check if x and y fall under same side(left or right) of the root node. If not , then root node is the first common ancestor.
	 * If yes, then call recursive passing either root left child (if x,y fall on left side of root node) or
	 * root right child(if x,y fall on left side of root node)
	 */
	public MyNode findForNonBST(MyNode root, int x, int y) {
		boolean isXleftOfRoot = isDescendent(root.getLeftChild(), x);
		boolean isYleftOfRoot = isDescendent(root.getLeftChild(), y);
		if (isXleftOfRoot ^ isYleftOfRoot) {
			return root;
		}
		MyNode node = isXleftOfRoot ? root.getLeftChild() : root.getRightChild();
		return findForNonBST(node, x, y);
	}
	
	/*
	 * This method finds if the node is a descendent of root node. It traverses both left and right subtree of each node of tree.
	 * And checks of the current node is same as target node.
	 */
	public boolean isDescendent(MyNode root, int value) {
		if (root == null)
			return false;
		if (root.getValue() == value) {
			return true;
		}
		return isDescendent(root.getLeftChild(), value) || isDescendent(root.getRightChild(), value);
	}
	
	public static void main(String[] args) {
				/*
				5
			4		6
		2				9
					7		10
					*/
		MyBinaryTree tree = new MyBinaryTree();
		tree.insertWithParentRef(5);
		tree.insertWithParentRef(4);
		tree.insertWithParentRef(6);
		tree.insertWithParentRef(2);
		tree.insertWithParentRef(9);
		tree.insertWithParentRef(10);
		tree.insertWithParentRef(7);
		
		Problem7 p = new Problem7();		
		System.out.println(p.findForBST(tree.getRoot(), 2, 10));
		
		System.out.println(p.isDescendent(tree.getRoot(), 10));
		
		System.out.println(p.findForNonBST(tree.getRoot(), 2, 10));
	}

}
