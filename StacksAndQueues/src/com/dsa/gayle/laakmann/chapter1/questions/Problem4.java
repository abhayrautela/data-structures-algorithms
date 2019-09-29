package com.dsa.gayle.laakmann.chapter1.questions;

/*
 * Write a method to replace all spaces in a string with '%20'. You may assume that the
 * string has sufficient space at the end of the string to hold the additional characters,
 * and that you are given the "true" length of the string. (Note: if implementing in Java,
 * please use a character array so that you can perform this operation in place.)
 */
public class Problem4 {
	
	public static void main(String[] args) {
		String str = " abhay ";
		char[] arr = new char[100];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		System.out.println(replace(arr, str.length()));
	}
	
	public static char[] replace(char[] str, int length) {
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ')
				spaceCount++;
		}
		int newLength = length + (spaceCount * 2);
		str[newLength] = '\0';
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[--newLength] = '0';
				str[--newLength] = '2';
				str[--newLength] = '%';
			} else {
				str[--newLength] = str[i];
			}
		}
		return str;
	}

}
