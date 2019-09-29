package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;

/*
 * There are two singly linked lists in a system. By some programming error the end node of one of the linked list got linked into the second list, 
 * forming a inverted Y shaped list. Write a program to get the point where two linked lists merge.
 * refer Y-ShapedLinked-List.gif
 */
public class IntersectionPointInYShapedLinkedList {
	
	/*
	 * Refer the fig Y-ShapedLinked-List.gif. Make one of the linked list a circular linkd list. Then find the point of loop in a circular linked list.
	 * Before returning the point of loop, revert the circular linked list.
	 */
	int intersectPoint(Link headA, Link headB)
	{
         // code here
         if (headA==null || headB==null) {
             return -1;
         }
         Link curr = headA;
         Link prev = null;
         while (curr != null) {
             prev = curr;
             curr = curr.getNext();
         }
         prev.setNext(headA);
         curr = headB;
         Link runner = headB;
         while (true) {
             curr = curr.getNext();
             runner = runner.getNext();
             runner = runner.getNext();
             if (curr == runner)
            	 break;
         }
         runner = headB;
         while (curr != runner) {
             curr = curr.getNext();
             runner = runner.getNext();
         }
         prev.setNext(null);
         return curr.getIData();
	}
	
	public static void main(String[] args) {
		Link l1 = new Link(3, 0);
		Link l2 = new Link(6, 0); l1.setNext(l2);
		Link l3 = new Link(9, 0); l2.setNext(l3);
		Link l4 = new Link(15, 0); l3.setNext(l4);
		Link l5 = new Link(30, 0); l4.setNext(l5);
		
		Link l6 = new Link(10, 0); l6.setNext(l4);
		
		IntersectionPointInYShapedLinkedList i = new IntersectionPointInYShapedLinkedList();
		System.out.println(i.intersectPoint(l1, l6));
	}
}
