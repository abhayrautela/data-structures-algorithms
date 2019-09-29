package com.dsa.gayle.laakmann.chapter11.questions;

/*
 * Given an MX N matrix in which each row and each column is sorted in ascending
 * order, write a method to find an element.
 */
public class Problem6 {
	
	private static int[][] arr;
	
	public static void main(String[] args) {
		getInput();		
		int searchKey = 55;
		int searchResult = searchInMatrix(searchKey, 0, 3);
		if (searchResult == searchKey) {
			System.out.println("Found!!!");
		} else {
			System.out.println("Not found!!!");
		}
	}
	
	private static int searchInMatrix(int searchKey, int topRow, int rightMostColumn) {
		if (topRow > 3 || rightMostColumn < 0) {
			return -1;
		}
		if (arr[topRow][rightMostColumn] > searchKey) {
			rightMostColumn--;// move left
			return searchInMatrix(searchKey, topRow, rightMostColumn);
		} else if (arr[topRow][rightMostColumn] < searchKey) {
			topRow++;// move down
			return searchInMatrix(searchKey, topRow, rightMostColumn);
		} else {
			return searchKey;
		}
		
	}
	
	private static void getInput() {
		arr = new int[4][4];
		arr[0][0] = 15;
		arr[0][1] = 20;
		arr[0][2] = 40;
		arr[0][3] = 85;
		
		arr[1][0] = 20;
		arr[1][1] = 35;
		arr[1][2] = 80;
		arr[1][3] = 95;
		
		arr[2][0] = 30;
		arr[2][1] = 55;
		arr[2][2] = 95;
		arr[2][3] = 105;
		
		arr[3][0] = 40;
		arr[3][1] = 80;
		arr[3][2] = 100;
		arr[3][3] = 120;		
	}

}
