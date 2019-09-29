package com.dsa.gayle.laakmann.chapter1.questions;

public class BinaryShiftOperators {
	
	public static void main(String[] args) {
		shiftRight(20, 2);
		shiftRight(-20, 2);
		shiftLeft(20, 2);
		shiftLeft(-20, 2);
		shiftRightWithZeroAsMSB(-1, 2);
	}
	
	public static void shiftRight(int x, int y) {
		System.out.println(" >> opeartor"); 
		System.out.println(x+" >> " +y +" = "+(x>>y));
	}
	
	public static void shiftLeft(int x, int y) {
		System.out.println(" << opeartor");
		System.out.println(x+" << " +y +" = "+(x<<y));
	}
	
	public static void shiftRightWithZeroAsMSB(int x, int y) {
		System.out.println(" >>> opeartor");
		System.out.println(x+" >>> " +y +" = "+(x>>>y));
	}

}
