package com.exikle.java.arrays.sortroutines;

public class Bubble {

	public Bubble(int listlen, int[] a) {
		int temp;
		for (int m = listlen - 1; m >= 1; m--) {

			int flag = 0;

			for (int n = 0; n < m; n++) {
				if (a[n + 1] < a[n]) {
					temp = a[n + 1];
					a[n + 1] = a[n];
					a[n] = temp;
					flag = 1;
				}
			}

			if (flag == 0)
				m = 0;
		}
	}
}
