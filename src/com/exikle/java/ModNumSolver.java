package com.exikle.java;

import java.util.Random;

/**
 * Written to figure out how to get 1-5 as a value from modulos +1
 * 
 * @author Dixon D'Cunha
 * 
 */
public class ModNumSolver {
	static final int TIMES_RUN = 20; // The amount of times to fun
	static int[] counter; // A counter to see how many times a value pops up

	public static void main(String[] args) {
		counter = new int[5];

		for (int x = 0; x < TIMES_RUN; x++) {
			int i = Math.abs(new Random().nextInt() % 5);
			counter[i] += 1; // adds one to the counter
			i += 1;
			if (i > 5) { // Just in case the program breaks
				System.out.println("Meh, I Broke");
			} else {
				// System.out.println("Num: " + i); //Pops out the value
				// generated
			}
		}

		for (int x = 0; x < 5; x++) {
			System.out.println((x + 1) + " came up: " + counter[x]);
		}
	}
}