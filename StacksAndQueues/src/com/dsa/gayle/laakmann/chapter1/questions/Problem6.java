package com.dsa.gayle.laakmann.chapter1.questions;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 
 * bytes, write a method to rotate the image by 90 degrees.
 */
public class Problem6 {
	
	private static String[][] image = null;
	private static int size;
	
	public Problem6(int x) {
		size = x;
		image = new String[x][x];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < x; j++)
				image[i][j] = i+","+j;
	}
	
	public void rotate() {
		for (int i=0; i<size/2; i++) {
			int first = i;
			int last = size -1 - i;
			for (int j=i; j<last; j++) {				
				String temp = image[first][j];
				int offset = j-first;
				// top  = left
				image[first][j] = image[last-offset][j];
				
				// left = bottom
				image[last-offset][first] = image[last][last-offset];
				
				// bottom = right
				image[last][last-offset] = image[j][last];
				
				// right = top
				image[j][last] = temp;
			}
			
		}
	}
	
	public static void main(String[] args) {
		Problem6 pr = new Problem6(3);
		System.out.println("Before rotate****");
		for (int i=0;i<size;i++) {
			for (int j=0; j<size; j++) {
				System.out.print(image[i][j]);
				System.out.print("  ");
			}				
			System.out.println();
		}
		pr.rotate();
		System.out.println("After rotate****");
		for (int i=0;i<size;i++) {
			for (int j=0; j<size; j++) {
				System.out.print(image[i][j]);
				System.out.print("  ");
			}				
			System.out.println();
		}					
	}

}
