package com.dsa.trees.binary;

import java.util.LinkedList;
import java.util.Queue;

import com.dsa.gayle.laakmann.chapter4.questions.MyBinaryTree;
import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

/*
 * This class does level order traversal for a BST.
 */
public class LevelOrderTraversal {
	
	private int height(MyNode node) {
		if (node  == null) return 0;
		return Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
	}
	
	/*
	 * Print nodes at a particular level
	 */
	private void traverseLevel(MyNode node, int level) {
		if (node == null) return;		
		if (level == 1) {
			System.out.print(node.getValue() + ", ");
			return;
		}
		traverseLevel(node.getLeftChild(), level-1);		
		traverseLevel(node.getRightChild(), level-1);
	}
	
	private void traverseAtLevels(MyNode root) {
		if (root == null) return;
		int h = height(root);
		for (int i=1;i<=h;i++) {
			System.out.println();
			traverseLevel(root, i);
		}
	}
	
	/*
	 * Level order traversal of BST using a queue. This is similar to breadth first 
	 * search
	 */
	private void traverse(MyNode node) {
		if (node == null) return;
		Queue<MyNode> queue = new LinkedList<MyNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			MyNode temp = queue.remove();
			System.out.print(temp.getValue() + ", ");
			if (temp.getLeftChild() != null)
				queue.add(temp.getLeftChild());
			if (temp.getRightChild() != null)
				queue.add(temp.getRightChild());
		}
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
		
		LevelOrderTraversal p = new LevelOrderTraversal();
		p.traverse(tree.getRoot());
		System.out.println();
		System.out.println(p.height(tree.getRoot()));
		System.out.println();
		p.traverseLevel(tree.getRoot(), 3);
		System.out.println();
		p.traverseAtLevels(tree.getRoot());
	}

}
