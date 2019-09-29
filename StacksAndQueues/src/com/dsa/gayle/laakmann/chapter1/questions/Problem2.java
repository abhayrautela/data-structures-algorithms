package com.dsa.gayle.laakmann.chapter1.questions;

/**
 * Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated 
 * string.
 * @author arautela
 *
 */
public class Problem2 {
	
	public static String reverse(String str) {
		char[] strArr = str.toCharArray();
		int len = str.length();
		char temp;
		for (int i = 0; i < len/2; i++) {
			temp = strArr[i];
			strArr[i] = strArr[len-1-i];
			strArr[len-1-i] = temp;
		}
		return new String(strArr);
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("rautela"));
	}

}
