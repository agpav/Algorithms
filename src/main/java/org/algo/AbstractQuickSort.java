package org.algo;

import java.io.FileNotFoundException;
import java.util.Random;

public abstract class AbstractQuickSort extends FileInput {

	public static final String FIRST = "FIRST";
	public static final String MEDIAN = "MEDIAN";
	public static final String LAST = "LAST";
	public static final String RANDOM = "RANDOM";

	protected long comparisions = 0;
	protected String mode = FIRST;

	protected Random rnd = new Random();

	public void run() throws FileNotFoundException {
		run(FIRST);
		run(MEDIAN);
		run(LAST);
		run(RANDOM);
	}

	public void run(String m) throws FileNotFoundException {
		int[] arr = loadFile();
		mode = m;
		comparisions = 0;
		// System.out.println("Original Input Arr: " + Arrays.toString(arr));
		System.out.println("Input Arr Length: " + arr.length);
		comparisions = quicksort(arr, 0, arr.length);
		// System.out.println("Output Arr: " + Arrays.toString(arr));
		System.out.println("Total no. of comparisions when pivot is " + mode + ": " + comparisions);
		System.out.println("----------------------------------------------------------");
	}

	protected abstract long quicksort(int[] arr, int start, int end);

	protected abstract int partition(int[] arr, int start, int end);

	protected void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	protected int getPivot(int[] arr, int start, int end) {
		int pivot = 0;
		switch (mode) {
		case FIRST:
			pivot = arr[start];// first element
			break;
		case MEDIAN:
			pivot = arr[(start + end) / 2];// median
			break;
		case LAST:
			pivot = arr[end - 1];// last element
			break;
		case RANDOM:
			pivot = rnd.nextInt(end - start);// random
			break;
		}
		return pivot;
	}
}
