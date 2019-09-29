package com.dsa.gayle.laakmann.chapter1.questions;

/*
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring (e.g., "waterbottLe" is a rotation of "erbottlewat").
 */
public class Problem8 {
	
	public static boolean isRotation(String s1, String s2) {
		int l1;
		if (s1 != null && (l1 = s1.trim().length()) > 0) {
			if (s2 != null && s2.trim().length() == l1) {
				s1 = s1 + s1;
				if (s1.indexOf(s2) > 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isRotation("abhay", "hayab"));
		System.out.println(isRotation("abhay", "hayba"));
	}

}
