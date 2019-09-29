package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;

public class FindMiddleElementInLinkedList {
	
	int getMiddle(Link head)
	   {
	         // Your code here.
	         if (head == null) {
	             return -1;
	         }
	         Link node = head;
	         int size = 0;
	         while (node != null) {
	             size++;
	             node = node.getNext();
	         }
	         int count = size/2;
	         node = head;
	         while (count > 0) {
	             node = node.getNext();
	             count--;
	         }
	         return node.getIData();
	   }
	
	public static void main(String[] args) {
		Link head = new Link(1, 0);
		Link l2 = new Link(2, 0); head.setNext(l2);
		Link l3 = new Link(3, 0); l2.setNext(l3);
		Link l4 = new Link(4, 0); l3.setNext(l4);
		Link l5 = new Link(5, 0); l4.setNext(l5);
		FindMiddleElementInLinkedList n = new FindMiddleElementInLinkedList();
		System.out.println(n.getMiddle(head));
	}
}
