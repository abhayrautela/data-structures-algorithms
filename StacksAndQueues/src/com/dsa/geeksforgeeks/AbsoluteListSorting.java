package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;

/*
 * Given a linked list L of N nodes, sorted in ascending order based on the absolute values of its data. 
 * Sort the linked list according to the actual values.
 * Ex: Input : 1 -> -2 -> -3 -> 4 -> -5 
 * 	   Output: -5 -> -3 -> -2 -> 1 -> 4
 * 
 * Input
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
 * Each test case consists of two lines. The first line of each test case contains a positive integer N denoting the size of linked list. 
 * The second line of each test case contains N space separated integers denoting the values of N nodes.
 * 
 * 
 * Output
 * Corresponding to each test case, print out the sorted linked list.
 * 
 * Constraints
 * 1 <= T <= 100
 * 0 <   N  <= 30
 * -100 <= L[i] <= 100
 */
public class AbsoluteListSorting {
	
	public static void main(String[] args) {
		Link head = new Link(-5, 0);
		Link curr = head;
		curr.setNext(new Link(-8, 0)); curr = curr.getNext();
		curr.setNext(new Link(-12, 0)); curr = curr.getNext();
		curr.setNext(new Link(-14, 0)); curr = curr.getNext();
		curr.setNext(new Link(-28, 0)); curr = curr.getNext();
		AbsoluteListSorting a = new AbsoluteListSorting();
		head = a.sortedList(head);
		curr = head;
		while (curr != null) {
			System.out.print(curr.getIData() + " ");
			curr = curr.getNext();
		}
	}
	
	/*
	 * Algo: The link is sorted with absolute value. So numbers >= 0 are in correct position.
	 * And negative numbers will be in reverse order. Hence traverse the link list
	 * and move negative integers to the start of link list.
	 * Time complexity is O(n)
	 */
	Link sortedList(Link head)
	{
		// Your code here
		if (head == null)
		    return null;
		Link curr = head; Link prev = null;
		while (curr != null) {
		    if (curr.getIData() < 0 && prev != null) {
		        prev.setNext(curr.getNext());
		        curr.setNext(head);
		        head = curr;
		        curr = prev;
		    }
		    prev = curr;
		    curr = curr.getNext();
		}
		return head;
	}

}
