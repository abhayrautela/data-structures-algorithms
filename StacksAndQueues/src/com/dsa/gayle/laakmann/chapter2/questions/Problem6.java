package com.dsa.gayle.laakmann.chapter2.questions;

/*
 * Given a circular linked list, implement an algorithm which returns the node at the
 * beginning of the loop.
 */
public class Problem6 {

	private static GenericLinkList<Long> ll = null;

	public static void main(String[] args) {
		ll = new GenericLinkList<Long>();
		int i = 10;
		for (; i > 0; i--) {
			Long l = new Long(i);
			ll.add(l);			
		}
		ll.display();
		GenericLink<Long> curr = ll.getFirst();
		GenericLink<Long> prev = null;
		GenericLink<Long> loopStart = null;
		while (curr != null) {
			if (i == 5) {
				loopStart = curr;
				System.out.println("Loop at : " + loopStart.getElement());
			}
			prev = curr;
			curr = curr.next();
			i++;
		}
		prev.setNext(loopStart);		
		getNodeBeginningLoop();
	}
	
	public static void getNodeBeginningLoop() {
		GenericLink<Long> fast = ll.getFirst();
		GenericLink<Long> slow = ll.getFirst();
		slow = slow.next();
		fast = fast.next().next();
		boolean loopExist = false;
		while (fast != null && slow != null) {			
			if (fast.getElement() == slow.getElement()) {
				loopExist = true;
				break;
			}
			slow = slow.next();
			fast = fast.next().next();
		}
		if (!loopExist) {
			System.out.println("Loop does not exist.");
		} else {
			System.out.println("Loop exist.");
		}
		slow = ll.getFirst();
		while (slow != null & fast != null) {
			if (slow.getElement() == fast.getElement()) {
				System.out.println("Loop at : " + slow.getElement());
				break;
			}
			slow = slow.next();
			fast = fast.next();
		}		
	}
	
}
