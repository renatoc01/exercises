package com.renato;

public class StringCompression {

	public static void main(String[] args) {

		System.out.println(compressString("aabcccccaaa"));

	}

	// Complex String Compression
	// This challenge will test your skills in character tracking, efficient memory
	// management, and manipulating strings directly in memory.
	public static String compressString(String input) {
		if (input == null || input.length() <= 1)
			return input;

		StringBuilder compressed = new StringBuilder();
		int count = 1;

		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				count++;
			} else {
				compressed.append(input.charAt(i - 1)).append(count);
				count = 1;
			}
		}

		// Handle last character sequence
		compressed.append(input.charAt(input.length() - 1)).append(count);

		return compressed.length() < input.length() ? compressed.toString() : input;
	}

}