package org.algo;

import java.io.File;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianMaintenance {

	public static final String DIR = "./src/main/resources/";
	public static final String FILE = DIR + "Median.txt";

	static final int SIZE = 10000;

	PriorityQueue<Integer> lowers;
	PriorityQueue<Integer> highers;

	public static void main(String[] args) throws Exception {
		MedianMaintenance mm = new MedianMaintenance();
		Scanner in = new Scanner(new File(FILE));
		int[] a = new int[SIZE];
		double sum = 0;
		for (int i = 0; i < SIZE; i++) {
			a[i] = in.nextInt();
			double median = mm.median(a[i]);
			sum += median;
		}
		System.out.println(sum % 10000);
		in.close();
	}

	public MedianMaintenance() {
		lowers = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -1 * o1.compareTo(o2);
			}
		});
		highers = new PriorityQueue<>();
	}

	double median(int number) {
		addNumber(number);
		rebalance();
		return getMedian();
	}

	double getMedian() {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

		if (biggerHeap.size() == smallerHeap.size()) {
			return (biggerHeap.peek() + smallerHeap.peek()) / 2.0;
		} else {
			return biggerHeap.peek();
		}
	}

	void rebalance() {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}

	void addNumber(int number) {
		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		} else {
			highers.add(number);
		}
	}
}
