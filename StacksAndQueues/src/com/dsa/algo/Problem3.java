package com.dsa.algo;

/*
 * Generate IP Addresses
 */
public class Problem3 {
	
	private static void generateBruteForce(String str) {
		for (int i=1; i<=3; i++)
			for (int j=1; j<=3; j++)
				for (int k=1; k<=3; k++)
					for (int l=1; l<=3; l++) {
						if (i+j+k+l == str.length()) {
							String a = str.substring(0, i);
							String b = str.substring(i, j+j);
							String c = str.substring(i+j, i+j+k);
							String d = str.substring(i+j+k, i+j+k+l);
							System.out.println(a+"."+b+"."+c+"."+d);
						}
					}
	}
	
	/*
	 * This recursive approach is not fully working
	 */
	private static void generate(String str, int count) {
		if (str == null || str.length() <= count) {
			return;
		}
		if (count == 0) {
			System.out.print(str);
			return;
		}
		for (int i=0; i<str.length()-count; i++) {
			System.out.print(str.substring(0, i+1) + ".");
			generate(str.substring(i+1, str.length()), count-1);
			System.out.println();
			count = 3;
		}
	}
	
	public static void main(String args[]) {
		//generate("11211", 3);
		generateBruteForce("11211");
	}
}
