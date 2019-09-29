package com.dsa.queue;

import com.dsa.trees.binary.Node;


/*
 * A priority queue where highest value element is at 0. Hence least value element has highest priority.
 */
public class NodePriorityQueue {
	
	private Node[] pQueueArray;
	private int nItems;
	private int maxSize;
	
	public NodePriorityQueue(int n) {
		nItems = 0;
		maxSize = n;
		pQueueArray = new Node[n];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public Node peekMin() {
		return pQueueArray[nItems - 1];
	}
	
	public Node remove() {
		return pQueueArray[--nItems];
	}
	
	public void insert(int x, String y) {
		if (isFull())
			throw new UnsupportedOperationException("Queue is full");
		Node node = new Node(x, y);
		if (isEmpty()) {
			pQueueArray[nItems++] = node;
		} else {
			int j;
			for (j = nItems - 1; j >= 0; j--) {
				if (node.getData() > pQueueArray[j].getData()) {
					pQueueArray[j + 1] = pQueueArray[j];
				} else {
					break;
				}				
			}
			pQueueArray[j + 1] = node;
			nItems++;
		}
	}
	
	public void insert(Node node) {
		if (isFull())
			throw new UnsupportedOperationException("Queue is full");
		if (isEmpty()) {
			pQueueArray[nItems++] = node;
		} else {
			int j;
			for (j = nItems - 1; j >= 0; j--) {
				if (node.getData() > pQueueArray[j].getData()) {
					pQueueArray[j + 1] = pQueueArray[j];
				} else {
					break;
				}				
			}
			pQueueArray[j + 1] = node;
			nItems++;
		}
	}
	
	public void display () {
		for (int i = 0; i < pQueueArray.length; i++) {
			if (pQueueArray[i] != null)
				System.out.println(pQueueArray[i].getsData() + "-" + pQueueArray[i].getData());
		}
	}
	
	public boolean contains (String s) {
		for (int i = 0; i < pQueueArray.length; i++) {
			if (pQueueArray[i] != null && pQueueArray[i].getsData().equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return nItems;
	}
}
