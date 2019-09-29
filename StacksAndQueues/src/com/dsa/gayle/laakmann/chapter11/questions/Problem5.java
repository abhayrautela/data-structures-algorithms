package com.dsa.gayle.laakmann.chapter11.questions;


/*
 * Given a sorted array of strings which is interspersed with empty strings, write a
 * method to find the location of a given string.
 */
public class Problem5 {
	
	private static String[] arr;
	
	public static void main(String[] args) {
		getInput();
		String x = "bhghsd";
		int start = 0;
		int end = arr.length-1;		
		int searchIndex = binarySearch(x, start, end);
		System.out.println("Found at index: " + searchIndex);
		
	}
	
	private static int binarySearch(String x, int start, int end) {		
		if (start > end) {
			return -1;
		}
		int mid = (start+end)/2;
		if (arr[mid] == null || arr[mid].length() == 0) {
			int midLeft = mid-1;
			int midRight = mid+1;
			while (true) {
				if (midLeft<start || midRight > end) {
					return -1;
				} else if (midLeft > start && arr[midLeft] != null && arr[midLeft].length() > 0) {
					mid = midLeft;
					break;
				} else if (midRight > end && arr[midRight] != null && arr[midRight].length() > 0) {
					mid = midRight;
					break;
				}
				midLeft--;
				midRight++;
			}
		}		
		if (arr[mid].equals(x)) {
			return mid;
		} else if (x.compareTo(arr[mid]) < 0) {
			return binarySearch(x, start, mid-1);
		} else {
			return binarySearch(x, mid+1, end);
		}
	}

	private static void getInput() {
		arr = new String[10];
		arr[0] = "aqpmfg";
		arr[1] = "bhghsd";
		arr[2] = "";
		arr[3] = "bkfyh";
		arr[4] = "gdfgd";
		arr[5] = "";
		arr[6] = "lpid";
		arr[7] = "moshfff";
		arr[8] = "";		
		arr[9] = "nowqp";										
	}

}
