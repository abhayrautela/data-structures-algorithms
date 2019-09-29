package com.dsa.algo;

public class NextPermutationOfString {
	
	public static void findNextPermutation(int[] word) {
		int i = word.length - 1;
		
		while (i > 0 && word[i-1] >= word[i])
			i--;
		
		if (i == 0) {
			System.out.println("no answer");
		}
		
		int pivot = word[i-1];
		int j = word.length - 1;
		while (pivot > word[j])
			j--;
		
		int temp = word[i-1];
		word[i-1] = word[j];
		word[j] = temp;
		
		int[] nextPermutation = reverse(word, i);
		
		for (int c : nextPermutation) {
			System.out.print(c);
		}
	}

	private static int[] reverse(int[] word, int startIndex) {
		int endIndex = word.length - 1;
		for (int i=0; i < (word.length-startIndex)/2; i++) {
			int temp = word[startIndex+i];
			word[startIndex+i] = word[endIndex-i];
			word[endIndex-i] = temp;
		}
		return word;
	}
	
	public static void main(String[] args) {
		int[] word = {0, 1, 2, 5, 3, 3, 0};
		findNextPermutation(word);
	}
	
}
