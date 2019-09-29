package com.dsa.gayle.laakmann.chapter11.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each
 * other.
 */
public class Problem2 {
	
	private static String[] str = null;

	public static void main(String[] args) {
		getInput();
		/*
		 * We do not need to sort but only place anagrams next to each other.
		 */
		Hashtable<String, List<String>> ht = new Hashtable<String, List<String>>();
		for (int i=0; i<str.length; i++) {
			char[] c = str[i].toCharArray();
			Arrays.sort(c);
			String sortedString = new String(c);
			List<String> strList = null;
			if (ht.get(sortedString) != null) {
				strList = ht.get(sortedString);
				strList.add(str[i]);
			} else {
				strList = new ArrayList<String>();
				ht.put(sortedString, strList);
				strList.add(str[i]);
			}
		}
		display(ht);
	}
	
	/*
	 * Since the requirement is only to sort such that anagrams are next to each other. Hence we can use a hashtable in which 
	 * key will be sorted word and values will be list of anagrams. Also two words are anagrams if their sorted strings are same.
	 */
	private static void display (Hashtable<String, List<String>> ht) {
		System.out.println("Array with anagrams next to each other: ");
		if (ht != null) {
			for (String key : ht.keySet()) {
				List<String> list = ht.get(key);
				if (list != null && list.size() > 0) {
					for (String s : list) {
						System.out.println(s + " ");
					}
				}
			}
		}
	}
	
	private static void getInput() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of strings: ");
		int size = scn.nextInt();
		str = new String[size];
		System.out.println("Enter strings separated by space: ");
		for (int i=0; i<size; i++) {
			str[i] = scn.next();
		}
	}

}
