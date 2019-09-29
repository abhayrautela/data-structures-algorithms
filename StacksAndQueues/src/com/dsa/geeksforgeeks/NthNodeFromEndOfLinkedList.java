package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;

/*
 * Given a linked list, the task is to find the n'th node from the end.  
 * It is needed to complete a method that takes two argument, head of linked list and an integer n. 
 * There are multiple test cases. For each test case, this method will be called individually.
 */
public class NthNodeFromEndOfLinkedList {
	int getNthFromLast(Link head, int n) {
        java.util.List<Integer> list = new java.util.ArrayList<Integer>();
        int totalNumElements = doIt(head, n, list);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return -1;
        }
    }
    int doIt(Link head, int n, java.util.List<Integer> list)
    {
	// Your code here	
	    if (head == null) {
	        return 1;
	    }
	    int x= doIt(head.getNext(), n, list);
	    if (x == n) {
	        list.add(head.getIData());
	    }
	    return x+1;
    }
    
    public static void main(String[] args) {
		Link head = new Link(1, 0);
		Link l2 = new Link(2, 0); head.setNext(l2);
		Link l3 = new Link(3, 0); l2.setNext(l3);
		Link l4 = new Link(4, 0); l3.setNext(l4);
		Link l5 = new Link(5, 0); l4.setNext(l5);
		NthNodeFromEndOfLinkedList n = new NthNodeFromEndOfLinkedList();
		System.out.println(n.getNthFromLast(head, 3));
	}
}
