package org.algo;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoSum {

	// static final String FILE =
	// "D:\\workspace\\Algorithms-SU\\data\\algo1-programming_prob-2sum3.txt";
	// static final int SIZE = 4;
	// static final int SUM1 = 0;
	// static final int SUM2 = 4;

	public static final String DIR = "./src/main/resources/";
	static final String FILE = DIR + "algo1-programming_prob-2sum.txt";
	static final int SIZE = 1000000;
	static final int SUM1 = -10000;
	static final int SUM2 = 10000;

	// static final String FILE =
	// "D:\\workspace\\Algorithms-SU\\data\\algo1-programming_prob-2sum2.txt";
	// static final int SIZE = 9;
	// static final int SUM1 = 3;
	// static final int SUM2 = 10;

	// static final String FILE =
	// "D:\\workspace\\Algorithms-SU\\data\\algo1-programming_prob-2sum4.txt";
	// static final int SIZE = 7;
	// static final int SUM1 = 30;
	// static final int SUM2 = 40;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(FILE));
		long[] arr = new long[SIZE];
		Set<Long> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLong();
			set.add(arr[i]);
		}

		int count = count(set, arr);
		System.out.println("count : " + count);
	}

	static int count(Set<Long> set, long[] arr) {
		int count = 0;
		for (int sum = SUM1; sum <= SUM2; sum++) {
			System.out.println(sum);
			if (exists(set, arr, sum)) {
				count++;
			}
		}
		return count;
	}

	static boolean exists(Set<Long> set, long[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			long lookFor = sum - arr[i];
			if (set.contains(lookFor) && lookFor != arr[i]) {
				// System.out.println("Found: " + arr[i] + "+" + lookFor + "=" + sum);
				return true;
			}
		}
		return false;
	}

}
