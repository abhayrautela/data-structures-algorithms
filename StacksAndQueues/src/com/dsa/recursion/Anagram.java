package com.dsa.recursion;

public class Anagram {
	
	private static String str = "abcd";

	public static void anagram(int newSize) {
		if (newSize == 1) {			
			return;
		}
		for (int i = 0; i < newSize; i++) {					
			anagram(newSize-1);
			if (newSize == 2) {
				System.out.println(str);
			}
			str = rotate(newSize);						
		}
	}

	private static String rotate(int newSize) {		
		int position = str.length()-newSize;
		String start = str.substring(0, position);
		String left = str.substring(position, position+1);
		String right = str.substring(position+1);
		return start + right + left;
	}

	public static void main(String[] args) {
		anagram(str.length());
	}

}
