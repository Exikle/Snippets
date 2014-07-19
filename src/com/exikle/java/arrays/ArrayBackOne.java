package com.exikle.java.arrays;

/**
 * Moves an array left one. First number becomes last number.
 * 
 * @author Dixon D'Cunha (Exikle)
 */
public class ArrayBackOne {

	public static void main(String[] args) {
		int[] orgArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };// array with dev defined amount of numbers
		int len = orgArray.length;// length of array
		int[] newArray = new int[len];// array to hold new number order
		int temp = orgArray[len - 1];// temporarily holds the first number to move it to the end

		for (int x = 1; x < len; x++)
			newArray[x] = orgArray[x - 1];

		newArray[0] = temp;

		for (int j = 0; j < orgArray.length; j++) {
			System.out.print(newArray[j] + "|");
		}
	}
}