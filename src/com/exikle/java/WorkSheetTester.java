package com.exikle.java;

/*
 * WorkSheetTester.java
 * Dixon D'Cunha
 * 9/11/2012
 * ICS 4U1
 */

// Import Area
public class WorkSheetTester {

	/**
	 * Takes question and does them to confirm written answers
	 */
	public static void main(String[] args) {
		new WorkSheetTester();
	}

	public WorkSheetTester() {
		// Java "String" Discovery Sheet
		String s;
		s = "The quick brown fox";

		int len = s.length();
		System.out.println(len);

		String firstPart = s.substring(0, 9);
		System.out.println(firstPart);

		String b = "";
		for (int x = len - 1; x > 0; x--)
			b += s.charAt(x);
		System.out.println(b);
	}
}
