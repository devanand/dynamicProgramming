package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	static void increasingSubsequence(int a[]) {
		int memo[]=new int[a.length];
		
		for(int i=0;i<memo.length;i++) {
			memo[i] = 1;
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<a.length;i++) {
			for(int j=0;j<i;j++) {
				if(a[j]<a[i]) {
					if(memo[i]<memo[j]+1) {
						memo[i] = memo[j]+1;
					}
				}
			}
			if(memo[i]>max) {
				max = memo[i];
			}
			
		}
		
		
		System.out.println(Arrays.toString(memo));
		
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		int a[] = {9,5,2,8,7,3,1,6,4,5};
		increasingSubsequence(a);
	}
}
