package com.dsa.gayle.laakmann.chapter4.questions;

/*
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
public class Problem3 {
	
	private static int[] arr = {1,2,3,4,5,6,7,8,9};
	
	public MyNode execute(int leftEnd, int rootNodeIdx, int rightEnd) {
		MyNode node = new MyNode(arr[rootNodeIdx]);
		if (leftEnd < rightEnd) {
			node.setLeftChild(execute(leftEnd, (leftEnd + rootNodeIdx)/2, rootNodeIdx-1));
			node.setRightChild(execute(rootNodeIdx+1, (rootNodeIdx + rightEnd)/2, rightEnd));
		}					
		return node;
	}
	
	public static void main(String[] args) {
		Problem3 p = new Problem3();
		MyNode node = p.execute(0, 4, arr.length-1);
		System.out.println("Done");
	}

}
