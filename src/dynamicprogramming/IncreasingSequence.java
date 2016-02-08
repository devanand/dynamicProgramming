package dynamicprogramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class IncreasingSequence {
	static void increasingSequence(BigInteger a[]) {
		long change=0;
		for(int i=1;i<a.length;i++) {
			if(a[i].compareTo(a[i-1]) == -1 || a[i].compareTo(a[i-1]) == 0) {
				a[i] = a[i-1].add(BigInteger.ONE);
				change++;
			}
		}
		System.out.println(change);
	}
	
	public static void main(String[] args) throws Exception {
		/*File f = new File(SkiingChallenge.class.getResource("input.txt").getFile());
		FileReader f1 = new FileReader(f);
		BufferedReader b = new BufferedReader(f1);
		String line = b.readLine();
		
		BigInteger a[]=new BigInteger[Integer.parseInt(line)];
		int skip=0, k=0;
		while(line != null) {
			if(skip==0) {
				skip++;
				line = b.readLine();
				continue;
			}
			String temp[] = line.split(" ");
			for(int l=0;l<temp.length;l++) {
				a[l] = BigInteger.valueOf(Integer.parseInt(temp[l]));
			}
			k++;
			line = b.readLine();
		}*/
		int a[] = {1, 2, 2, 3, 4};
		BigInteger a1[]=new BigInteger[a.length];
		for(int i=0;i<a.length;i++) {
			a1[i] = BigInteger.valueOf(a[i]);
		}
		increasingSequence(a1);
		for(int i=0;i<a.length;i++) {
			System.out.println(a1[i]);
		}
	}
}
