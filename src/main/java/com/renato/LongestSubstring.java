package com.renato;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("abcabcbb"));

	}

	// Longest Substring Without Repeating Characters
	// This challenge will test your ability to efficiently traverse strings and
	// work with dynamic character sets.
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0, start = 0;
		Map<Character, Integer> charIndexMap = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if (charIndexMap.containsKey(c)) {
				start = Math.max(start, charIndexMap.get(c) + 1);
			}
			charIndexMap.put(c, end);
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}

}