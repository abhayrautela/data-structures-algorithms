package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

/*
 * Given a binary tree, find if it is height balanced or not.  
 * A tree is heigh balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 
 */
public class CheckForBalancedTree {
	
	/*
	 * Algo: Check if the height of left and right subtree differs by not more than 1. Recursively check this condition
	 * for left and right subtree.
	 * This algo executes in O(N^2)
	 */
	boolean isBalanced(MyNode root)
    {
	// Your code here
	if (root == null) {
	    return true;
	}
	return isBalanced(root.getLeftChild()) && isBalanced(root.getRightChild())
	&& isBalanceCheck(root);
    }
    
    boolean isBalanceCheck(MyNode node) {
        if (node == null) {
            return true;
        }
        int lh = height(node.getLeftChild());
        int rh = height(node.getRightChild());
        return (java.lang.Math.abs(lh-rh)) > 1? false : true;
    }
    
    /*
     * Algo: Return the height if the subtree is balanced, else return -1.
     * This method executes in O(N)
     */
    int checkIsBalanced(MyNode node) {
        if (node == null) {
            return 0;
        }
        int lh = checkIsBalanced(node.getLeftChild());
        int rh = checkIsBalanced(node.getRightChild());
        if (lh == -1 || rh == -1 || java.lang.Math.abs(lh-rh) > 1) {
        	return -1;
        } else {
        	return 1 + java.lang.Math.max(lh, rh);
        }        
    }
    
    int height(MyNode node) {
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
	
	CheckForBalancedTree l = new CheckForBalancedTree();
	System.out.println(l.isBalanced(root) ? "Balanced" : "Not balanced");
	System.out.println(l.checkIsBalanced(root) == -1 ? "Not balanced" : "Balanced");
	}
}
