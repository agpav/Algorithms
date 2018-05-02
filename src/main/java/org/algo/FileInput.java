package org.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {

	public static final String PATH = "./src/main/resources/";
	protected String file = "";

	protected int[] loadFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
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
