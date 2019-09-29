package com.dsa.gayle.laakmann.chapter1.questions;

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 * @author arautela
 *
 */
public class Problem3 {
	
	/*
	 * This method can be used only if both strings contain only 
	 * lower case alphabets
	 */
	public static boolean isPermutationUsingBitmap(String str1, String str2) {
		int checker1 = 0, checker2 = 0;
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			int val = str1.charAt(i) - 'a';
			checker1 |= (1 << val);
		}
		for (int i = 0; i < str2.length(); i++) {
			int val = str2.charAt(i) - 'a';
			checker2 |= (1 << val);
		}
		return ((checker1 ^ checker2) == 0);
	}
	
	/*
	 * assuming ascii charset
	 */
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		
		int[] charCount = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			charCount[s1.charAt(i)]++;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (--charCount[s2.charAt(i)] < 0)
				return false;
		}
		return true;
	}
	
	public static boolean isPermutationUsingSort(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (sort(s1).equals(sort(s2))) {
			return true;
		}
		return false;
	}
	
	private static String sort(String s) {
		char[] c = s.toCharArray();
		java.util.Arrays.sort(c);
		return new String(c);
	}
	
	public static void main(String[] args) {
		System.out.println(isPermutationUsingBitmap("abcd", "dcbl"));
		System.out.println(isPermutationUsingBitmap("abcd", "dcba"));
		
		System.out.println(isPermutation("abcd", "dcbl"));
		System.out.println(isPermutation("abcd", "dcba"));
		
		System.out.println(isPermutationUsingSort("abcd", "dcbl"));
		System.out.println(isPermutationUsingSort("abcd", "dcba"));
		System.out.println(isPermutationUsingSort("abbd", "dbba"));
	}

}
