package org.algo;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MM {

	public static final String DIR = "./src/main/resources/";
	public static final String FILE = DIR + "Median.txt";

	static final int SIZE = 10000;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(FILE));
		int[] list = new int[SIZE];
		long sum = 0;
		for (int i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
			Arrays.sort(list, 0, i + 1);
			sum += list[i / 2];
		}
		System.out.println(sum % 10000);
		sc.close();
	}
}
