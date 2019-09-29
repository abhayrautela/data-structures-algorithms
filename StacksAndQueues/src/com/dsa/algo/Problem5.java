package com.dsa.algo;

import com.dsa.linklist.Link;
import com.dsa.linklist.LinkList;

/*
 * Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.
 */
public class Problem5 {
	
	public static void main(String[] args) {
		LinkList ll = new LinkList();
		
		ll.insertFirst(1, 0);
		ll.insertFirst(10, 0);
		ll.insertFirst(4, 0);
		ll.insertFirst(9, 0);
		ll.insertFirst(5, 0);
		ll.insertFirst(3, 0);
		ll.insertFirst(1, 0);
		ll.insertFirst(9, 0);
		ll.displayLinks();
		linkdelete(ll.getFirst(), 2, 1);
		System.out.println("After delete...");
		ll.displayLinks();
	}
	
	private static void linkdelete(Link head,int m,int n)
	{//1 2 3 4 5 6 7 8
	//1 2 5 6 7 8`
	//1 2 5 6 
	// Add code here    9 1 3 5 9 4 10 1 
	    if (head == null || n==0) return;
	    Link prev = null, curr = head;
	    int m1 = m, n1 = n;
	    while(curr != null) {
	        if (m1-- == 0) {
	            while (n1-- > 0 && curr != null) {
	                curr = curr.getNext();
	            }
	            if (prev == null) {
	                head = curr;
                } else {
                    prev.setNext(curr);
                }
	            
	            m1=m; n1=n;
	        } else {
	        prev = curr; curr = curr.getNext();
	        }
	    }
	}

}
