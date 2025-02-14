package com.renato;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings, string and pattern, the task is to find the smallest substring in string containing all characters of pattern.

Examples:

Input: string = “this is a test string”, pattern = “tist”
Output: “t stri”
Explanation: “t stri” contains all the characters of pattern.
Input: string = “geeksforgeeks”, pattern = “ork”
Output: “ksfor”
*/


public class SmallestSubstringPattern {

    public static String findSmallestSubstring(String str, String pattern) {
        if (str == null || pattern == null || str.length() < pattern.length()) {
            return "";
        }

        Map<Character, Integer> patternMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        int requiredCharCount = patternMap.size();
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = -1;

        while (right < str.length()) {
            char rightChar = str.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // If the current window contains all characters of pattern
            while (isValidWindow(windowMap, patternMap)) {
                // Update the smallest substring
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Shrink the window from the left
                char leftChar = str.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }
                left++;
            }

            right++;
        }

        return minLeft == -1 ? "" : str.substring(minLeft, minLeft + minLength);
    }

    private static boolean isValidWindow(Map<Character, Integer> windowMap, Map<Character, Integer> patternMap) {
        for (char c : patternMap.keySet()) {
            if (windowMap.getOrDefault(c, 0) < patternMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pattern = "ABC";
        System.out.println("Smallest substring: " + findSmallestSubstring(str, pattern));
    }
}