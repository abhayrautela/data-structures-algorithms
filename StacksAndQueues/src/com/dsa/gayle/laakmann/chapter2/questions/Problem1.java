package com.dsa.gayle.laakmann.chapter2.questions;

/*
 * Write code to remove duplicates from an unsorted linked list
 */
public class Problem1 {
	
	private static GenericLinkList<String> ll = null;
	
	public static void main(String[] args) {
		ll = new GenericLinkList<String>();
		String k = "abhay raj singh rautela";
		for (int i=0; i < k.length(); i++) {
			ll.add(k.substring(i, i+1));
		}
		ll.display();
		//removeDuplicates();
		removeDuplicatesWithoutBuffer();
		ll.display();
	}
	
	public static void removeDuplicates() {
		GenericLink<String> curr = ll.getFirst();
		GenericLink<String> previous = null;
		java.util.Hashtable<String, String> ht = new java.util.Hashtable<String, String>();
		while (curr != null) {
			if (ht.containsKey(curr.getElement())) {
				if (previous == null) {
					ll.setFirst(curr.next());
				} else {
					previous.setNext(curr.next()); 
				}
			} else {
				ht.put(curr.getElement(), "");
				previous = curr;				
			}
			curr = curr.next();
		}
	}
	
	public static void removeDuplicatesWithoutBuffer() {
		GenericLink<String> curr = ll.getFirst();
		GenericLink<String> previous = null;
		while (curr != null) {
			boolean isDuplicate = false;
			GenericLink<String> runner = curr.next();
			while (runner != null) {
				if (runner.getElement().equals(curr.getElement())) {
					isDuplicate = true;
					break;
				}
				runner = runner.next();
			}
			if (isDuplicate) {
				if (previous == null) {
					ll.setFirst(curr.next());
				} else {
					previous.setNext(curr.next()); 
				}
			} else {
				previous = curr;				
			}
			curr = curr.next();
		}
	}

}
