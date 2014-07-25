package com.exikle.java;

/**
 * StringReverser.java
 * 
 * @author Dixon D'Cunha (Exikle)
 * @version 9/11/2012
 */
public class StringReverser {

	public static void main(String[] args) {
		reverse("The quick brown fox.");
	}

	/**
	 * Reverses the string and outputs;
	 * 
	 * @param str
	 */
	private static void reverse(String str) {
		int len = str.length();

		String b = "";
		for (int x = len - 1; x > -1; x--)
			b += str.charAt(x);
		System.out.println("ORIGINAL:" + str);
		System.out.println("REVERSED:" + b);

	}
}
