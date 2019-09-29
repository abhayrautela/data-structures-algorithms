package com.dsa.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a dictionary of words and a pattern.  Every character in the pattern is uniquely mapped to a character in the dictionary.
 * The task is to complete a function  findMatchedWords that returns a vector of  strings matching with given pattern. 
 * The function takes two argument the first argument is an array of strings which denote the dictionary and the second argument is the pattern to match.
 * 
 * Input:
 * The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . The first line of each test case contains an integer N denoting the no of strings in the dictionary and then in the next line are N space separated strings denoting the strings of the dictionary. Then in the next line is a string pattern.
 * 
 * Output:
 * The output for each test case will be the space separated strings that matches the given pattern in lexicographical order.
 * 
 * Constraints:
 * 1<=T<=100
 * 1<=N<=100
 * 1
 * Example(To be used only for expected output):
 * Input
 * 1
 * 4
 * abb abc  xyz xyy
 * foo
 * 
 * Output
 * abb xyy
 * 
 * Explanation
 * In the above test case xyy and abb have same character at index 1 and 2 like the pattern.
 */
public class MatchSpecificPattern {
	
	String[] findMatchedWords(String[] dict, String p) {
		String[] output = new String[dict.length];
		int index = 0;
		if (dict != null && dict.length > 0) {
			String hashP = getHash(p);
			for (String d : dict) {
				if (d.length() == p.length() && hashP.equals(getHash(d))) {
					output[index++] = d;
				}
			}
		}
		return output;
	}
	
	String getHash(String str) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String hash = "";
		int i = 0;
		if (str != null && str.length() > 0) {
			for (int j=0; j<str.length(); j++) {
				String ch = str.substring(j, j+1);
				if (map.get(ch) == null) {
					map.put(ch, i++);
				}
				hash += map.get(ch);
			}
		}
		return hash;
	}
	
	public static void main(String args[]) {
		MatchSpecificPattern match = new MatchSpecificPattern();
		String dict[] = {"abb", "abc", "xyz", "xyy"};		
		String output[] = match.findMatchedWords(dict, "foo");
		for (String s : output) {
			if (s != null)
				System.out.print(s+" ");
		}
		System.out.println();
		
		String dict1[] = {"abb", "abc", "xyz", "xyy"};		
		String output1[] = match.findMatchedWords(dict1, "mno");
		for (String s : output1) {
			if (s != null)
				System.out.print(s+" ");
		}
		System.out.println();
		
		String dict2[] = {"abb", "abc", "xyz", "xyy"};		
		String output2[] = match.findMatchedWords(dict2, "aba");
		for (String s : output2) {
			if (s != null)
				System.out.print(s+" ");
		}
		System.out.println();
		
		String dict3[] = {"abab", "aba", "xyz", "xyx"};		
		String output3[] = match.findMatchedWords(dict3, "aba");
		for (String s : output3) {
			if (s != null)
				System.out.print(s+" ");
		}
	}

}
