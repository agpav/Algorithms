package org.algo;

import java.io.FileNotFoundException;

public class QuicksortSF extends AbstractQuickSort {

	public static void main(String[] args) throws FileNotFoundException {
		QuicksortSF sf = new QuicksortSF();
		// sf.file = PATH + "test.txt";
		sf.file = PATH + "QuickSort.txt";
		sf.file = PATH + "10.txt";
		sf.file = PATH + "100.txt";
		sf.file = PATH + "1000.txt";

		// sf.file = PATH + "QuickSort_10.txt";
		// sf.file = PATH + "QuickSort_100.txt";
		// sf.file = PATH + "QuickSort_1000.txt";
		//
		sf.file = PATH + "QuickSort.txt";

		sf.run(FIRST);
		sf.run(LAST);
		sf.run(MEDIAN);

		// int[] arr = { 6, 1, 4, 9, 0, 3, 5, 2, 7, 8 };// { 8, 2, 4, 5, 7, 1 };
		// int[] arr = sf.loadFile();
		// System.out.println(Arrays.toString(arr));
		// System.out.println(sf.medianOfThree(arr, 0, arr.length));
	}

	protected int getPivot(int[] arr, int start, int end) {
		int pivot = 0;
		switch (mode) {
		case FIRST:
			pivot = start;// first element
			break;
		case MEDIAN:
			pivot = medianOfThree(arr, start, end);
			break;
		case LAST:
			pivot = end - 1;// last element
			break;
		case RANDOM:
			pivot = rnd.nextInt(end - start);// random
			break;
		}
		return pivot;
	}

	@Override
	protected long quicksort(int[] array, int start, int end) {
		// Base case: an array of size 1 or 0 is considered sorted.
		if ((end - start) < 2) {
			return 0;
		}

		long comparisons = end - start - 1;

		// Set the pivot to always be the first element of the array.
		// noinspection UnnecessaryLocalVariable
		swap(array, start, getPivot(array, start, end));

		int pivot = start;

		// Set boundaries for the "left partition" and the "right partition".
		int i = start + 1;
		int j = start + 1;

		// Partition around the pivot.
		for (; j < end; j++) {
			if (array[j] < array[pivot]) {
				swap(array, i, j);
				i++;
			}
		}

		// Put the pivot in its correct place.
		swap(array, i - 1, pivot);

		// Sort the left and right halves.
		comparisons += quicksort(array, start, i - 1);
		comparisons += quicksort(array, i, end);

		// System.out.println("Comparisions:" + comparisons);
		return comparisons;
	}

	protected int medianOfThree(int[] array, int start, int end) {

		// if (end == array.length) {
		// end = end - 1;
		// }

		int pivot = 0;

		int first = array[start];
		int middle = array[start + (end - start - 1) / 2];
		int last = array[end - 1];

		int max = Math.max(Math.max(first, middle), last);
		int min = Math.min(Math.min(first, middle), last);
		int median = first ^ middle ^ last ^ max ^ min;

		if (median == first) {
			pivot = start;
		} else if (median == middle) {
			pivot = start + (end - start - 1) / 2;
		} else {
			pivot = end - 1;
		}

		// System.out.println(Arrays.toString(array) + " Start:" + start + " End:" +
		// end);
		// System.out.println(" First:" + first + " Last:" + last + " Middle:" +
		// middle);
		// System.out.println(" Max:" + max + " Min:" + min + " Median:" + median);
		// System.out.println(" Pivot:" + pivot);

		return pivot;
	}

	@Override
	protected int partition(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int medianOf3(int[] A, int left, int right) {
		int length = right - left + 1;
		int center = 0;
		if (length % 2 == 0) {
			center = left + length / 2 - 1;
		} else
			center = left + length / 2;
		if (A[left] > A[center])
			swap(A, left, center);

		if (A[left] > A[right])
			swap(A, left, right);

		if (A[center] > A[right])
			swap(A, center, right);

		swap(A, center, right - 1);
		return right - 1;
	}
}
