package com.dsa.gayle.laakmann.chapter2.questions;

public class Problem5 {
	
	/*
	 * You have two numbers represented by a linked list, where each node contains a
	 * single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
	 * of the list. Write a function that adds the two numbers and returns the sum as a
	 * linked list.
	 */
	public static void main(String[] args) {
		GenericLinkList<Long> l1 = new GenericLinkList<Long>();
		GenericLinkList<Long> l2 = new GenericLinkList<Long>();
		// add number 8768
		l1.add(8L); l1.add(7L); l1.add(6L); l1.add(8L);
		l1.display();
		System.out.println();
		// add number 6785
		l2.add(6L); l2.add(7L); l2.add(8L); l2.add(5L);
		l2.display();
		System.out.println();
		
		GenericLinkList<Long> sumLL = add(l1, l2);		
		System.out.println("After adding...");
		sumLL.display();
	}
	
	public static GenericLinkList<Long> add(GenericLinkList<Long> l1, GenericLinkList<Long> l2) {
		GenericLinkList<Long> sumLL = new GenericLinkList<Long>();
		GenericLink<Long> currL1 = l1.getFirst();
		GenericLink<Long> currL2 = l2.getFirst();
		long sum = 0, carry = 0;
		while (currL1 != null || currL2 != null) {
			if (currL1 != null) {
				sum += currL1.getElement();
			}
			if (currL2 != null) {
				sum += currL2.getElement();
			}
			sum += carry;
			carry = (sum > 9)? sum / 10 : 0;
			sum = (sum > 9)? sum % 10 : sum;
			sumLL.add(sum);
			sum = 0;
			currL1 = currL1.next();
			currL2 = currL2.next();
		}
		sumLL.add(carry);
		return sumLL;
	}

}
