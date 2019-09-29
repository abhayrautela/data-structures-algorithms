package com.dsa.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverser {
	private String input;
	private String output;
	
	public Reverser(String input) {
		this.input = input;
	}
	
	public String reverse() {
		int stackSize = 0;
		if (input != null)
			stackSize = input.length();
		MyCharStack stack = new MyCharStack(stackSize);
		for (int i = 0; i < stackSize; i++) {
			char c = input.charAt(i);
			stack.push(c);
		}
		output = "";
		while (!stack.isEmpty()) {
			char c = stack.pop();
			output = output + c;
		}
		
		return output;
	}
	
	public static void main (String args[]) {
		String input;
		String output;
		while (true) {
			System.out.println("Enter a string : ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			Reverser rev = new Reverser(input);
			output = rev.reverse();
			System.out.println("Reversed : " + output);
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
