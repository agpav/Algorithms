package org.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountingInversions {

	public static final String DIR = "./src/main/resources/";
	public static final String FILE =
			// "test.txt";
			"IntegerArray.txt";

	public static void main(String[] args) throws Exception {
		int[] arr = loadFile();
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
		System.out.println(countInversions(arr));
	}

	/**
	 * Returns the number of inversions in the input array
	 * 
	 * @param a
	 *            the input array
	 * @return the number of inversions.
	 */
	public static long countInversions(int[] a) {
		return mergeSort(a, 0, a.length);
	}

	private static long mergeSort(int[] a, int low, int high) {
		if (low == high - 1)
			return 0;

		int mid = (low + high) / 2;

		return mergeSort(a, low, mid) + mergeSort(a, mid, high) + merge(a, low, mid, high);
	}

	private static long merge(int[] a, int low, int mid, int high) {
		long count = 0;
		int[] temp = new int[a.length];

		for (int i = low, lb = low, hb = mid; i < high; i++) {

			if (hb >= high || lb < mid && a[lb] <= a[hb]) {
				temp[i] = a[lb++];
			} else {
				count = count + (mid - lb);
				temp[i] = a[hb++];
			}
		}

		System.arraycopy(temp, low, a, low, high - low);

		return count;
	}

	private static int[] loadFile() throws FileNotFoundException, URISyntaxException {
		Scanner sc = new Scanner(new File(DIR + FILE));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		sc.close();

		String[] arr = lines.toArray(new String[0]);

		int[] resultsInt = new int[lines.size()];
		for (int i = 0; i < arr.length; i++) {
			resultsInt[i] = Integer.parseInt(arr[i]);
		}

		return resultsInt;
	}
}
