package com.dsa.geeksforgeeks;

public class Implementstrstr {
	
	/*
	 * Your task  is to implement the function strstr. The function takes two strings as arguments(s,x) and  locates 
	 * the occurrence of the string x in the string s. The function returns and integer denoting  the first occurrence of the string x .
	 * 
	 * Input:
	 * The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. 
	 * The first line of each test case contains two strings str and target.
	 * 
	 * Output:
	 * For each test case in a new line output will be an integer denoting the first occurrence of the target  string in the string s. 
	 * Return -1 if no match found.
	 * 
	 * Constraints:
	 * 1<=T<=100
	 * 1<=length of (s,x)<=1000
	 * 
	 * Example:
	 * Input
	 * 2
	 * GeeksForGeeks Fr
	 * GeeksForGeeks For
	 * Output
	 * -1
	 * 5
	 */
	int strstr(String str, String target)
    {
       // Your code here
	   if (str == null || target == null || str.length() < target.length()) {
			return -1;
	   }
	   for (int i=0; i<=str.length()-target.length(); i++) {
			if (str.substring(i,i+target.length()).equals(target)) {
				return i;
			}
	   }
	   return -1;
    }
	
	public static void main(String[] args) {
		Implementstrstr str = new Implementstrstr();
		System.out.println(str.strstr("GeeksForGeeks", "Fr"));
		System.out.println(str.strstr("GeeksForGeeks", "For"));
	}

}
