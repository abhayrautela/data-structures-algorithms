package com.dsa.gayle.laakmann.chapter2.questions;

/*
 * Implement a function to check if a linked list is a palindrome. The key thing to solve 
 * in this problem is how to reverse a link list. We can use arrays. There are two approaches in link lists, 
 * iterative and recursive.
 */
public class Problem7 {
	
	private static GenericLinkListAddLast<String> ll = null;
	
	public static void main(String[] args) {
		ll = new GenericLinkListAddLast<String>();		
		String s = "abhay";
		for (char c : s.toCharArray())
			ll.add(Character.toString(c));
		//findUsingArraysToReverseString(s);
		//findUsingReverseLinkListUsingIterationApproach(s);
		StringBuilder buff = new StringBuilder();
		findUsingLinkListUsingRecusrionApproach(ll.getFirst(), buff, s);
	}
	
	/*
	 * This method uses arrays to reverse the string and compare with original string
	 */
	public static void findUsingArraysToReverseString(String s) {
		String reverse = com.dsa.gayle.laakmann.chapter1.questions.Problem2.reverse(s);
		if (s.equals(reverse))
			System.out.println("String is a palindrome.");
		else 
			System.out.println("String is not a palindrome.");
	}
	
	/*
	 * This method reverses the link list using iteration and compares with original string
	 */
	public static void findUsingReverseLinkListUsingIterationApproach(String s) {
		GenericLink<String> curr = ll.getFirst();
		GenericLink<String> next = curr.next();
		GenericLink<String> temp = next;
		curr.setNext(null);
		while (next != null) {
			temp = temp.next();
			next.setNext(curr);
			curr = next;
			next = temp;			
		}
		ll.setFirst(curr);
		if (ll.display().equals(s))
			System.out.println("String is a palindrome.");
		else 
			System.out.println("String is not a palindrome.");
	}
	
	/*
	 * This method reverses the link list using recursion and compares with original string
	 */
	public static void findUsingLinkListUsingRecusrionApproach(GenericLink<String> curr, StringBuilder buff, String s) {
		if (curr != null) {
			findUsingLinkListUsingRecusrionApproach(curr.next(), buff, s);
		}
		if (curr != null) {
			buff.append(curr.getElement());
		}
		if (buff.length() == s.length()) {
			if (buff.toString().equals(s)) {
				System.out.println("String is a palindrome.");
			} else {
				System.out.println("String is not a palindrome.");
			}
		}
	}

}
