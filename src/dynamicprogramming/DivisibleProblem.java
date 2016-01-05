package dynamicprogramming;

import java.util.Scanner;

public class DivisibleProblem {

	static void isDivisible(long n) {
		long m=n;
		while(true) {
			long digits = condition(n); 
			if( digits != -1) {
				System.out.println(digits);
				break;
			}
			n = n+m;
		}
	}
	
	static long condition(long n) {
		long s = 0;
		long m = 1;
		long digits = 0;
		for(;n>0;n /= 10) {
			digits++;
			if((n%10) == 0) {
				return -1;
			}
				s = s+(n%10);
				m = m*(n%10);
		}
		
		if(s>=m) {
			return digits;
		}
		return -1;
	}
	public static void main(String[] args) {
		isDivisible(Integer.parseInt(new Scanner(System.in).nextLine()));
	}
}
