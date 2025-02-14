package com.renato;

public class StringReversal {

	public static void main(String[] args) {

		System.out.println(reverseString("Welcome to CodingZap"));

	}

	// String Reversal
	// This is a common coding challenge that tests your understanding of string
	// manipulation without using built-in functions. It can be a bit tricky,
	// especially when you have to deal with different character types and spaces.
	public static String reverseString(String str) {
        var charArray = str.toCharArray();
        int left = 0, right = charArray.length - 1;
        
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        
        return new String(charArray);
    }

}