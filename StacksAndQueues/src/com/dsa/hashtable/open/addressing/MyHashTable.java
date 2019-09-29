package com.dsa.hashtable.open.addressing;

public class MyHashTable {

	private DataItem[] data;
	private int size;
	private DataItem nonDataItem = null;

	public MyHashTable(int size) {
		data = new DataItem[size];
		this.size = size;
		nonDataItem = new DataItem(-1);
	}

	public void display() {
		for (DataItem x : data) {
			System.out.println(x.getData());
		}
	}

	public int hash(int x) {
		return x % size;
	}

	public void insert(int x) {
		// assume table is not full
		int hashValue = hash(x);
		while (data[hashValue] != null && data[hashValue].getData() != -1) {
			++hashValue;
			hashValue = hash(hashValue);
		}
		data[hashValue] = new DataItem(x);
	}

	public MyHashTable.DataItem find(int x) {
		int hashValue = hash(x);
		while (data[hashValue] != null) {
			if(data[hashValue].getData() == x) {
				return data[hashValue]; 
			}
			++hashValue;
			hashValue = hash(hashValue);
		}
		return null;
	}
	
	public MyHashTable.DataItem delete(int x) {
		int hashValue = hash(x);
		while (data[hashValue] != null) {
			if(data[hashValue].getData() == x) {
				MyHashTable.DataItem temp =  data[hashValue];
				data[hashValue] = nonDataItem;
				return temp;
			}
			++hashValue;
			hashValue = hash(hashValue);
		}
		return null;
	}

	private class DataItem {

		private int data;

		public DataItem(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}
	}

}
