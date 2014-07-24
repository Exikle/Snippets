package com.exikle.java.arrays.sortroutines;

public class SelectExchangeSort {

	public SelectExchangeSort(int listlen, int lowest, int lowpos,
			int[] a) {
		int temp;
		for (int n = 0; n < listlen; n++) {
			lowest = a[n];
			lowpos = n;
			for (int m = n + 1; m < listlen; m++) {
				if (a[m] < lowest) {
					lowest = a[m];
					lowpos = m;
				}
			}
			temp = a[n];
			a[n] = a[lowpos];
			a[lowpos] = temp;

		}
	}
}