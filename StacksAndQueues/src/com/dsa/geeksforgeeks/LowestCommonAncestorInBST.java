package com.dsa.geeksforgeeks;

import com.dsa.trees.binary.Node;

/*
 * Given a Binary Search Tree and 2 nodes value n1 and n2  , your task is to find the lowest common ancestor of the two nodes . 
 * You are required to complete the function LCA . You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.
 * 
 * Input:
 * The task is to complete the method LCA which takes 3 arguments, root of the Tree and two nodes value  n1 and n2 . 
 * The struct node has a data part which stores the data, pointer to left child and pointer to right child.
 * There are multiple test cases. For each test case, this method will be called individually.
 * 
 * Output:
 * The function should return the node which is the least common ancestor of the two nodes n1 and n2 .
 * 
 * Constraints:
 * 1 <=T<= 100
 * 1 <=Number of nodes<= 100
 * 1 <=Data of a node<= 1000
 * 
 * Example:
 * 
 * Input
 * 1
 * 6
 * 5 4 6 3 7 8
 * 7 8
 * 
 * Output 
 * 7
 * 
 * Explanation 
 * The BST in above test case will look like
 * 
 *        5
 *      /  \ 
 *      4  6
 *    /      \
 *   3        7
 *            \ 
 *             8
 * here the LCA of 7 and 8 is 7 .
 */
public class LowestCommonAncestorInBST {
	Node lca(Node node, int n1, int n2) 
    {
        // Your code here
        if (node == null) {
            return null;
        }
        
        while (node != null) {
            if (node.getData() == n1 || node.getData() == n2) {
                return node;
            }
            if ((node.getData() > n1 && node.getData() < n2) || 
                (node.getData() > n2 && node.getData() < n1)) {
                    return node;
            }
            if (node.getData() > n1 && node.getData() > n2) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            } 
        }
        return null;
    }
	
	public static void main(String[] args) {
		LowestCommonAncestorInBST l = new LowestCommonAncestorInBST();
		Node root = new Node(5);
		Node n1 = new Node(4);root.setLeftChild(n1);
		Node n2 = new Node(3);n1.setLeftChild(n2);
		Node n3 = new Node(6);root.setRightChild(n3);
		Node n4 = new Node(7);n3.setRightChild(n4);
		Node n5 = new Node(8);n4.setRightChild(n5);
		
		System.out.println(l.lca(root, 7, 8).getData());
	}
}
