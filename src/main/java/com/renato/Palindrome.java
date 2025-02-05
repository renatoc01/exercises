package com.renato;

public class Palindrome {

	public static void main(String[] args) {

		System.out.println(canFormPalindrome("tactcoa"));

	}

	// Palindrome Permutation Detector
	// This challenge is all about understanding character frequencies and efficient
	// counting. You'll also need to apply some logical reasoning to determine if a
	// string is symmetric.
	public static boolean canFormPalindrome(String s) {
		int[] charCount = new int[128];

		// Count character frequencies
		for (char c : s.toCharArray()) {
			charCount[c]++;
		}

		// Count characters with odd frequency
		int oddCount = 0;
		for (int count : charCount) {
			if (count % 2 != 0) {
				oddCount++;
			}

			// More than one character with odd frequency means no palindrome possible
			if (oddCount > 1) {
				return false;
			}
		}

		return true;
	}

}