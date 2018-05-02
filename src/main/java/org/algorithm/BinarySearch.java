package org.algorithm;

public class BinarySearch {

	public static void main(String[] args) {
		int[] data = { 2, 4, 5, 7, 8, 9, 2, 4, 5, 7, 8, 9, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37 };
		boolean result = binarySearch(data, 22, 2, 37);
		System.out.println(result);
	}

	/**
	 * Returns true if the target value is found in the indicated portion of the
	 * data array. This search only considers the array portion from data[low]
	 * to data[high] inclusive.
	 */
	public static boolean binarySearch(int[] data, int target, int low, int high) {
		if (low > high) {
			return false; // interval empty; no match
		} else {
			int mid = (low + high) / 2;
			if (target == data[mid]) {
				return true; // found a match
			} else if (target < data[mid]) {
				return binarySearch(data, target, low, mid - 1); // recur left
																	// of the
																	// middle
			} else {
				return binarySearch(data, target, mid + 1, high); // recur right
																	// of the
																	// middle
			}
		}	
	}

}
