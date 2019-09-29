package com.dsa.gayle.laakmann.chapter1.questions;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.
 * @author arautela
 *
 */
public class Problem5 {
	
	public static void main(String[] args) {
		System.out.println(compress("aaabhayy"));
	}
	
	/*
	 * Using StringBuffer
	 */
	public static String compress(String str) {
		char previous = ' ';
		char current = ' ';
		int count = 1;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			current = str.charAt(i);
			if (previous == current) {
				count++;
			} else if (previous != ' ') {
				result.append(previous);
				if (count > 1)
					result.append(count);
				count = 1;
			}
			previous = current;
		}
		result.append(previous);
		if (count > 1)
			result.append(count);
		if (result.length() >= str.length())
			return str;
		else
			return result.toString();
	}

}
