package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;
/*
 * Given a Binary Tree, find diameter of it.  The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. 
 * The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded 
 * (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 * Refer to image tree_diameter.GIF
 */
public class DiameterOfBinaryTree {
	
	/*
	 * ALGO: The diameter of a binary tree is the max(diameter of left subtree of curr node, diameter of right subtree of current node, 
	 * max number of nodes passing through the current node)
	 * The maximum number of nodes passing through the node is the height of the left subtree of node + height of right subtree of node + 1
	 */
	int diameter(MyNode node)
    {
        // Your code here
        if (node == null) {
            return 0;
        }
        int dmax = 0;
        int dleft = diameter(node.getLeftChild());
        int dcurr = getDiameter(node);
        int dright = diameter(node.getRightChild());
        if (dleft > dcurr) {
            dmax = dleft;
        } else {
            dmax = dcurr;
        }
        if (dmax > dright) {
            return dmax;
        } else {
            return dright;
        }
    }
    
    int getDiameter(MyNode node) {
        return 1 + height(node.getLeftChild()) + height(node.getRightChild());
    }
    
    int height (MyNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + java.lang.Math.max(height(node.getLeftChild()), height(node.getRightChild()));
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
	
	DiameterOfBinaryTree l = new DiameterOfBinaryTree();
	System.out.println(l.diameter(root));
	}

}
