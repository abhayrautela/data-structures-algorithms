package com.dsa.gayle.laakmann.chapter2.questions;

/*
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * ie. if k=0, it should return last element. If k=1, it should return 1st from last 
 * and so on.
 */
public class Problem2 {

	private static GenericLinkList<String> ll = null;

	public static void main(String[] args) {
		ll = new GenericLinkList<String>();
		String k = "abhay";
		for (int i = 0; i < k.length(); i++) {
			ll.add(k.substring(i, i + 1));
		}

//		System.out.println(nthFromLastElement(0));
//		System.out.println(nthFromLastElement(1));
//		System.out.println(nthFromLastElement(2));
//		System.out.println(nthFromLastElement(3));
//		System.out.println(nthFromLastElement(4));
		
//		System.out.println(nthFromLastElementWithoutNumElements(0));
//		System.out.println(nthFromLastElementWithoutNumElements(1));
//		System.out.println(nthFromLastElementWithoutNumElements(2));
//		System.out.println(nthFromLastElementWithoutNumElements(3));
//		System.out.println(nthFromLastElementWithoutNumElements(4));
		
		nthFromLastElementUsingRecursion(ll.getFirst(), 0);
		nthFromLastElementUsingRecursion(ll.getFirst(), 1);
		nthFromLastElementUsingRecursion(ll.getFirst(), 2);
		nthFromLastElementUsingRecursion(ll.getFirst(), 3);
		nthFromLastElementUsingRecursion(ll.getFirst(), 4);
	}

	/*
	 * This method works if we know the number of elements in the link list.
	 */
	public static String nthFromLastElement(int k) {
		// kth element from last is (n-k)th element
		GenericLink<String> curr = ll.getFirst();
		int n = ll.getnCurr();
		if (curr != null) {
			int count = 1;
			while (curr != null) {
				if (count == n - k) {
					return curr.getElement();
				} else {
					count++;
					curr = curr.next();
				}
			}
			return null;
		} else {
			return null;
		}
	}

	/*
	 * This method works if we do not know the number of elements in the link list.
	 */
	public static String nthFromLastElementWithoutNumElements(int k) {
		// assume this is the kth element from last. Then after k iterations, we should reach
		// the last element.
		GenericLink<String> curr = ll.getFirst();
		GenericLink<String> kthFromLast = curr;
		int count = k;
		while (curr != null) {
			while (count >= 0) {
				if (count == 0 && kthFromLast.next() == null) {
					return curr.getElement();					
				} else {
					count--;
					kthFromLast = kthFromLast.next();
				}
			}
			count = k;
			curr = curr.next();
			kthFromLast = curr;
		}
		return null;
	}
	
	public static int nthFromLastElementUsingRecursion(GenericLink<String> curr, int k) {
		if (curr == null) {
			return 0;
		}
		int i = nthFromLastElementUsingRecursion(curr.next(), k) + 1;
		if (i == k+1) {
			System.out.println(curr.getElement());
		}
		return i;
	}
}
