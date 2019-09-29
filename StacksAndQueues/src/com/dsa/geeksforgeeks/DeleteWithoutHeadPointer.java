package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;

/*
 * You are given a pointer/reference to a node to be deleted in a linked list. The task is to delete the node.  
 * Pointer/reference to head node is not given. 
 * You may assume that the node to be deleted is not the last node.
 */
public class DeleteWithoutHeadPointer {
	
	void deleteNode(Link del)
    {
         // Your code here
         Link curr = del;
         Link prev = null;
         while (curr != null) {
             if (curr.getNext() != null) {
                curr.setIData(curr.getNext().getIData());  
                prev = curr;
                curr = curr.getNext();
             }
             else { 
                prev.setNext(null);
                curr = null;
             }
             
         }
    }
	
	public static void main(String[] args) {
		DeleteWithoutHeadPointer d = new DeleteWithoutHeadPointer();
		Link head = new Link(1, 0);
		Link l1 = new Link(2,0); head.setNext(l1);
		Link l2 = new Link(3,0); l1.setNext(l2);
		Link l3 = new Link(4,0); l2.setNext(l3);
		Link l4 = new Link(5,0); l3.setNext(l4);
		Link l5 = new Link(6,0); l4.setNext(l5);
		Link l6 = new Link(7,0); l5.setNext(l6);
		d.deleteNode(l2);
		Link curr = head;
		while (curr != null) {
			System.out.println(curr.getIData() + " ");
			curr = curr.getNext();
		}
	}
}
