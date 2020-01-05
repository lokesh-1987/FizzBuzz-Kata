package com.fizzbuzz.utils;

public class FizbuzzRules {

	public static String calculateFizzBuzz(int i) {
		if (i % (3 * 5) == 0) {
			return "FizzBuzz";
		} else if (i % 3 == 0) {
			return "Fizz";
		} else if (i % 5 == 0) {
			return "Buzz";
		} else {
			return Integer.toString(i);
		}
	}
}