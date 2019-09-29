package com.dsa.geeksforgeeks;

import com.dsa.linklist.Link;

/*
 * Given a linked list, remove the loop in it if present. The task is to complete the function removeTheLoop which takes only one argument the head of the linked list . The function removes the loop in the linked list if present.
 * Input:
 * The first line of input will contain an integer T denoting the no of test cases . Then T test cases follow. Each test case contains 3 lines . The first line of each test case contains an integer N denoting the no of nodes of the linked list . In the next line are N space separated values denoting the values of the linked list. The next line after it contains an integer x denoting that the last node of the linked list pointing to the xth node thus resulting in cycle. 
 * Output:Your task is to remove the cycle if present output for each test case will be 1 if the loop is successfully removed from the linked list else 0.
 * Constraints:
 * 1<=T<=50
 * 1<=N<=300
 * 
 * Example(To be used only for expected output) :
 * 
 * Input:
 * 2
 * 3
 * 1 3 4
 * 2
 * 4
 * 1 8 3 4
 * 0
 * 
 * Output:
 * 1
 * 1
 * 
 * Explanation:
 * In the first test case N = 3
 * The linked list with nodes N = 3 is given. here x=2 which means last node is connected with xth node of linked list. 
 * Therefore, there exists a loop. 
 * 
 * In the second test where N = 4 and x = 0, which means lastNode->next = NULL, thus the Linked list does not contains any loop.
 */
public class RemoveLoopInLinkedList {
	
	void removeLoop(Link link) {
		if (link == null) {
			System.out.println(0);
			return;
		}
		Link curr = link;
		Link runner = link;
		boolean isLoop = false;
		while (curr != null && runner != null) {
			curr = curr.getNext();
			runner = runner.getNext();
			if (runner != null)
				runner = runner.getNext();
			if (curr != null && runner != null && curr == runner) {
				isLoop = true;
				break;
			}
		}
		if (!isLoop) {
			System.out.println(0);
			return;
		}
		curr = link;
		Link prev = null;
		while (true) {
			curr = curr.getNext();
			prev = runner;
			runner = runner.getNext();
			if (curr == runner) {
				prev.setNext(null);
				break;
			}
		}
		System.out.println(1);
	}
	
	public static void main(String args[]) {
		Link head = new Link(1, 0);
		Link curr = head;
		curr.setNext(new Link(2, 0)); curr = curr.getNext();
		curr.setNext(new Link(3, 0)); curr = curr.getNext();
		Link loop = curr; curr.setNext(new Link(4, 0)); curr = curr.getNext();
		curr.setNext(new Link(5, 0)); curr = curr.getNext();
		curr.setNext(new Link(6, 0)); curr = curr.getNext();
		curr.setNext(new Link(7, 0)); curr = curr.getNext();
		curr.setNext(loop);
		RemoveLoopInLinkedList test = new RemoveLoopInLinkedList();
		test.removeLoop(head);
		curr = head;
		while (curr != null) {
			System.out.print(curr.getIData() + " ");
			curr = curr.getNext();
		}
	}

}
