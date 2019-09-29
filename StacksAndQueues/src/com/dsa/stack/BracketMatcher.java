package com.dsa.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketMatcher {
	public static void main (String args[]) {
		while (true) {
			System.out.print("Enter input string :");
			System.out.flush();
			String input = getString();
			if (input.equals("")) {
				break;
			}
			matchBracket(input);
		}		
	}
	
	private static void matchBracket(String input) {
		MyCharStack stack = new MyCharStack(input.length());
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
				case '{':
				case '[':
				case '(':
					stack.push(ch);
					break;
				case '}':
				case ']':
				case ')':
					if (!stack.isEmpty()) {
						char chx = stack.pop();
						if (chx == '{' && ch != '}' ||
							chx == '[' && ch != ']' ||
							chx == '(' && ch != ')') {
							System.out.println("Error at " + ch + "at " + i);
						}
					} else {
						System.out.println("Error at " + ch + "at " + i);
						break;
					}
			default:
				break;
			}
		}
		if (!stack.isEmpty()) {
			System.out.println("Right closing bracket is missing.");
		}
	}

	private static String getString() {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(is);
		String s = null;
		try {
			s = rd.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
