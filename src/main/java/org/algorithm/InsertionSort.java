package org.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InsertionSort {
	
	private Map<String, String> a = new HashMap<>();

	public static void main(String[] args) {

		InsertionSort is = new InsertionSort();

		char[] data = { 'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F' };
		System.out.println(Arrays.toString(data));
		is.insertionSort(data);
		System.out.println(Arrays.toString(data));
	}

	/** Insertion-sort of an array of characters into nondecreasing order */
	public void insertionSort(char[] data) {
		int n = data.length;
		for (int k = 1; k < n; k++) { // begin with second character
			char cur = data[k]; // time to insert cur=data[k]
			int j = k; // find correct index j for cur
			while (j > 0 && data[j - 1] > cur) { // thus, data[j-1] must go
													// after cur
				data[j] = data[j - 1]; // slide data[j-1] rightward
				j--; // and consider previous j for cur
			}
			data[j] = cur; // this is the proper place for cur
		}
	}
	
	public void selectionSort(char[] data) {
		int n = data.length;
		for (int k = 0; k < n; k++) { // begin with second character
			char cur = data[k]; // time to insert cur=data[k]
			int j = k; // find correct index j for cur
			while (j > 0 && data[j - 1] > cur) { // thus, data[j-1] must go
													// after cur
				data[j] = data[j - 1]; // slide data[j-1] rightward
				j--; // and consider previous j for cur
			}
			data[j] = cur; // this is the proper place for cur
		}
	}
}
