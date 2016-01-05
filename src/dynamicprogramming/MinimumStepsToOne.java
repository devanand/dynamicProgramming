package dynamicprogramming;

public class MinimumStepsToOne {

	static void initializeMemo(int memo[]) {
		for(int i = 0;i<memo.length;i++) {
			memo[i] = -1;
		}
	}
	
	static int minimum(int n, int memo[]) {
		if(n == 1 ) return 0;
		
		if(memo[n] != -1) return memo[n];
		
		int r = minimum(n-1, memo)+1;
		if(n%2 == 0) r = Math.min(r, 1+minimum(n/2, memo));
		if(n%3 == 0) r = Math.min(r, 1+minimum(n/3, memo));
		
		memo[n] = r;
		return r;
	}
	
	public static void main(String[] args) {
		int n=5;
		int memo[] = new int[n+1];
		initializeMemo(memo);
		System.out.println(minimum(n, memo));
	}
}

