package org.algo;

public class QuickSort1 extends AbstractQuickSort {

	public static void main(String[] args) throws Exception {
		QuickSort1 qs = new QuickSort1();
		qs.run(FIRST);
		// qs.run(MEDIAN);
		// qs.run(LAST);
	}

	private int partition1(int arr[], int left, int right) {
		int i = left + 1;
		int pivot = getPivot(arr, left, right);

		for (int j = left + 1; j <= right; j++) {
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}

		swap(arr, left, i - 1);

		return i;
	}

	protected int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int pivot = getPivot(arr, left, right);

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}

		return i;
	}

	private void quickSort1(int arr[], int left, int right) {
		if ((right - left) <= 1) {
			return;
		}

		int index = partition1(arr, left, right);

		comparisions += (index - left);
		quickSort1(arr, left, index);

		comparisions += (right - index - 1);
		quickSort1(arr, index + 1, right);
	}

	@Override
	protected long quicksort(int[] arr, int left, int right) {
		int index = partition1(arr, left, right);
		if (left < index - 1) {
			comparisions += (index - 1 - left);
			quicksort(arr, left, index - 1);
		}

		if (index < right) {
			comparisions += (right - index);
			quicksort(arr, index, right);
		}

		return comparisions;
	}
}
