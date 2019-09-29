package com.dsa.algo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * Given an input file with four billion non-negative integers, provide an algorithm
 * to generate an integer which is not contained in the file. Assume you have 1 GB of
 * memory available for this task.
 * FOLLOW UP
 * What if you have only 10 M8 of memory? Assume that all the values are distinct and
 * we now have no more than one billion non-negative integers
 */
public class Problem1 {
	/*
	 * Algo: An 32 bit int can have max 2^32 values which is ~ 4 billion. Lets represent each integer from 0 to 2^32 
	 * with the index of a byte array. Each bit in the byte array will represent 1 (integer is present in file) or
	 * 0 (integer is not present in file). 
	 */
	
	public static int generate() {
		int maxBits = Integer.MAX_VALUE - 1; // 0 to Integer.MAX_VALUE
		/*
		 * each byte in a byte array will have 8 bits, which means 8 distinct integers can be represented 
		 * by one byte. Hence max size of array required is maxBits/8.
		 * 
		 */
		byte[] bitField = new byte[maxBits/8];
		try {
			Scanner scn = new Scanner(new FileInputStream(new File("c:\\testFile.txt")));
			while (scn.hasNextInt()) {
				int n = scn.nextInt();
				bitField[n/8] |= 1 << (n%8); 
			}
			for (int i=0; i<maxBits/8; i++) {
				for (int j=0; j<8; j++) {
					if ((bitField[i] & (1 << j)) == 0) {
						// the bit value at position j is 0
						return i*8 + j;
					}
				}
			}
		} catch (IOException ioEx) {
			System.err.println("IOException occurred");
		}
		return 0;
	}
	
	public static void main(String[] args) {

		System.out.println(generate());
	}
}
