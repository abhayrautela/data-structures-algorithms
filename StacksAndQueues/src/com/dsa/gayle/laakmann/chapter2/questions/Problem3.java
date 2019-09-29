package com.dsa.gayle.laakmann.chapter2.questions;

/*
 * Implement an algorithm to delete a node in the middle of a singly linked list, given
 * only access to that node
 */
public class Problem3 {
	
	private static GenericLinkList<String> ll = null;
	
	public static void main(String[] args) {
		ll = new GenericLinkList<String>();
		String k = "abhay";
		for (int i = 0; i < k.length(); i++) {
			ll.add(k.substring(i, i + 1));
		}
		ll.display();
		GenericLink<String> curr = ll.getFirst();
		while (curr != null) {
			if (curr.getElement().equals("h")) {
				break;
			}
			curr = curr.next();
		}
		remove(curr);
		System.out.println("After removing...");
		ll.display();
	}
	
	/*
	 * Copy the curr.next data to curr node and delete curr.next
	 */
	private static void remove(GenericLink<String> curr) {		
		curr.setElement(curr.next().getElement());
		curr.setNext(curr.next().next());
	}
	
}
