package org.algo;

public class Quicksort extends AbstractQuickSort {

	@Override
	protected int partition(int[] arr, int start, int end) {
		int pivot = getPivot(arr, start, end);
		boolean flag = false;
		for (int i = start + 1; i < end; i++) {
			if (arr[i] < arr[start] || (arr[i] == arr[start] && (flag = !flag)))
				swap(arr, ++pivot, i);
		}
		swap(arr, start, pivot);
		return pivot;
	}

	protected long quicksort(int[] arr, int start, int end) {
		if (start >= end - 1)
			return 0;
		// swap(start, start + rnd.nextInt(end - start));
		int pivot = partition(arr, start, end);

		comparisions += (pivot - start);
		quicksort(arr, start, pivot);

		comparisions += (end - pivot - 1);
		quicksort(arr, pivot + 1, end);

		return comparisions;
	}

}
