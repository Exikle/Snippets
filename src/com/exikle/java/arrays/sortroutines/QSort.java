package com.exikle.java.arrays.sortroutines;

public class QSort {

	public void doQSort(int a[], int start, int finish) {
		int lo = start;
		int hi = finish + 1;
		int flag = 0;

		if (lo >= hi) {
			return;
		}
		int pivot = a[lo];
		while (lo < hi) {
			flag = 0;
			while (lo < hi && flag == 0) {
				hi--;
				if (a[hi] < pivot) {
					flag = 1;
					a[lo] = a[hi];
				}

			}
			flag = 0;
			while (lo < hi && flag == 0) {
				lo++;
				if (a[lo] > pivot) {
					flag = 1;
					a[hi] = a[lo];
				}
			}
		}
		if (lo == hi) {
			a[hi] = pivot;
		}
		doQSort(a, start, lo - 1);
		doQSort(a, hi + 1, finish);
	}
}