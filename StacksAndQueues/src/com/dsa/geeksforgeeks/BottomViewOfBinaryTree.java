package com.dsa.geeksforgeeks;

import java.util.Map;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

/*
 * Given a Binary Tree,  print the bottom view from left to right. A node x is there in output if x 
 * is the bottommost node at its horizontal distance from root. Horizontal distance of left child of 
 * a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

Examples:

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree the output should be 5, 10, 3, 14, 25.

If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. 
For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5, 10, 4, 14, 25.

Input:
The task is to complete the method which takes one argument, root of Binary Tree. The struct Node has a data part which stores the data, 
pointer to left child and pointer to right child.
There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should print nodes in bottom view of Binary Tree.  Your code should not print a newline, 
it is added by the caller code that runs your function.

Constraints:
1 <=T<= 30
0 <= Number of nodes<= 100
0 <= Data of a node<= 1000

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
3 1 2
40 20 60 30

There are two test casess.  First case represents a tree with 3 nodes and 2 edges where root is 1, 
left child of 1 is 3 and right child of 1 is 2.   Second test case represents a tree with 4 edges and 5 nodes.
 */
public class BottomViewOfBinaryTree {
	
	public void bottomView(MyNode root)
    {
        // Your code here
        if (root == null)
            return;
        java.util.Map<Integer, Integer> m = new java.util.TreeMap<Integer, Integer>();
        view(root, 0, m);
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        
    }
    
    private void view(MyNode node, int hd, java.util.Map<Integer, Integer> m) {
        if (node == null)
            return;
        m.put(hd, node.getValue());
        view(node.getLeftChild(), hd-1, m);
        view(node.getRightChild(), hd+1, m);
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
	
	BottomViewOfBinaryTree l = new BottomViewOfBinaryTree();
	l.bottomView(root);
	}
}
