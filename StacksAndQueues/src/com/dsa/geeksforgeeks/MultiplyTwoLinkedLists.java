package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;
import com.dsa.linklist.LinkList;

/*
 * The task is to complete the function  multiplyTwoLists which multiplies two linked lists l1 and l2 and returns their product . 
 * The function takes two linked list l1, l2 as its arguments.
 * Note: The output could be large take modulo 10^9+7.
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains an 
 * integer n denoting the size of the first linked list (l1)  In the next  line are the space separated values of the first linked list. 
 * The third line of each test case contains an integer m denoting the size of the second linked list (l2). In the forth line are space separated 
 * values of the second linked list .
 * 
 *  Output:
 *  For each test case output will be an integer denoting the product of the two linked list.
 *  Constraints:
 *  1<=T<=100
 *  1<=n,m<=100
 *  
 *  Example(To be used only for expected output):
 *  Input
 *  2
 *  2
 *  3 2
 *  1
 *  2
 *  3
 *  1 0 0
 *  2
 *  1 0 
 *  Output
 *  64
 *  1000
 */
public class MultiplyTwoLinkedLists {
	
	void product(Link l1, Link l2) {
		if (l1 == null || l2 == null) {
			System.out.println(0);
			return;
		}
		int len1 = length(l1);
		int len2 = length(l2);
		double product1 = number(l1, len1) % (10E9+7);
		double product2 = number(l2, len2) % (10E9+7);
		double product = (product1 * product2) % (10E9+7);
		System.out.println(product);
	}
	
	double number(Link link, int len) {
		if (link == null) 
			return 0;
		double x = ((Math.pow(10, (len-1))*link.getIData())%(10E9+7));
		double y = (number(link.getNext(), len-1)%(10E9+7));
		return  x + y;
	}
	
	int length(Link link) {
		int len = 0;
		while (link != null) {
			len++;
			link = link.getNext();
		}
		return len;
	}
	
	public static void main(String[] args) {
		LinkList l1 = new LinkList();
		// 679065212789
		l1.insertFirst(9, 0);l1.insertFirst(8, 0);l1.insertFirst(7, 0);
//		l1.insertFirst(2, 0);l1.insertFirst(1, 0);l1.insertFirst(2, 0);
//		l1.insertFirst(5, 0);l1.insertFirst(6, 0);l1.insertFirst(0, 0);
//		l1.insertFirst(9, 0);l1.insertFirst(7, 0);l1.insertFirst(6, 0);
		LinkList l2 = new LinkList();
		// 679065212789
		l2.insertFirst(9, 0);l2.insertFirst(8, 0);l2.insertFirst(7, 0);
//		l2.insertFirst(2, 0);l2.insertFirst(1, 0);l2.insertFirst(2, 0);
//		l2.insertFirst(5, 0);l2.insertFirst(6, 0);l2.insertFirst(0, 0);
//		l2.insertFirst(9, 0);l2.insertFirst(7, 0);l2.insertFirst(6, 0);
		MultiplyTwoLinkedLists m = new MultiplyTwoLinkedLists();
		m.product(l1.getFirst(), l2.getFirst());
		System.out.println((789*789)%(10E9+7));
	}

}
