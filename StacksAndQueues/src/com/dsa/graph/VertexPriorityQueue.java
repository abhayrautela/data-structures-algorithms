package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * A priority queue where highest value element is at 0.
 */
public class VertexPriorityQueue {

	private Edge[] pQueueArray;
	private int nItems;
	private int maxSize;

	public VertexPriorityQueue(int n) {
		nItems = 0;
		maxSize = n;
		pQueueArray = new Edge[n];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public Edge peekMin() {
		return pQueueArray[nItems - 1];
	}

	public Edge remove() {
		return pQueueArray[--nItems];
	}
	
	public void insert(int weight, String destVertexName, int srcIndex, int destIndex) {
		Edge item = new Edge(weight, destVertexName, srcIndex, destIndex);
		if (isFull())
			throw new UnsupportedOperationException("Queue is full");
		if (isEmpty()) {
			pQueueArray[nItems++] = item;
		} else {
			int j;
			for (j = nItems - 1; j >= 0; j--) {
				if (item.getWeight() > pQueueArray[j].getWeight()) {
					pQueueArray[j + 1] = pQueueArray[j];
				} else {
					break;
				}				
			}
			pQueueArray[j + 1] = item;
			nItems++;
		}
	}

	public void insertWithSwap(int weight, String destVertexName, int srcIndex, int destIndex) {
		Edge item = new Edge(weight, destVertexName, srcIndex, destIndex);
		boolean isSwapReqs = false;
		boolean isVertexExist = false;
		int n = nItems;
		if (isFull())
			throw new UnsupportedOperationException("Queue is full");
		for (int i=0; i<n; i++) {
			Edge ed = pQueueArray[--n];
			if (ed != null && ed.getDestVertexName().equalsIgnoreCase(destVertexName)) {
				isVertexExist = true;
				if (ed.getWeight() > weight) {
					isSwapReqs = true;
					break;
				}
			}
		}
		if (isSwapReqs) {
			List<Edge> lEdge = new ArrayList<Edge>();
			while (true) {
				Edge ed = remove();
				if (!ed.getDestVertexName().equalsIgnoreCase(destVertexName)) {
					lEdge.add(ed);
				} else {
					break;
				}
			}
			insertWithSwap(weight, destVertexName, srcIndex, destIndex);
			for (Edge ed : lEdge) {
				insertWithSwap(ed.getWeight(), ed.getDestVertexName(), ed.getSrcIndex(), ed.getDestIndex());
			}
		}
		if (!isVertexExist) {
			if (isEmpty()) {
				pQueueArray[nItems++] = item;
			} else {
				int j;
				for (j = nItems - 1; j >= 0; j--) {
					if (weight > pQueueArray[j].getWeight()) {
						pQueueArray[j + 1] = pQueueArray[j];
					} else {
						break;
					}
				}
				pQueueArray[j + 1] = item;
				nItems++;
			}
		}
	}

	// public static void main(String args[]) {
	// VertexPriorityQueue pQueue = new VertexPriorityQueue(5);
	// pQueue.insert(30);
	// pQueue.insert(10);
	// pQueue.insert(50);
	// pQueue.insert(40);
	// pQueue.insert(100);
	//
	// while (!pQueue.isEmpty()) {
	// System.out.println(pQueue.remove());
	// }
	// }
}
