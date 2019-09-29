package com.dsa.gayle.laakmann.chapter1.questions;

/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 */
public class Problem7 {
	
	private static int[][] matrix = null;
	private static int size;
	boolean[] rowZero;
	boolean[] colZero;
	
	public Problem7(int x) {
		size = x;
		rowZero = new boolean[size];
		colZero = new boolean[size];
		matrix = new int[x][x];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < x; j++)
				matrix[i][j] = (i*j);
	}
	
	public void setZeros() {
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (matrix[i][j] == 0) {
					rowZero[i] = true;
					colZero[j] = true;
				}
			}			 
		}
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (rowZero[i] || colZero[j]) {
					matrix[i][j] = 0;
				}
			}			 
		}
	}
	
	public static void main(String[] args) {
		Problem7 pr = new Problem7(3);
		System.out.println("Before ****");
		for (int i=0;i<size;i++) {
			for (int j=0; j<size; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("  ");
			}				
			System.out.println();
		}
		pr.setZeros();
		System.out.println("After ****");
		for (int i=0;i<size;i++) {
			for (int j=0; j<size; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("  ");
			}				
			System.out.println();
		}					
	}
}
