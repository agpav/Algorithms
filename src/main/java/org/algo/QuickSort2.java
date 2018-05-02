package org.algo;

import java.io.FileNotFoundException;

public class QuickSort2 extends AbstractQuickSort {

	int count = 0;

	public static void main(String[] args) throws FileNotFoundException {
		QuickSort2 sf = new QuickSort2();
		// sf.file = PATH + "test.txt";
		// sf.file = PATH + "QuickSort.txt";
		sf.file = PATH + "10.txt";
		// sf.file = PATH + "100.txt";
		// sf.file = PATH + "1000.txt";

		// sf.run(FIRST);
		// sf.run(LAST);
		sf.run(MEDIAN);

		// int[] arr = { 6, 1, 4, 9, 0, 3, 5, 2, 7, 8 };// { 8, 2, 4, 5, 7, 1 };
		// int[] arr = sf.loadFile();
		// System.out.println(Arrays.toString(arr));
		// System.out.println(sf.medianOfThree(arr, 0, arr.length));
	}

	public void run(String m) throws FileNotFoundException {
		int[] arr = loadFile();
		mode = m;
		comparisions = 0;
		// System.out.println("Original Input Arr: " + Arrays.toString(arr));
		System.out.println("Input Arr Length: " + arr.length);
		quickSort1(arr, 0, arr.length);
		// System.out.println("Output Arr: " + Arrays.toString(arr));
		System.out.println("Total no. of comparisions when pivot is " + mode + ": " + count);
		System.out.println("----------------------------------------------------------");
	}

	public void quickSort1(int[] A, int l, int r) {
		if (r - l <= 0) {
			return;
		} else {

			int p = partitionAndCount(A, l, r);
			quickSort1(A, l, p - 1);
			quickSort1(A, p + 1, r);
		}
	}

	public int partitionAndCount(int[] A, int l, int r) {
		if (r - l >= 1) {
			int median = medianOf3(A, l, r);
			swap(A, l, median);
			int pivot = A[l];
			count = count + (r - l);
			int i = l + 1;
			for (int j = l + 1; j <= r; j++) {
				if (A[j] < pivot) {
					swap(A, i, j);
					i++;
				}
			}
			swap(A, i - 1, l);

			return i - 1;
		} else {
			return 0;
		}
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

	@Override
	protected long quicksort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int partition(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		return 0;
	}

}
