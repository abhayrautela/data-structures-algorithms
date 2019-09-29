package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

/*
 * Given inorder and postorder traversals of a Binary Tree, construct the tree
 * For example, if given inorder and postorder traversals are {4, 8, 2, 5, 1, 6, 3, 7} and {8, 4, 5, 2, 6, 7, 3, 1}  respectively, 
 * then your function should construct below tree.

          1
       /      \
     2        3
   /    \     /   \
  4     5   6    7
    \
      8

            

* Input:
* The task is to complete the method which takes three arguments, one is an array that has inorder traversal, 
* second is another array that has postorder traversal, third is size of two arrays (You may assume that both arrays are of same size). 
* There are multiple test cases. For each test case, this method will be called individually.
Output:
The function should return root of constructed tree.

Constraints:
1 <=T<= 30
1 <= Size of arrays <= 100
1 <= Values in arrays <= 1000

Example:
Input:
1
8
4 8 2 5 1 6 3 7
8 4 5 2 6 7 3 1
 

Output:
1 2 4 8 5 3 6 7

 

There is one test case.  The first line of input is number of elements in tree. 
Second and third lines are inorder and postorder traversals respectively.  Output is Preorder traversal.
 */
public class TreeFromPostOrderAndInOrder {
	
	public static void main(String[] args) {
		MyNode root = new MyNode(1);
		root.setLeftChild(new MyNode(2));
		root.setRightChild(new MyNode(3));
		root.getLeftChild().setLeftChild(new MyNode(5));
		root.getLeftChild().setRightChild(new MyNode(6));
		root.getRightChild().setLeftChild(new MyNode(7));
		root.getRightChild().setRightChild(new MyNode(8));
		int in[] = {4,3,5,1};
		int post[] = {4,5,3,1};
		TreeFromPostOrderAndInOrder t = new TreeFromPostOrderAndInOrder();
		MyNode node = t.buildTree(in, post, in.length);
		System.out.println(node);
	}
	
	MyNode buildTree(int in[], int post[], int n) {
		// Your code here
		if (in == null && post == null) {
			return null;
		}
		return build(in, post, 0, n - 1, n - 1);
	}

	MyNode build(int[] in, int[] post, int li, int ri, int pi) {
		if (pi<0 || li>ri)
			return null;
		MyNode node = new MyNode(post[pi]);
		if (li == ri) {
			return node;
		}
		int i = index(in, post[pi], li, ri);
		int pleft = pi - (ri - i) - 1;
		int pright = pi - 1;
		node.setLeftChild(build(in, post, li, i - 1, pleft));
		node.setRightChild(build(in, post, i + 1, ri, pright));
		return node;
	}

	int index(int[] arr, int x, int left, int right) {
		for (int i = left; i <= right; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;
	}
}
