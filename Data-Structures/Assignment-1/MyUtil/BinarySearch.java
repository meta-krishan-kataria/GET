package MyUtil;

import java.util.Scanner;

class BinarySearch {
	/**
	 * binary search
	 * 
	 * @return the index of element which is equal to key
	 * */
	public static int binarySearch(int a[], int lower, int upper, int key) {

		int mid = (upper + lower) / 2;

		if (lower < upper) {
			if (a[mid] == key) {
				return mid;
			} else {
				if (key > a[mid])
					return binarySearch(a, mid + 1, upper, key);
				else
					return binarySearch(a, lower, mid - 1, key);
			}
		}
		return -1;
	}

	

}

