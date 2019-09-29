package com.dsa.hashtable.separate.chaining;

import com.dsa.linklist.Link;
import com.dsa.linklist.SortedLinkList;

public class LinkListHashTable {
	
	private SortedLinkList[] arr;
	private int size;
	
	public LinkListHashTable(int size) {
		this.size = size;
		arr = new SortedLinkList[size];
		for (SortedLinkList list : arr) {
			list = new SortedLinkList();
		}
	}
	
	public void display() {
		for (SortedLinkList list : arr) {
			list.display();
		}
	}
	
	private int hashValue(int key) {
		return key % size;
	}
	
	public void insert(Link link) {
		int hashValue = hashValue(link.getIData());
		arr[hashValue].insert(hashValue, 0.0);
	}
	
	public void delete(Link link) {
		int hashValue = hashValue(link.getIData());
		arr[hashValue].delete(link.getIData());
	}

}
