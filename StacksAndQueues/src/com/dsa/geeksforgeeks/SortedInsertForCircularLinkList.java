package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;

/*
 * Given a sorted circular linked list, insert a newnode so that it remains a sorted circular linked list.
 * A circular link list is one in which last link next points to first link.
 */
public class SortedInsertForCircularLinkList {
	Link sortedInsert(Link head, int x) {
		if (head == null) {
			head = new Link(x, 0);
			return head;
		}
		Link link = new Link(x, 0);
		Link prev = null;
		Link curr = head;
		boolean isFirst = x<=head.getIData()? true : false;
		
		while (prev == null || prev.getIData() < curr.getIData()) {
			if (x > curr.getIData() || isFirst) {
				prev = curr;
				curr = curr.getNext();
			} else {
				break;
			}
		}
		
		if (curr == head) {
			prev.setNext(link);
			link.setNext(curr);
			head = link;
		} else {
			prev.setNext(link);
			link.setNext(curr);
		}
		return head;
	}
	
	public static void main(String[] args) {
		Link head = new Link(1,0);
		Link link1 = new Link(3, 0); head.setNext(link1);
		Link link2 = new Link(5, 0); link1.setNext(link2);
		Link link3 = new Link(7, 0); link2.setNext(link3);
		Link last = new Link(9, 0); link3.setNext(last);
		last.setNext(head);
		SortedInsertForCircularLinkList s = new SortedInsertForCircularLinkList();
		//s.sortedInsert(head, 4);
		//s.sortedInsert(head, 2);
		//s.sortedInsert(head, 8);
		//s.sortedInsert(head, 10);
		//head = s.sortedInsert(head, 0);
		Link curr = head;
		while (curr.getIData() <= curr.getNext().getIData()) {
			System.out.println(curr.getIData());
			curr = curr.getNext();
		}
		if (curr.getIData() > curr.getNext().getIData())
		{
			System.out.println(curr.getIData());
			System.out.println(curr.getNext().getIData());
		}
	}
}
