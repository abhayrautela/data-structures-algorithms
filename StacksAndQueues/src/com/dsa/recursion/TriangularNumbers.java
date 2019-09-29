package com.dsa.recursion;

public class TriangularNumbers {
	
	private static StringBuilder buff = new StringBuilder();
	
	public static void main (String args[]) {
		triangle(5);
		System.out.println(buff.toString());
	}
	
	public static int triangle(int n) {		
		if (n == 1) {
			buff.append("1,");
			return 1;
		} else {
			int x = n + triangle(n - 1);
			buff.append(x+",");
			return x;
		}
	}
}
