package dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	
	
	public static BigInteger fibonacci(BigInteger first, BigInteger second, int i, int limit) {
		if (i == limit) return second;
		
		BigInteger third = (second.multiply(second)).add(first);
		return fibonacci(second, third, ++i, limit);
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String temp[] = in.nextLine().split(" ");
		BigInteger first = BigInteger.valueOf(Integer.parseInt(temp[0]));
		BigInteger second = BigInteger.valueOf(Integer.parseInt(temp[1]));
		int limit = Integer.parseInt(temp[2]);
		in.close();
		System.out.println(fibonacci(first, second, 2, limit));
		
	}
}
