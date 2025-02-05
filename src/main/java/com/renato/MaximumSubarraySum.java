package com.renato;

public class MaximumSubarraySum {

	public static void main(String[] args) {

		int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(input));

	}

	// Maximum Subarray Sum
	// This challenge requires you to understand the dynamic programming concepts.
	public static int maxSubArray(int[] nums) {
	    int maxSum = nums[0], currentSum = nums[0];
	    for (int i = 1; i < nums.length; i++) {
	        currentSum = Math.max(nums[i], currentSum + nums[i]);
	        maxSum = Math.max(maxSum, currentSum);
	    }
	    return maxSum;
	}

}