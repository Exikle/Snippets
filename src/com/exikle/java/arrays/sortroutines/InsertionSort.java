package com.exikle.java.arrays.sortroutines;

public class InsertionSort {

	boolean flag;

	public InsertionSort(int[] a, int[] b, int listlen) {
		b[0] = a[0];

		for (int m = 1; m < listlen; m++) {
			flag = false;
			for (int n = 0; n < m; n++) {

				if (a[m] < b[n]) {
					flag = true;
					for (int o = m; o > n; o--) {
						b[o] = b[o - 1];
					}
					b[n] = a[m];
					n = m;
				}
			}
			if (flag == false)
				b[m] = a[m];
		}
	}
}