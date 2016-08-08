import java.util.Scanner;

class BinarySearch {
	/**
	 * binary search algorithm implementation
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

	/**
	 * finds the left most occurrence of the key from the particular index
	 * 
	 * */
	public static int searchLeftMostOccurence(int[] a, int key, int currentIndex) {
		/*
		 * if looks for the immediate left element, if it is also equals to key
		 * it recurs from the left else it returns the current index
		 */
		if (currentIndex > 0) {
			if (a[currentIndex - 1] == key) {
				searchLeftMostOccurence(a, key, currentIndex - 1);
			}
		}

		return currentIndex;

	}

}
