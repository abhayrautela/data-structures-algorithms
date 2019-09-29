package com.dsa.gayle.laakmann.chapter2.questions;

/*
 * Write code to partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than or equal to x.
 */
public class Problem4 {
	
	private static GenericLinkList<Long> ll = null;
	
	public static void main(String[] args) {
		ll = new GenericLinkList<Long>();
		long sum = 0;
		int i = 0;
		for (; i<10; i++) {
			Long l = new Long(Math.round(Math.random() * 100));
			ll.add(l);
			sum += l;
		}
		ll.display();
		//sortAround(sum/i);
		ll = sortAroundUsingTwoLinkList(sum/i);
		System.out.println("After sorting...");
		ll.display();
	}
	
	/*
	 * Any link with data < l is deleted and added as first element of link list
	 */
	private static void sortAround(long l) {
		GenericLink<Long> curr = ll.getFirst();
		GenericLink<Long> prev = null;
		while (curr != null) {
			if (curr.getElement() < l && prev != null) {
				prev.setNext(curr.next());
				curr.setNext(ll.getFirst());				
				ll.setFirst(curr);
				curr = prev.next();
			} else {
				prev = curr;
				curr = curr.next();
			}			
		}
	}
	
	/*
	 * maintain two link lists, one for less and one for more than partition value.
	 * Merge in the end.
	 */
	public static GenericLinkList<Long> sortAroundUsingTwoLinkList(long k) {
		GenericLinkList<Long> llBefore = new GenericLinkList<Long>();
		GenericLinkList<Long> llAfter = new GenericLinkList<Long>();
		GenericLink<Long> curr = ll.getFirst();
		while (curr != null) {
			if (curr.getElement() < k) {
				llBefore.add(curr.getElement());				
			} else {
				llAfter.add(curr.getElement());
			}
			curr = curr.next();
		}
		
		curr = llBefore.getFirst();
		while (curr != null) {
			if (curr.next() == null) {
				curr.setNext(llAfter.getFirst());
				break;
			}
			curr = curr.next();
		}
		return llBefore;
	}
	
}
