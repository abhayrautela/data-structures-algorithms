package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;

/*
 * Given a singly linked list: A0->A1->...->An-1->An,
 * reorder it to: A0->An->A1->An-1->A2->An-2->...
 * Given 1->2->3->4->5 its reorder is 1->5->2->4->3.
 */
public class ReorderList {
	
	Link reorderlist(Link head)
    {
        // Your code here
        Link curr = head, runner = head;
        if (curr == null || curr.getNext() == null)
            return head;
        // find mid
        while (runner != null) {
            curr = curr.getNext();
            runner = runner.getNext();
            if (runner != null)
                runner = runner.getNext();
            else
                break;
        }
        Link mid = curr;
        curr = head;
        // reverse second half
        Link rev = reverse(mid, null);
        Link ct = null;
        Link rt = null;
        while (rev != null) {
            ct = curr;
            rt = rev;
            curr = curr.getNext();
            rev = rev.getNext();
            ct.setNext(rt);
            rt.setNext(curr);
        }
        if (rt != null && rt.getNext() != null)
        	rt.getNext().setNext(null);
        return head;
    }
    
    Link reverse (Link link, Link prev) {
        if (link == null) {
            return prev;
        }
        Link head = reverse(link.getNext(), link);
        link.setNext(prev);
        return head;
    }
	
	public static void main(String[] args) {
		Link head = new Link(1,0);
		Link link1 = new Link(2, 0); head.setNext(link1);
		Link link2 = new Link(3, 0); link1.setNext(link2);
		Link link3 = new Link(4, 0); link2.setNext(link3);
		//Link last = new Link(5, 0); link3.setNext(last);
		ReorderList l= new ReorderList();
		l.reorderlist(head);		
		while (head != null) {
			System.out.println(head.getIData() + " ");
			head = head.getNext();
		}
	}

}
