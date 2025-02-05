package com.renato;

import java.util.HashSet;

public class FindDuplicates {

	public static void main(String[] args) {

		int[] input = { 1, 2, 3, 4, 5, 2 };
		System.out.println(findDuplicates(input));

	}

	// Find Duplicates in an Array
	// This challenge requires you to identify all elements in an array that appear
	// more than once and is crucial for various applications, such as data
	// validation and analysis.
	public static HashSet<Integer> findDuplicates(int[] nums) {
		HashSet<Integer> duplicates = new HashSet<>();
		HashSet<Integer> seen = new HashSet<>();

		for (int num : nums) {
			if (!seen.add(num)) { // If add returns false, it's a duplicate
				duplicates.add(num);
			}
		}

		return duplicates;
	}

}