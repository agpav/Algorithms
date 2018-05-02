
/******************************************************************************
 *  Compilation:  javac Karatsuba.java
 *  Execution:    java Karatsuba N
 *  
 *  Multiply two positive N-bit BigIntegers using Karatsuba multiplication.
 *
 *
 *  % java Karatsuba N
 *
 ******************************************************************************/
package org.algo;

import java.math.BigInteger;

class Karatsuba {

	public static BigInteger karatsuba(BigInteger x, BigInteger y) {

		// cutoff to brute force
		int N = Math.max(x.bitLength(), y.bitLength());
		if (N <= 1) {// 2000
			return x.multiply(y); // optimize this parameter
		}

		// number of bits divided by 2, rounded up
		N = (N / 2) + (N % 2);

		// x = a + 2^N b, y = c + 2^N d
		BigInteger b = x.shiftRight(N);
		BigInteger a = x.subtract(b.shiftLeft(N));
		BigInteger d = y.shiftRight(N);
		BigInteger c = y.subtract(d.shiftLeft(N));

		// compute sub-expressions
		BigInteger ac = karatsuba(a, c);
		BigInteger bd = karatsuba(b, d);
		BigInteger abcd = karatsuba(a.add(b), c.add(d));

		return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
	}

	public static void main(String[] args) {
		BigInteger a = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
		BigInteger b = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");

		System.out.println(a.bitLength());
		System.out.println(b.bitLength());

		long start, stop;
		start = System.currentTimeMillis();
		BigInteger c = karatsuba(a, b);
		stop = System.currentTimeMillis();
		System.out.println(stop - start);

		start = System.currentTimeMillis();
		BigInteger d = a.multiply(b);
		stop = System.currentTimeMillis();
		System.out.println(stop - start);

		System.out.println((c.equals(d)));

		System.out.println(c);
		System.out.println(d);

	}
}