package com.dsa.geeksforgeeks;

public class KthElementInMatrix {
	
	/*
	 * Given an n x n matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the given 2D array.
	 * Your task is to complete the function kthSmallest which takes two arguments the first is a matrix (mat) and sec argument 
	 * is the order of the matrix (n) and the function returns the kth smallest element in the matrix.
	 * 
	 * For example, consider the following 2D array.
	 * 10, 20, 30, 40
	 * 15, 25, 35, 45
	 * 24, 29, 37, 48
	 * 32, 33, 39, 50
	 * The 3rd smallest element is 20 and 7th smallest element is 30
	 * 
	 * Input:
	 * The first line of input is an integer T denoting the no of test cases . Then T lines follow . \
	 * The first line of each test case contains an integer N denoting the size of the matrix then in the next line are N*N 
	 * space separated values of the matrix . The third line contains an integer k.
	 * 
	 * Output:
	 * For each test case print in a new line the kth smallest element of the matrix  .
	 * 
	 * Constraints:
	 * 1<=T<=100
	 * 1<= N<=20
	 * 1<= M[][]<=100
	 * 
	 * Example
	 * Input
	 * 1
	 * 4
	 * 16 28 60 64 22 41 63 91 27 50 87 93 36 78 87 94 
	 * 3
	 * Output
	 * 27
	 */
	int kthSmallest(int[][] matrix, int size, int k) {
		MinHeap heap = getMinHeap(size*size);
		for (int i=0; i<size; i++) {
			heap.insert(matrix[0][i], 0, i);
		}
		Element temp = null;
		for (int i=0; i<k; i++) {
			temp = heap.remove();
			heap.insert(matrix[temp.getRow()+1][temp.getCol()], temp.getRow()+1, temp.getCol());
		}
		return temp.getElement();
	}
	
	class Element {
		int row, col, element;
		
		Element(int row, int col, int element) {
			this.row = row;
			this.col = col;
			this.element = element;
		}

		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}

		public int getElement() {
			return element;
		}		
	}
	
	class MinHeap {
		Element[] elem;
		int maxSize, currSize;
		
		MinHeap(int maxSize) {
			this.maxSize = maxSize;
			elem = new Element[maxSize];
		}
		
		boolean insert(int data, int row, int col) {
			if (maxSize == currSize) return false;
			Element e = new Element(row, col, data);			
			int index = currSize++;
			elem[index] = e;
			int parent = (index-1)/2;
			while (elem[parent].getElement() > e.getElement() && parent < index) {
				elem[index] = elem[parent];
				index = parent;
				parent = (index-1)/2;
			}
			elem[index] = e;
			return true;
		}
		
		Element remove() {
			Element e = elem[0];
			Element temp = elem[--currSize];
			elem[0] = temp;
			elem[currSize] = null;
			int index = 0;
			int left = 2*index+1; 
			int right = left+1;
			while (index < currSize && left < currSize && right < currSize) {								
				if (elem[left].getElement() <= elem[right].getElement()
						&& elem[left].getElement() < temp.getElement()) {
					elem[index] = elem[left];
					index = left;
				} else if (elem[right].getElement() <= elem[left].getElement()
						&& elem[right].getElement() < temp.getElement()) {
					elem[index] = elem[right];
					index = right;
				} else {
					break;
				}
				left = 2*index+1;
				right = left+1;
			}
			elem[index] = temp;
			return e;
		}
	}
	
	MinHeap getMinHeap(int maxSize) {
		return new MinHeap(maxSize);
	}
	
	public static void main(String[] args) {
		KthElementInMatrix m = new KthElementInMatrix();		
		int[][] matrix = {
				{10, 20, 30, 40}, {15, 25, 35, 45}, {24, 29, 37, 48}, {32, 33, 39, 50}
		};
		System.out.println(m.kthSmallest(matrix, 4, 3));
		System.out.println(m.kthSmallest(matrix, 4, 7));
//		test heap
//		MinHeap h = m.getMinHeap(10);
//		h.insert(100, 0, 0);
//		h.insert(90, 0, 0);
//		h.insert(80, 0, 0);
//		h.insert(70, 0, 0);
//		h.insert(60, 0, 0);
//		h.insert(50, 0, 0);
//		h.insert(40, 0, 0);
//		h.insert(30, 0, 0);
//		h.insert(20, 0, 0);
//		h.insert(10, 0, 0);
//		System.out.println(h.remove());
//		System.out.println(h.remove());
//		System.out.println(h.remove());
//		System.out.println(h.remove());
//		System.out.println(h.remove());
//		System.out.println(h.remove());
//		System.out.println(h.remove());
//		System.out.println(h.remove());
//		System.out.println(h.remove());
//		System.out.println(h.remove());
	}

}
