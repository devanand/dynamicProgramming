package dynamicprogramming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShortPalin {


	static int shortPalin(String str) {
		char strTemp[] = str.toCharArray();
		int n = strTemp.length;
		int memo[][] = new  int[n][n];
		int low=0, high=0, fill = 0;
		for(fill = 1;fill<n;fill++) {
			for(low = 0, high= fill;high<n;low++, high++) {
				memo[low][high] = (strTemp[low] == strTemp[high])?memo[low+1][high-1]:
													(Math.min(memo[low][high-1], memo[low+1][high])+1);
			}
		}
		return memo[0][n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(shortPalin("abod"));
	}
}
