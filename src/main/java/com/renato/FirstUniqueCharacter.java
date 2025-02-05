package com.renato;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

	public static void main(String[] args) {

		System.out.println(findFirstUnique("Google"));

	}

	// First Unique Character
	// Finding the first unique character in a string that tests your knowledge of
	// data structures such as arrays or hash maps, which can complicate the
	// implementation.
	public static char findFirstUnique(String str) {
		Map<Character, Integer> charCount = new LinkedHashMap<>();

		for (char c : str.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return '\0'; // Return null character if no unique character found
	}

}