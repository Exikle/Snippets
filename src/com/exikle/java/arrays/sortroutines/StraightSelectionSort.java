package com.exikle.java.arrays.sortroutines;

public class StraightSelectionSort {

	public StraightSelectionSort(int listlen, int lowest, int lowpos,
			int[] a, int[] b) {
		for (int n = 0; n < listlen; n++) {

			lowest = a[0];
			lowpos = 0;

			for (int m = 1; m < listlen; m++) {
				if (a[m] < lowest) {
					lowest = a[m];
					lowpos = m;
				}
			}
			a[lowpos] = 999;
			b[n] = lowest;
		}
	}
}