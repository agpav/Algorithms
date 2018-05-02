package org.algo;

public class Karatsuba2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5678;
		int y = 1234;
		double result = divide(x, y);
		System.out.println(result);
	}

	private static double divide(int x, int y) {
		// convert to array
		String xStr = Integer.toString(x);
		String yStr = Integer.toString(y);

		// break into half
		int len = xStr.length() / 2;
		String a = xStr.substring(0, len);
		String b = xStr.substring(len, xStr.length());

		System.out.println(a + "#" + b);

		len = yStr.length() / 2;
		String c = yStr.substring(0, len);
		String d = yStr.substring(len, yStr.length());

		System.out.println(c + "#" + d);

		return karatsuba(xStr.length(), Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c),
				Integer.parseInt(d));
	}

	private static double karatsuba(int n, int a, int b, int c, int d) {

		if (Integer.toString(a).length() > 2) {
			divide(a, c);
			divide(b, d);
		}

		int ac = a * c;
		int bd = b * d;
		int quadratic = (a + b) * (c + d);
		int middle = quadratic - ac - bd;

		double product = Math.pow(10, n) * ac + Math.pow(10, n / 2) * middle + bd;

		return product;
	}
}
