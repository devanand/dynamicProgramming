package dynamicprogramming;

import java.util.Scanner;

public class CandieDistribution {

	static int candies(int grades[], int i, int memo[]) {
		if(i-1<0 && (i+1)>=grades.length) {
			return memo[i] = 1;
		}
		
		if(memo[i] != 0) {
			return memo[i];
		}
		
		if(i==0) {
			if(grades[i] > grades[i+1]) {
				return memo[i] = (1+candies(grades,i+1, memo));
			} else {
				return memo[i] = 1;
			} 
		}
		
		if(i== grades.length-1) {
			if(grades[i] > grades[i-1]) {
				return memo[i] = (1+candies(grades,i-1, memo));
			} else {
				return memo[i] = 1;
			}
		}
		
		
		
		if((grades[i] <= grades[i-1]) && (grades[i] <= grades[i+1])) {
			return memo[i] = 1;
		}
		
		if(grades[i]>grades[i+1] && grades[i]<=grades[i-1]) {
			return memo[i] = (1+candies(grades, i+1, memo));
		}
		
		if(grades[i]>grades[i-1] && grades[i]<=grades[i+1]) {
			return memo[i] = (1+candies(grades, i-1, memo));
		}
		
		if(grades[i]>grades[i-1] && grades[i]>grades[i+1]) {
			return memo[i] = 1+(candies(grades, i-1, memo)>candies(grades, i+1, memo)?candies(grades, i-1, memo):candies(grades, i+1, memo));
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = Integer.parseInt(s.nextLine());
		int grades[] = new int[l];
		int memo[] = new int[l];
		
		for(int i=0;i<l;i++) {
			int temp = Integer.parseInt(s.nextLine());
			grades[i] = temp;
		}
		int temp = 0;
		for(int i=0;i<l;i++) {
			candies(grades, i, memo);
			temp += memo[i];
		}
		
		System.out.println(temp);
	}
}
