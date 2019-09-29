package com.dsa.gayle.laakmann.chapter1.questions;


/**
 * Implement an algorithm to determine if a string has all unique characters. What if 
 * you cannot use additional data structures?
 * @author arautela
 *
 */
public class Problem1 {	
	
	public static boolean isUniqueChar(String str) {
		// assume char set is ascii which has 256 characters
		boolean[] charData = new boolean[256];
		if (str.length() > 256) {
			// there are 256 ascii characters
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			int asciiValue = str.charAt(i);
			if (charData[asciiValue]) {
				// already found
				return false;
			}
			charData[asciiValue] = true;
		}
		return true;
	}
	
	/*
	 * This method is applicable only if all characters in input string
	 * are lower case only
	 */
	public static boolean isUniqueCharUsingBitmap(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isUniqueChar("abhay"));
		System.out.println(isUniqueChar("raj"));
		System.out.println(isUniqueCharUsingBitmap("abhay"));
		System.out.println(isUniqueCharUsingBitmap("raj"));
	}

}
